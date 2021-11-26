package data;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): data
 * Class(类名): Unit_Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 18:48
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Unit_Test
{
    public static void main(String[] args)
    {
        Student student = new Student(123, "张三", "男", 18, "计算机",
                2.3f, "18756478562", "2001-02-09", "湖南省");
        Student student1 = new Student(123454, "张三", "男", 18, "计算机",
                2.3f, "18756478562", "2001-02-09", "湖南省");
        System.out.println(student);
        System.out.println(student1);
        System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n",student.getNo(),student.getName(),
                student.getSex(),student.getAge(), student.getClasses(),student.getGPA(),student.getNumber(),
                student.getBirthday(),student.getAddress());
        student=student1;
        System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n",student.getNo(),student.getName(),
                student.getSex(),student.getAge(), student.getClasses(),student.getGPA(),student.getNumber(),
                student.getBirthday(),student.getAddress());
        System.out.println(student.toString_search());
    }
}
