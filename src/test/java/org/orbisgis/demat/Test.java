package org.orbisgis.demat;


import com.caoccao.javet.exceptions.JavetException;
import com.caoccao.javet.utils.JavetOSUtils;
import com.caoccao.javet.values.reference.V8ValueFunction;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import com.caoccao.javet.interop.NodeRuntime;
import com.caoccao.javet.interop.V8Host;
import java.io.*;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws JavetException, InterruptedException {
// Make sure node_modules and test folders stay together.
        File codeFile = Path.of(JavetOSUtils.WORKING_DIRECTORY)
                .resolve("test/test-express.js").toFile();
        AtomicBoolean serverUp = new AtomicBoolean(false);
        // Make sure Node.js runtime is shared with all threads.
        try (NodeRuntime nodeRuntime = V8Host.getNodeInstance().createV8Runtime()) {
            // Create a worker thread.
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Starting the server.");
                    nodeRuntime.getExecutor(codeFile).executeVoid();
                    serverUp.set(true);
                    System.out.println("Awaiting...");
                    nodeRuntime.await();
                } catch (JavetException e) {
                    e.printStackTrace();
                }
            });
            // Start the worker thread.
            thread.start();
            while (!serverUp.get()) {
                System.out.println("Waiting for server getting up.");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            System.out.println("Server is up.");
            // Let's call Node.js.
            for (int i = 0; i < Integer.MAX_VALUE; ++i) {
                try (V8ValueFunction v8ValueFunction = nodeRuntime.getGlobalObject().get("test")) {
                    v8ValueFunction.callVoid(null, i);
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }
    }
}
