package operating;

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
        Function f=new Function();
        System.out.println("""
                1.学号           2.姓名      3.性别   4.年龄     5.所在班级
                6.平均学分绩点    7.电话号码   8.生日   9.家庭地址  10.返回到主菜单""");
        f.display();
        Function.config=io.Student.read(Function.config);
       // Function.insert();
        f.display();
        System.out.println("""
                1.学号  2.姓名  3.性别  4.年龄  5.所在班级  6.平均学分绩点  7.电话号码  8.生日  9.家庭地址  10.返回到主菜单""");
    }
}
