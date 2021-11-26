package SHA;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): SHA
 * Class(类名): Unit_Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 17:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Unit_Test
{
    public static void main(String[] args)
    {
        String s1;
        s1 = MD5.getMD5("123");
        System.out.println(s1);
        s1 = MD5.getMD5toUpperCase("123");
        System.out.println(s1);
        s1=SHA3_512.getSHA3_512("123");
        System.out.println(s1);
        s1=SHA3_512.getSHA3_512toUpperCase("123");
        System.out.println(s1);
    }
}
