import data.Configuration;
import operating.Function;
import operating.LifeCycle;

import java.awt.*;
import java.io.Console;
import java.io.File;
import java.util.Scanner;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): PACKAGE_NAME
 * Class(类名): Run
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/27
 * Time(创建时间)： 22:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Run
{
    public static void main(String[] args)        //程序入口点
    {
        File file1 = new File("Student.dat");
        File file2 = new File("Configuration.ini");
        File file3 = new File("MD5.txt");
        if (file1.exists() == false && file2.exists() == false && file3.exists() == false)     //3个都没找到，判定为第一次运行
        {
            operating.Function.Welcome();
        }
        if (file1.exists() == false || file2.exists() == false || file3.exists() == false)     //文件丢失，丢失1或2个
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("检测到文件丢失！！！ 是否重置？");
            Scanner input = new Scanner(System.in);
            String serialNumber;
            System.out.println("1.重置       2.不重置");
            System.out.print("请输入：");
            serialNumber = input.next();
            if (serialNumber.equals("1"))        //重置
            {
                operating.Function.Welcome();
            }
            else if (serialNumber.equals("2"))
            {
                System.exit(1);
            }
            else if (serialNumber.equals("3"))
            {
                System.out.println("再见！！！");
                System.exit(1);
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("输入错误！！！ 退出！");
                System.exit(1);
            }
        }
        //// TODO: 老用户，验证MD5值
        boolean result;                   //检验是否被修改
        result = io.MD5.verification();
        if (!result)                //不通过，被修改
        {
            Scanner input = new Scanner(System.in);
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件MD5值不一致，数据文件或者配置文件被修改！！！");
            System.out.println("是否重置？");
            System.out.print("请输入：");
            String serialNumber;
            serialNumber = input.next();
            if (serialNumber.equals("1"))        //重置
            {
                operating.Function.Welcome();
            }
            else if (serialNumber.equals("2"))
            {
                System.exit(1);
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("输入错误！！！ 退出！");
                System.exit(1);
            }
        }
        //通过
        //加载配置文件
        Function.config = io.Configuration.read();
        //TODO:通过散列算法验证用户
        String username_MD5;
        username_MD5 = SHA.MD5.getMD5(System.getProperty("user.name"));
        if (!username_MD5.equals(Function.config.getUsername_MD5()))       //用户名不一致，使用其它用户的文件
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("用户名不一致！！！ 当前登录用户：" + System.getProperty("user.name"));
            System.exit(1);
        }
        //用户通过
        //todo:加载dat文件写入内存
        io.Student.read(Function.config);
        //todo：用户输入2种模式
        boolean isAdministrator = false;             //是否为管理员
        System.out.println("请输入登录方式");
        System.out.println("1.管理员登录        2.访客登录       3.退出");
        System.out.print("请输入序号：");
        Scanner input = new Scanner(System.in);
        String serialNumber = input.next();
        if (serialNumber.equals("1"))
        {
            isAdministrator = true;
        }
        else if (serialNumber.equals("2"))
        {
            isAdministrator = false;
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("输入错误！！！自动退出！");
            System.exit(1);
        }
        //TODO:如果管理员，通过散列算法验证密码
        if (isAdministrator)
        {
            int errCount = 0;
            String password;
            String password_SHA3_512;
            Console console = System.console();
            while (true)
            {
                if (errCount > 3)
                {
                    System.out.println("错误次数过多！！！，退出！");
                    System.exit(1);
                }
                System.out.print("请输入密码：");
                if (console == null)
                {
                    password = input.next();
                }
                else
                {
                    password = new String(console.readPassword());
                }
                //密码验证
                password_SHA3_512 = SHA.SHA3_512.getSHA3_512(password);
                if (password_SHA3_512.equals(Function.config.getPassword_SHA3_512()))      //密码正确
                {
                    System.out.println("密码正确");
                    break;        //退出循环
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("密码错误！！！");
                }
                errCount++;
            }
        }
        //todo：初始化完成，进入程序生命周期
        if (isAdministrator)            //进入管理员循环
        {
            operating.LifeCycle.Administrator();
        }
        else
        {
            operating.LifeCycle.Guest();  //访客
        }
        //退出
    }
}
