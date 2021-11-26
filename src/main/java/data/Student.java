package data;

import java.io.Serializable;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): data
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 21:40
 * Version(版本): 1.0
 * Description(描述)： 学生数据
 */

public class Student implements Serializable
{
    //@Serial
    //private static final long serialVersionUID = 1L;
    private long no;      //学号
    private String name;  //名字
    private String sex;   //性别
    private int age;      //年龄
    private String classes; //所在班级，class与关键字起冲突
    private float GPA;      //平均学分绩点
    private String number;  //电话号码
    private String birthday; //生日
    private String address;  //家庭地址

    public Student()
    {

    }

    public Student(long no, String name, String sex, int age, String classes, float GPA, String number, String birthday, String address)
    {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classes = classes;
        this.GPA = GPA;
        this.number = number;
        this.birthday = birthday;
        this.address = address;
    }

    public long getNo()
    {
        return no;
    }

    public void setNo(long no)
    {
        this.no = no;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getClasses()
    {
        return classes;
    }

    public void setClasses(String classes)
    {
        this.classes = classes;
    }

    public float getGPA()
    {
        return GPA;
    }

    public void setGPA(float GPA)
    {
        this.GPA = GPA;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(no).append("\t\t");
        stringbuilder.append(name).append("\t\t");
        stringbuilder.append(sex).append("\t\t");
        stringbuilder.append(age).append("\t\t");
        stringbuilder.append(classes).append("\t\t");
        stringbuilder.append(GPA).append("\t\t");
        stringbuilder.append(number).append("\t\t");
        stringbuilder.append(birthday).append("\t\t");
        stringbuilder.append(address);
        return stringbuilder.toString();
    }

    @SuppressWarnings("all")
    public String toString_search()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(no);
        stringbuilder.append(name);
        stringbuilder.append(sex);
        stringbuilder.append(age);
        stringbuilder.append(classes);
        stringbuilder.append(GPA);
        stringbuilder.append(number);
        stringbuilder.append(birthday);
        stringbuilder.append(address);
        return stringbuilder.toString();
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
        Student student = (Student) o;

        if (no != student.no)
        {
            return false;
        }
        if (age != student.age)
        {
            return false;
        }
        if (Float.compare(student.GPA, GPA) != 0)
        {
            return false;
        }
        if (!name.equals(student.name))
        {
            return false;
        }
        if (!sex.equals(student.sex))
        {
            return false;
        }
        if (!classes.equals(student.classes))
        {
            return false;
        }
        if (!number.equals(student.number))
        {
            return false;
        }
        if (!birthday.equals(student.birthday))
        {
            return false;
        }
        return address.equals(student.address);
    }

    @Override
    public int hashCode()
    {
        int result = (int) (no ^ (no >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + age;
        result = 31 * result + classes.hashCode();
        result = 31 * result + (GPA != +0.0f ? Float.floatToIntBits(GPA) : 0);
        result = 31 * result + number.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
