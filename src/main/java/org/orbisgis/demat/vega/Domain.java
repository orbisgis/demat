/*
 * DEMAT is java wrapper on top of the vega-lite library
 *
 * Demat is breton word to said "Hello".
 *
 * DEMAT is part of the OrbisGIS platform.
 *
 * OrbisGIS platform is a set of open source tools to access, process, display
 * and share geographical informations.
 *
 * It is leaded by CNRS within the French Lab-STICC laboratory <http://www.lab-sticc.fr/>,
 * DECIDE team of Vannes.
 *
 * OrbisGIS is dedicated to research in GIScience.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 *
 * DEMAT is distributed under LGPL 3 license.
 *
 * Copyright (C) 2021 CNRS (Lab-STICC UMR CNRS 6285)
 *
 *
 * DEMAT is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * DEMAT is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * DEMAT. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.demat.vega;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Customized domain values in the form of constant values or dynamic values driven by a
 * selection.
 *
 * 1) Constant `domain` for _quantitative_ fields can take one of the following forms:
 *
 * - A two-element array with minimum and maximum values. To create a diverging scale, this
 * two-element array can be combined with the `domainMid` property. - An array with more
 * than two entries, for [Piecewise quantitative
 * scales](https://vega.github.io/vega-lite/docs/scale.html#piecewise). - A string value
 * `"unaggregated"`, if the input field is aggregated, to indicate that the domain should
 * include the raw data values prior to the aggregation.
 *
 * 2) Constant `domain` for _temporal_ fields can be a two-element array with minimum and
 * maximum values, in the form of either timestamps or the [DateTime definition
 * objects](https://vega.github.io/vega-lite/docs/types.html#datetime).
 *
 * 3) Constant `domain` for _ordinal_ and _nominal_ fields can be an array that lists valid
 * input values.
 *
 * 4) To combine (union) specified constant domain with the field's values, `domain` can be
 * an object with a `unionWith` property that specify constant domain to be combined. For
 * example, `domain: {unionWith: [0, 100]}` for a quantitative scale means that the scale
 * domain always includes `[0, 100]`, but will include other values in the fields beyond
 * `[0, 100]`.
 *
 * 5) Domain can also takes an object defining a field or encoding of a selection that
 * [interactively
 * determines](https://vega.github.io/vega-lite/docs/selection.html#scale-domains) the scale
 * domain.
 */
@JsonDeserialize(using = Domain.Deserializer.class)
@JsonSerialize(using = Domain.Serializer.class)
public class Domain {
    public List<Object> values;
    public DomainUnionWith domainUnionWithValue;
    public String value;

    static class Deserializer extends JsonDeserializer<Domain> {
        @Override
        public Domain deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Domain value = new Domain();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    value.value = string;
                    break;
                case START_ARRAY:
                    value.values = jsonParser.readValueAs(List.class);
                    break;
                case START_OBJECT:
                    value.domainUnionWithValue = jsonParser.readValueAs(DomainUnionWith.class);
                    break;
                default: throw new IOException("Cannot deserialize DomainUnion");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<Domain> {
        @Override
        public void serialize(Domain obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.values != null) {
                jsonGenerator.writeObject(obj.values);
                return;
            }
            if (obj.domainUnionWithValue != null) {
                jsonGenerator.writeObject(obj.domainUnionWithValue);
                return;
            }
            if (obj.value != null) {
                jsonGenerator.writeObject(obj.value);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
