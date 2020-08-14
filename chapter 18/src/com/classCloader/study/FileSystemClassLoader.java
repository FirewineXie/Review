package com.classCloader.study;

import java.io.*;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: FileSystemClassLoader
 * @Create : 2020/1/15
 * @Description : 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        //应该先查询有没有加载过这个类，如果已经加载，则直接返回已经加载好的类，如果没有，则加载新的类
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            //委派给父类加载
            c = parent.loadClass(name);
            if (c != null) {

                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    /**
     * 实现路径转换， com.st.test.User   d:/myjava/ com/st/test/User.class
     */
    private byte[] getClassData(String name) {
        String path = rootDir + "/" + name.replace('.', '/') + ".class";

        //IOUtils 可以使用它将流中的数据转换成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer, 0, temp);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
