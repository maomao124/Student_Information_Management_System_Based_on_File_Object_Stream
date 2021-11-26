package io;

import SHA.MD5;
import SHA.SHA3_512;
import data.Student;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): io
 * Class(类名): Unit_Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 15:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Unit_Test
{
    public static void main(String[] args)
    {
        /*
        io.Log.write("管理员","增加数据");
        io.Log.display();
         */
        data.Configuration configuration = new data.Configuration();
        configuration.setSize();
        configuration.setPassword_SHA3_512(SHA3_512.getSHA3_512("123"));
        configuration.setUsername_MD5(MD5.getMD5("mao"));
        io.Configuration.write(configuration);                          //这里写了一次
        data.Configuration configuration1 = io.Configuration.read();
        System.out.println(configuration1.getSize());
        System.out.println(configuration1.getUsername_MD5());
        System.out.println(configuration1.getPassword_SHA3_512());
        Student student = new Student(123, "张三", "男", 18, "计算机",
                2.3f, "18756478562", "2001-02-09", "湖南省");
        Student student1 = new Student(1234, "张三", "男", 18, "计算机",
                2.3f, "18756478562", "2001-02-09", "湖南省");
        configuration1 = io.Student.read(configuration1);
        for (int i = 0; i < data.Configuration.list.size(); i++)
        {
            System.out.println(data.Configuration.list.get(i));
        }
        data.Configuration.list.add(student);
        data.Configuration.list.add(student1);
        for (int i = 0; i < data.Configuration.list.size(); i++)
        {
            System.out.println(data.Configuration.list.get(i));
        }
        io.Student.write(configuration1);

        System.out.println(configuration1.getSize());
        System.out.println(configuration1.getUsername_MD5());
        System.out.println(configuration1.getPassword_SHA3_512());
    }
}
