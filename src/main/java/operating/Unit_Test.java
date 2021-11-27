package operating;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): operating
 * Class(类名): Unit_Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 19:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Unit_Test
{
    public static void main(String[] args)
    {
        Function f = new Function();
        System.out.println("""
                1.学号           2.姓名      3.性别   4.年龄     5.所在班级
                6.平均学分绩点    7.电话号码   8.生日   9.家庭地址  10.返回到主菜单""");
        //f.display();
        //Function.config=io.Student.read(Function.config);
        // Function.insert();
        f.display();
        System.out.println("""
                1.学号  2.姓名  3.性别  4.年龄  5.所在班级  6.平均学分绩点  7.电话号码  8.生日  9.家庭地址  10.返回到主菜单""");

        System.out.println();
        System.out.println("""
                1.按学号升序               2.按学号降序
                3.按名字升序               4.按名字降序
                5.按性别升序               6.按性别降序
                7.按年龄升序               8.按年龄降序
                9.按所在班级升序           10按所在班级降序
                11.按平均学分绩点升序       12.按平均学号绩点降序
                13.按电话号码升序          14.按电话号码降序
                15.按生日升序             16.按生日降序
                17.按家庭地址升序          18.按家庭地址降序""");
    }

}

class InputTest
{
    public static void main(String[] args)
    {
        String password;
        System.out.print("请输入密码:");
        Console console = System.console();
        if (console == null)
        {
            Scanner input = new Scanner(System.in);
            password = input.next();
            System.out.println("密码:" + password);
        }
        else
        {
            password = new String(console.readPassword());
            System.out.println("密码:" + password);
        }

    }
}
