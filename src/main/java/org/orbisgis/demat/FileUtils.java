package org.orbisgis.demat;

import java.io.*;

public class FileUtils {

    public static final int DEFAULT_BUFFER_SIZE = 16384;

    public static final String[] JS_FILES = new String[]{
            "vega.js", "vega-lite.js",
            "vega-embed.js"
    };

    public static final String JS_FOLDER = "js";

    public static void deployJSFiles(File scriptDir) throws IOException {
        File jsFolder = new File(scriptDir, JS_FOLDER);
        if (!jsFolder.exists()) {
            if (!jsFolder.mkdirs()) {
                throw new IOException("Can't create js folder '" + jsFolder.getAbsolutePath() + "'");
            }
        }
        for (String fileName : JS_FILES) {
            File jsFile = new File(jsFolder, fileName);
            if (!jsFile.exists()) {
                InputStream fis = FileUtils.class.getResourceAsStream(fileName);
                if (fis != null) {
                    try (FileOutputStream fos = new FileOutputStream(new File(jsFolder, fileName))) {
                        try {
                            copyStream(fis, fos, DEFAULT_BUFFER_SIZE);
                        } catch (Exception e) {
                            throw new IOException("Error copying js file " + fileName, e);
                        } finally {
                            if (fis != null) {
                                fis.close();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Read entire input stream and writes all data to output stream
     * then closes input and flushed output
     */
    public static void copyStream(InputStream inputStream, OutputStream outputStream,
                                  int bufferSize)
            throws IOException {
        try {
            byte[] writeBuffer = new byte[bufferSize];
            for (int br = inputStream.read(writeBuffer); br != -1; br = inputStream.read(writeBuffer)) {
                outputStream.write(writeBuffer, 0, br);
            }
            outputStream.flush();
        } finally {
            inputStream.close();
        }
    }

    /**
     * Check if the file has the good extension
     * @param file
     * @param prefixes
     * @return
     */
    public static boolean isExtensionWellFormated(File file, String... prefixes) {
        if(file==null){
            throw new RuntimeException("The file is null.");
        }
        String path = file.getAbsolutePath();
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i >= 0) {
            extension = path.substring(i + 1);
        }

        for (String prefix:prefixes) {
            if(prefix!=null && !prefix.isEmpty()) {
                if(extension.equalsIgnoreCase(prefix)){
                    return true;
                }
            }
        }
        return false;
    }
}
