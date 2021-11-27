package operating;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): operating
 * Interface(接口名): Student_Function
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 22:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface Student_Function
{
    public void insert();         //插入

    public void display();        //显示

    public void global_search();   //全局搜索

    public void alter();           //修改

    public void delete();          //删除

    public void sort();            //排序

    public void changePassword();   //更改密码

    public void search();          //分类搜索

}
