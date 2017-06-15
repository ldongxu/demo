package com.ldongxu;


import com.ldongxu.learn.CloneUtils;
import com.ldongxu.learn.ConfigUtil;
import com.ldongxu.learn.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
//        System.out.println("java_vendor:" + System.getProperty("java.vendor"));
//        System.out.println("java_vendor_url:"
//                + System.getProperty("java.vendor.url"));
//        System.out.println("java_home:" + System.getProperty("java.home"));
//        System.out.println("java_class_version:"
//                + System.getProperty("java.class.version"));
//        System.out.println("java_class_path:"
//                + System.getProperty("java.class.path"));
//        System.out.println("os_name:" + System.getProperty("os.name"));
//        System.out.println("os_arch:" + System.getProperty("os.arch"));
//        System.out.println("os_version:" + System.getProperty("os.version"));
//        System.out.println("user_name:" + System.getProperty("user.name"));
//        System.out.println("user_home:" + System.getProperty("user.home"));
//        System.out.println("user_dir:" + System.getProperty("user.dir"));
//        System.out.println("java_vm_specification_version:"
//                + System.getProperty("java.vm.specification.version"));
//        System.out.println("java_vm_specification_vendor:"
//                + System.getProperty("java.vm.specification.vendor"));
//        System.out.println("java_vm_specification_name:"
//                + System.getProperty("java.vm.specification.name"));
//        System.out.println("java_vm_version:"
//                + System.getProperty("java.vm.version"));
//        System.out.println("java_vm_vendor:"
//                + System.getProperty("java.vm.vendor"));
//        System.out
//                .println("java_vm_name:" + System.getProperty("java.vm.name"));
//        System.out.println("java_ext_dirs:"
//                + System.getProperty("java.ext.dirs"));
//        System.out.println("file_separator:"
//                + System.getProperty("file.separator"));
//        System.out.println("path_separator:"
//                + System.getProperty("path.separator"));
//        System.out.println("line_separator:"
//                + System.getProperty("line.separator"));
//        System.out.println("j" +
//                "ava.io.tmpdir:"+System.getProperty("java.io.tmpdir"));
//        System.out.println("java.compiler:"+System.getProperty("java.compiler"));
//        System.out.println("java.ext.dirs:"+System.getProperty("java.ext.dirs"));
//        System.out.println("java.class.path:"+System.getProperty("java.class.path"));
//        System.out.println("java.library.path:"+System.getProperty("java.library.path"));
//
//        System.out.println("===========================");
//
//        System.out.println(System.getenv());

        System.out.println(0x000000);

        List<Person> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            Person person = new Person();
            person.setName("test"+i);
            list.add(person);
        }
        List<Person> list1 = new ArrayList<>(list);
       list.get(0).setName("hhhh");
        System.out.println(list1.size());

    }



    public static int average(int x,int y){
        return (x&y)+((x^y)>>1);
    }


}
