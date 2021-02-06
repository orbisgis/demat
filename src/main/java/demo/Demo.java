package demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        field.stringValue="test";
        System.out.println(field.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Data data = new Data();
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        Map<String, Object> values = new HashMap<>();
        values.put("a", 1);
        values.put("b", 2);
        values.put("c", 3);
        urlDataInlineDataset.anythingMapValue = values;

        InlineDataset inlineDataset = new InlineDataset();
        inlineDataset.anythingMapValue=values;

        Map<String, Object> values2 = new HashMap<>();
        values2.put("a", 10);
        values2.put("b", 20);
        values2.put("c", 30);
        InlineDataset inlineDataset2 = new InlineDataset();
        inlineDataset2.anythingMapValue=values2;

        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        inlines.add(inlineDataset);
        inlines.add(inlineDataset2);
        urlDataInlineDataset.unionArrayValue = inlines;

        data.setValues(urlDataInlineDataset);

        objectMapper.writeValue(new File("/tmp/test2.json"), data);

        XClass xClass = new XClass();
        xClass.setField(field);
        xClass.setType(Type.QUANTITATIVE);
        objectMapper.writeValue(new File("/tmp/test3.json"), xClass);
    }

    /**
     *
     * @param path
     * @param objectMapper
     * @throws IOException
     */
    public  void largeJSON(String path, ObjectMapper objectMapper) throws IOException {
        JsonFactory jsonfactory = new JsonFactory();
        File jsonDoc = new File(path);
        JsonGenerator generator = jsonfactory.createGenerator(jsonDoc,
                JsonEncoding.UTF8);
        objectMapper.writeValue(generator,objectMapper);
        generator.close();
    }
}
