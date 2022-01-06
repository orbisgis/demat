package org.orbisgis.demat.vega.transform;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.orbisgis.demat.vega.encoding.ToolTipField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonDeserialize(using = GroupBy.Deserializer.class)
@JsonSerialize(using = GroupBy.Serializer.class)
public class GroupBy {
    List<String> fields;

    public GroupBy(String... fields){
        this.fields = Arrays.asList(fields);
    }

    public GroupBy(){
        this.fields = new ArrayList<String>();
    }

    public void add(String field){
        this.fields.add(field);
    }

    static class Deserializer extends JsonDeserializer<GroupBy> {
        @Override
        public GroupBy deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            GroupBy groupBy = new GroupBy();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case START_ARRAY:
                    groupBy.fields = jsonParser.readValueAs(new TypeReference<List<String>>() {
                    });
                    break;
                default:
                    throw new IOException("Cannot deserialize GroupBy field");
            }
            return groupBy;
        }
    }

    static class Serializer extends JsonSerializer<GroupBy> {

        @Override
        public void serialize(GroupBy groupBy, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (groupBy != null) {
                jsonGenerator.writeObject(groupBy.fields);
                return;
            }
            jsonGenerator.writeNull();
        }
    }



}
