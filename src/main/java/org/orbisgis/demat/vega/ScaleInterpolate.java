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

import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * The interpolation method for range values. By default, a general interpolator for
 * numbers, dates, strings and colors (in HCL space) is used. For color ranges, this
 * property allows interpolation in alternative color spaces. Legal values include `rgb`,
 * `hsl`, `hsl-long`, `lab`, `hcl`, `hcl-long`, `cubehelix` and `cubehelix-long` ('-long'
 * variants use longer paths in polar coordinate spaces). If object-valued, this property
 * accepts an object with a string-valued _type_ property and an optional numeric _gamma_
 * property applicable to rgb and cubehelix interpolators. For more, see the [d3-interpolate
 * documentation](https://github.com/d3/d3-interpolate).
 *
 * * __Default value:__ `hcl`
 */
@JsonDeserialize(using = ScaleInterpolate.Deserializer.class)
@JsonSerialize(using = ScaleInterpolate.Serializer.class)
public class ScaleInterpolate {
    public Expression expressionValue;
    public ScaleInterpolateEnum enumValue;

    static class Deserializer extends JsonDeserializer<ScaleInterpolate> {
        @Override
        public ScaleInterpolate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            ScaleInterpolate value = new ScaleInterpolate();
            switch (jsonParser.currentToken()) {
                case VALUE_NULL:
                    break;
                case VALUE_STRING:
                    String string = jsonParser.readValueAs(String.class);
                    try {
                        value.enumValue = ScaleInterpolateEnum.forValue(string);
                    } catch (Exception ex) {
                        // Ignored
                    }
                    break;
                case START_OBJECT:
                    value.expressionValue = jsonParser.readValueAs(Expression.class);
                    break;
                default: throw new IOException("Cannot deserialize ScaleInterpolate");
            }
            return value;
        }
    }

    static class Serializer extends JsonSerializer<ScaleInterpolate> {
        @Override
        public void serialize(ScaleInterpolate obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (obj.expressionValue != null) {
                jsonGenerator.writeObject(obj.expressionValue);
                return;
            }
            if (obj.enumValue != null) {
                jsonGenerator.writeObject(obj.enumValue);
                return;
            }
            jsonGenerator.writeNull();
        }
    }
}
