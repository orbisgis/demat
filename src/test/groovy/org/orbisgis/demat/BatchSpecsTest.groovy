import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import org.orbisgis.demat.FileUtils

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors
import static org.orbisgis.demat.Plot.*

class BatchSpecsTest {

    @TempDir(cleanup = CleanupMode.ALWAYS)
    static File folder


    /**
     * Enable this test to run all vega test cases
     */
    @Disabled
    @Test
    void runBatchTest(){
        String data_path =new File(BatchSpecsTest.getResource("data").toURI()).getAbsolutePath()
        Path specs_path =new File(BatchSpecsTest.getResource("specs").toURI()).toPath()
        //specs_path = new File("/tmp/specs/geo_custom_projection.vl.json").toPath()
        List<Path> specs = Files.walk(specs_path)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList())
        specs.each {it->
            String fileName = it.toFile().getName()
            //Do not draw in svg interactive vega spec
            if(!fileName.startsWith("interactive")) {
                def jsonSpec = FileUtils.json(it.toFile())
                findDeep(jsonSpec, "data", data_path)
                try {
                    println("Rendering spec ${fileName}")
                    //toJSON(jsonSpec,File.createTempFile(fileName, ".json", folder) )
                    toSVG(jsonSpec, File.createTempFile(fileName, ".svg", folder))
                    //toPNG(jsonSpec, File.createTempFile(fileName, ".png", folder))
                    println("Spec ${fileName} rendered")
                }
                catch (Exception ex) {
                    println("Error on " + it)
                }
            }
        }
    }

    static def replace (Map data, String key, String data_path) {
            String url = data."url"
            if (url) {
                if (url.startsWith("data") && url.endsWith(".json")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.json(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                } else if (url.startsWith("data") && url.endsWith(".csv")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.csv(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                } else if (url.startsWith("data") && url.endsWith(".tsv")) {
                    //Let's replace it with local values
                    //Remove data/
                    def data_json = FileUtils.tsv(new File("${data_path}${File.separator}${url.substring(5)}"))
                    data.remove("url")
                    data.put("values", data_json)
                }
            }
    }

    static def findDeep(def m, String key, String data_path) {

        if (m instanceof List) {
            m.each { it ->
                findDeep(it, key, data_path)
            }
        } else if (m instanceof Map) {
            m.each { k, v ->
                if (k == key) {
                    replace(v, key, data_path)
                    //findDeep(v, key, data_path)
                } else {
                    findDeep(v, key, data_path)
                }
            }
        }
    }
}
