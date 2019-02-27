package learn.proxyTest.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月15日 上午9:58:47          Administrator        2.1         To create
 * </p>
 * 2018年11月15日 上午9:58:47          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class TestClassloader extends ClassLoader {

    private File classPathFile;

    public TestClassloader() {
        String classPath = TestClassloader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className = TestClassloader.class.getPackage().getName() + "." + name;

        if (classPathFile != null) {
            File classFile = new File(classPathFile, name + ".class");

            if (classFile.exists()) {
                FileInputStream io = null;
                ByteArrayOutputStream out = null;
                try {
                    io = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = io.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                    }
                    classFile.delete();
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != io) {
                        try {
                            io.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

        return null;
    }

}
