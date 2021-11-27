package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): data
 * Class(类名): Configuration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 22:01
 * Version(版本): 1.0
 * Description(描述)： 配置文件的数据
 */

public class Configuration implements Serializable
{
    //不使用显式的序列化，使用隐式的
    //private static final long serialVersionUID = 1L;
    private String username_MD5;
    private String password_SHA3_512;
    private int size;         //学生信息管理系统的student对象的数量
    public static ArrayList<data.Student> list = new ArrayList<>();
    //经常在某个索引位置取数操作，不在某个索引位置添加操作，不做大量的添加操作，这里使用数组比链表更优秀

    public String getUsername_MD5()
    {
        return username_MD5;
    }

    public void setUsername_MD5(String username_MD5)
    {
        this.username_MD5 = username_MD5;
    }

    public String getPassword_SHA3_512()
    {
        return password_SHA3_512;
    }

    public void setPassword_SHA3_512(String password_SHA3_512)
    {
        this.password_SHA3_512 = password_SHA3_512;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize()
    {
        if (list == null)
        {
            this.size = 0;
        }
        else
        {
            this.size = list.size();
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)    //引用同一个对象
        {
            return true;
        }
        if (o == null)    //检测obj是否为null
        {
            return false;
        }
        //if(!(otherObject instanceof ClassName)) //如果所有的子类都拥有统一的语义
        if (this.getClass() != o.getClass())   //比较this与obj是否属于同一个类
        {
            return false;
        }

        //Object类向下转型
        Configuration that = (Configuration) o;

        if (size != that.size)
        {
            return false;
        }
        if (!username_MD5.equals(that.username_MD5))
        {
            return false;
        }
        return password_SHA3_512.equals(that.password_SHA3_512);
    }

    @Override
    public int hashCode()
    {
        int result = username_MD5.hashCode();
        result = 31 * result + password_SHA3_512.hashCode();
        result = 31 * result + size;
        return result;
    }
}
