package org.orbisgis.demat;

import org.orbisgis.demat.vega.DataValues;
import org.orbisgis.demat.vega.InlineDataset;
import org.orbisgis.demat.vega.Data;

import java.io.IOException;
import java.util.*;

public class ViewUtils {


    public static Data urlData(LinkedHashMap values){
        Data urlData = new Data();
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.anythingMapValue=values;
        urlData.setValues(urlDataInlineDataset);
        return urlData;
    }

    public static Data urlData(Object[][] values){
        Data urlData = new Data();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }


    public static Data urlData(List<Map> values){
        Data urlData = new Data();
        urlData.setValues(urlDataInlineDataset(values));
        return urlData;
    }

    public static DataValues urlDataInlineDataset(List<Map> values) {
        List<InlineDataset> inlines = new ArrayList<InlineDataset>();
        for (Map map :values) {
            InlineDataset inlineDataset = new InlineDataset();
            inlineDataset.anythingMapValue=map;
            inlines.add(inlineDataset);
        }
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

    public static DataValues urlDataInlineDataset(Object[][] values){
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
        DataValues urlDataInlineDataset = new DataValues();
        urlDataInlineDataset.unionArrayValue=inlines;
        return urlDataInlineDataset;
    }

    /**
     * Method to open a browser
     * Used by ImageJ
     *
     * @param url
     * @throws Exception
     */
    public static void  openBrowser( String url) throws Exception {
        if (url==null || url.isEmpty()){
            throw new RuntimeException("The URL cannot be null or empty");
        }
        String osname = System.getProperty("os.name");
        boolean isWin = osname.startsWith("windows");
        boolean isMac = !isWin && osname.startsWith("mac");
        if (isMac) {
            Runtime.getRuntime().exec("open " + url);
        }else if (isWin) {
            String cmd = "rundll32 url.dll,FileProtocolHandler " + url;
            if (osname.startsWith("Windows 2000"))
                cmd = "rundll32 shell32.dll,ShellExec_RunDLL " + url;
            Process process = Runtime.getRuntime().exec(cmd);
            // This avoids a memory leak on some versions of Java on Windows.
            // That's hinted at in <http://developer.java.sun.com/developer/qow/archive/68/>.
            try {
                process.waitFor();
                process.exitValue();
            } catch (InterruptedException ie) {
                throw new IOException("InterruptedException while launching browser: " + ie.getMessage());
            }
        } else {
            // Assume Linux or Unix
            // Based on BareBonesBrowserLaunch (http://www.centerkey.com/java/browser/)
            // The utility 'xdg-open' launches the URL in the user's preferred browser,
            // therefore we try to use it first, before trying to discover other browsers.
            String[] browsers = {"xdg-open", "netscape", "firefox", "konqueror", "mozilla", "opera", "epiphany", "lynx" };
            String browserName = null;
            try {
                for (int count=0; count<browsers.length && browserName==null; count++) {
                    String[] c = new String[] {"which", browsers[count]};
                    if (Runtime.getRuntime().exec(c).waitFor()==0)
                        browserName = browsers[count];
                }
                if (browserName==null) {
                    throw new RuntimeException("Could not find a browser");
                }else {
                    Runtime.getRuntime().exec(new String[]{browserName, url});
                }
            } catch (Exception e) {
                throw new IOException("Exception while launching browser: " + e.getMessage());
            }
        }
    }
}
