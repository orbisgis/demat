package org.orbisgis.demat;

import org.orbisgis.demat.v4.InlineDataset;
import org.orbisgis.demat.v4.URLData;
import org.orbisgis.demat.v4.URLDataInlineDataset;

import java.util.*;

public class ViewUtils {


    public static URLData urlData(LinkedHashMap values){
        URLData  urlData = new URLData();
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        urlDataInlineDataset.anythingMapValue=values;
        urlData.setValues(urlDataInlineDataset);
        return urlData;
    }

    public static URLData urlData(Object[][] values){
        URLData  urlData = new URLData();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static URLData urlData(List<Map> values){
        URLData  urlData = new URLData();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static URLDataInlineDataset urlDataInlineDataset(List<Map> values) {
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        for (Map map :values) {
            InlineDataset inlineDataset = new InlineDataset();
            inlineDataset.anythingMapValue=map;
            inlines.add(inlineDataset);
        }
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

    public static URLDataInlineDataset urlDataInlineDataset(Object[][] values){
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        Object[] firstRow = values[0];
        for (int i = 1; i < values.length ; i++) {
            InlineDataset inlineDataset = new InlineDataset();
            Map<String, Object> rows = new HashMap<>();
            Object[] cols = values[i];
            for (int j = 0; j < values.length ; j++) {
                rows.put(String.valueOf(firstRow[j]), cols[j]);
            }
            inlineDataset.anythingMapValue= rows;
            inlines.add(inlineDataset);
        }
        URLDataInlineDataset urlDataInlineDataset = new URLDataInlineDataset();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }
}
