package org.orbisgis.demat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.orbisgis.demat.v4.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;

public class Chart {


    private Coordinate coordinate ;

    public Chart description(String value) {
        coordinate.setDescription(value);
        return this;
    }

    public Chart name(String value) {
        coordinate.setName(value);
        return this;
    }

    public Chart data(Object[][] values) {
        coordinate.setData(Demat.urlData(values));
        return this;
    }

    public Chart data(List<Map> values) {
        coordinate.setData(Demat.urlData(values));
        return this;
    }

    public Chart data(URLData data) {
        coordinate.setData(data);
        return this;
    }

    public Chart encoding(Encoding encoding) {
        coordinate.setEncoding(encoding);
        return this;
    }

    public Chart mark_geoshape() {
        AnyMark anyMark = new AnyMark();
        anyMark.stringValue = "geoshape";
        coordinate.setMark(anyMark);
        return this;
    }

    public Chart mark_bar() {
        AnyMark anyMark = new AnyMark();
        anyMark.stringValue = "bar";
        coordinate.setMark(anyMark);
        return this;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate =coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Save into an html file
     * @param path
     * @return
     */
    public String save(String path) throws IOException {
        return save(path, false);
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this.coordinate);
    }

    /**
     * Save into an html file
     * @param path
     * @param delete
     * @return
     */
    public String save(String path, boolean delete) throws IOException {
        if(path==null || path.isEmpty()){
            return null;
        }
        File outputFile = new File(path);
        if(outputFile.exists() ){
            if(delete){
                outputFile.delete();
            }
            else{
                return null;
            }
        }
        StringBuilder json =  new StringBuilder("var spec =\n");
        json.append(toJson()).append(";\n var opt = {\"renderer\": \"canvas\", \"actions\": true};\n" +
                " vegaEmbed(\"#vis\", spec, opt);");
        FileWriter fileWriter = new FileWriter(outputFile);
        html(
                head(
                        meta().withCharset("UTF-8"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega@5.17.0"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega-lite@4.17.0"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/vega-embed@6.12.2")
                ),
                body (
                        div().withId("vis"),
                        script(rawHtml(json.toString()))

                )
        ).render(fileWriter);
        fileWriter.close();
        return outputFile.getAbsolutePath();
    }
}
