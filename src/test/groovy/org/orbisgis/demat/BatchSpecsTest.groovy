import com.caoccao.javet.exceptions.JavetException
import com.caoccao.javet.interop.NodeRuntime
import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.node.modules.NodeModuleModule
import com.caoccao.javet.utils.JavetOSUtils
import com.caoccao.javet.values.V8Value
import com.caoccao.javet.values.reference.V8ValueObject
import com.caoccao.javet.values.reference.V8ValuePromise
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.orbisgis.demat.Read

import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Collectors
import static org.orbisgis.demat.Plot.*

class BatchSpecsTest {

    //@TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder

    @BeforeAll
    static void init() {
        folder = new File("/tmp/")
        folder.mkdir()
    }

    @Test
    void runBatchTest(){
        String data_path =new File(BatchSpecsTest.getResource("data").toURI()).getAbsolutePath()
        Path specs_path =new File(BatchSpecsTest.getResource("specs").toURI()).toPath()
       // specs_path = new File("/tmp/data/airport_connections.vl.json").toPath()
        List<Path> specs = Files.walk(specs_path)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList())
        specs.each {it->
            def jsonSpec= Read.json(it.toFile())
            findDeep(jsonSpec, "data", data_path)
           try {
               toSVG(jsonSpec, File.createTempFile(it.toFile().getName(), ".svg", folder))
               //toJSON(jsonSpec,File.createTempFile(it.toFile().getName(), ".json", folder) )
            }
            catch (Exception ex){
                println("Error on " + it)
            }
        }
    }

    static def findDeep(def m, String key, String data_path) {
        if (m instanceof Map && m.containsKey(key)) {
            def data = m[key]
            String url =data."url"
            if (url){
                if( url.startsWith("data") && url.endsWith(".json")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = Read.json(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                }else if(url.startsWith("data") && url.endsWith(".csv")){
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = Read.csv(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                }
            }

        }else if(m instanceof List){
            m.each {it->
                findDeep(it, key, data_path)
            }
        }
        else if(m instanceof Map){
            m.findResult { k, v ->
                if (v instanceof Map || v instanceof List) {
                    findDeep(v, key,data_path)
                }
            }
        }
    }
}
