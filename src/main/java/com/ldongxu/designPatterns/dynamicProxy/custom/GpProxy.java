package com.ldongxu.designPatterns.dynamicProxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author liudongxu06
 * @since 2019-04-16
 * <p>
 * 生成代理对象
 */
public class GpProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(GpClassLoader classLoader, Class<?>[] interfaces, GpInvocationHandler handler)  {

        try {

            //1、动态生成代理对象源代码
            String proxySrc = generateSrc(interfaces[0]);

            //2、将生成的源代码输出到磁盘，保存为java文件
            String filePath = GpProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(proxySrc);
            fw.close();
            //3、编译原代码，并生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable =  manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //4、将class文件内容，动态加载到jvm
            //5、返回被代理后的代理对象
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GpInvocationHandler.class);
            file.delete();
            return c.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package com.ldongxu.designPatterns.dynamicProxy.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("import java.lang.reflect.UndeclaredThrowableException;"+ln);
        src.append("import com.ldongxu.designPatterns.dynamicProxy.custom.GpInvocationHandler;"+ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        src.append("GpInvocationHandler h;" + ln);
        src.append("public $Proxy0(GpInvocationHandler h){" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);
        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "()" + "{" + ln);
            src.append("try {"+ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\");" + ln);
            if (!m.getReturnType().getName().equals("void")){
                src.append("return ("+m.getReturnType().getName()+")this.h.invoke(this,m,null);" + ln);
            }else {
                src.append("this.h.invoke(this,m,null);" + ln);
            }
            src.append("} catch (RuntimeException | Error e) {"+ln);
            src.append("throw e;"+ln);
            src.append("} catch (Throwable var) {"+ln);
            src.append("throw new UndeclaredThrowableException(var);"+ln);
            src.append("}"+ln);
            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }
}
