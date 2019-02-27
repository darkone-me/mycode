package learn.proxyTest.custom;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月12日 下午3:31:07          Administrator        2.1         To create
 * </p>
 * 2018年11月12日 下午3:31:07          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class TestProxy {

    public static Object newProxyInstance(TestClassloader classloader, Class<?>[] interfaces, TestInvocationHandler h) {
        try {
            //1.动态生成源代码
            String src = generateSrc(interfaces);

            //2.java文件输出硬盘
            String filePath = TestProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File file = new File(filePath + "$Proxy0.java");
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(src);
                fw.flush();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //3.java文件编译成class文件

            // 获取编译器实例 
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            // 获取标准文件管理器实例
            StandardJavaFileManager manger = compiler.getStandardFileManager(null, null, null);
            // 获取要编译的编译单元 
            Iterable<? extends JavaFileObject> iterable = manger.getJavaFileObjects(file);
            CompilationTask task = compiler.getTask(null, manger, null, null, null, iterable);
            // 运行编译任务 
            task.call();

            //4.编译的class文件加载到jvm中
            Class<?> proxyClass = classloader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(TestInvocationHandler.class);
            file.delete();

            //5.返回字节码重组的以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成源代码
     * @return
    	* @author tsj
    	* @Date 2018年11月15日上午10:08:16
     */
    private static String generateSrc(Class<?>[] interfaces) {
        String rn = "\r\n";

        StringBuilder sb = new StringBuilder();
        sb.append("package learn.proxyTest.custom;" + rn);
        sb.append("import learn.proxyTest.Person;" + rn);
        sb.append("import java.lang.reflect.Method;" + rn);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + rn);
        sb.append("TestInvocationHandler h;" + rn);
        sb.append("public $Proxy0 (TestInvocationHandler h) {" + rn);
        sb.append("this.h = h;" + rn);
        sb.append("}" + rn);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public" + " " + m.getReturnType().getName() + " " + m.getName() + "() {" + rn);
            sb.append("try {" + rn);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + rn);
            sb.append("this.h.invoke(this,m,null);" + rn);
            sb.append("} catch(Throwable e) {" + rn);
            sb.append("e.printStackTrace();" + rn);
            sb.append("}" + rn);
            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }
}
