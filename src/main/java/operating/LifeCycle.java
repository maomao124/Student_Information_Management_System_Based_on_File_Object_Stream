package operating;

import java.awt.*;
import java.util.Scanner;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): operating
 * Class(类名): LifeCycle
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/27
 * Time(创建时间)： 15:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class LifeCycle
{

    private static void AdministratorMenu()
    {
        System.out.println("""
                 1.添加学生信息
                 2.查看学生信息
                 3.全局搜索
                 4.分类搜索
                 5.修改学生信息
                 6.删除学生信息
                 7.排序
                 8.更改密码
                 9.查看日志文件
                10.退出""");
    }

    private static void GuestMenu()
    {
        System.out.println("""
                1.查看学生信息
                2.全局搜索
                3.分类搜索
                4.排序
                5.退出""");
    }

    public static void Administrator()
    {
        operating.Function.setIsAdministrator(true);      //设置身份为管理员用户
        operating.Function function = new operating.Function();
        Scanner input = new Scanner(System.in);
        int serialNumber;
        while (true)
        {
            AdministratorMenu();
            //控制台输入变量:serialNumber
            int errCount = 0;
            while (true)
            {
                try
                {
                    //min:1
                    //max:10
                    System.out.print("请输入序号：");
                    serialNumber = input.nextInt();
                    if (serialNumber >= 1 && serialNumber <= 10)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[1,9]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }
            if (serialNumber == 1)            //添加学生信息
            {
                function.insert();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 2)       //查看学生信息
            {
                function.display();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 3)        //全局搜索
            {
                function.global_search();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 4)         //分类搜索
            {
                function.search();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 5)        //修改学生信息
            {
                function.alter();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 6)        //删除信息
            {
                function.delete();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 7)        //排序
            {
                function.sort();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 8)        //更改密码
            {
                function.changePassword();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 9)        //查看日志
            {
                io.Log.display();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else                              //退出
            {
                System.out.println("欢迎你的使用！ 再见！！！");
                break;
            }
            System.out.println("\n\n");
        }
    }

    public static void Guest()
    {
        operating.Function.setIsAdministrator(false);      //设置身份为访客用户
        operating.Function function = new operating.Function();
        Scanner input = new Scanner(System.in);
        int serialNumber;
        while (true)
        {
            GuestMenu();
            //控制台输入变量:serialNumber
            int errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:5
                    System.out.print("请输入序号：");
                    serialNumber = input.nextInt();
                    if (serialNumber >= 0 && serialNumber <= 5)
                    {
                        break;
                    }
                    else
                    {
                        errCount++;
                        Toolkit.getDefaultToolkit().beep();
                        if (errCount > 10)
                        {
                            System.err.println("错误次数过多！！！退出");
                            System.exit(1);
                        }
                        System.out.println("输入的数据不在范围内! 范围：[0,5]");
                    }
                }
                catch (Exception e)
                {
                    errCount++;
                    if (errCount > 5)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.err.println("错误次数过多！！！退出");
                        System.exit(1);
                    }
                    else
                    {
                        Toolkit.getDefaultToolkit().beep();
                        System.out.println("输入错误！！！请重新输入！");
                        input.nextLine();
                    }
                }
            }
            if (serialNumber == 1)       //查看学生信息
            {
                function.display();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 2)        //全局搜索
            {
                function.global_search();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 3)         //分类搜索
            {
                function.search();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else if (serialNumber == 4)        //排序
            {
                function.sort();
                System.out.print("按回车键继续");
                input.nextLine();
            }
            else                              //退出
            {
                System.out.println("欢迎你的使用！ 再见！！！");
                break;
            }
            System.out.println("\n\n");
        }
    }
}
