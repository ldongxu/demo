package com.ldongxu.designPatterns.dynamicProxy.custom;

import java.io.*;

/**
 * @author liudongxu06
 * @since 2019-04-16
 *
 * 代码生成、编译、重新动态load到jvm
 *
 */
public class GpClassLoader extends ClassLoader{

    private File baseDir;

    public GpClassLoader() {
        String basePath = GpClassLoader.class.getResource("").getPath();
        System.out.println("basepath:"+basePath);
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GpClassLoader.class.getPackage().getName()+"."+name;
        System.out.println("className:"+className);
        if (baseDir != null){
            File classFile = new File(baseDir,name.replaceAll("\\.","/")+".class");
            System.out.println(classFile.getPath());
            System.out.println("classFile:"+classFile.getPath());
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (null!=in){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    classFile.delete();
                }
            }
        }
        return null;
    }
}
