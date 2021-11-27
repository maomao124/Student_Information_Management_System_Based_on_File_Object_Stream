import java.awt.*;
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
    public static void main(String[] args)
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
            else
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("输入错误！！！ 退出！");
                System.exit(1);
            }
        }
        //// TODO: 老用户，验证MD5值

        //TODO:通过散列算法验证用户和密码

        //todo:加载配置文件和dat文件写入内存

        //todo：初始化完成，进入程序生命周期
    }
}
