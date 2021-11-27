package operating;

import data.Configuration;
import data.Student;

import java.awt.*;
import java.io.Console;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): operating
 * Class(类名): Function
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 19:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Function implements Student_Function
{
    public static Configuration config;               //配置文件的类的对象
    private static boolean isAdministrator;           //是否为管理员身份，是为true，否为false

    private static long startTime;                     //开始时间
    @SuppressWarnings("all")
    private static long endTime;                       //结束时间

    public static boolean isIsAdministrator()
    {
        return isAdministrator;
    }

    public static void setIsAdministrator(boolean isAdministrator)
    {
        Function.isAdministrator = isAdministrator;
    }

    public static void start()
    {
        startTime = System.nanoTime();   //获取开始时间
    }

    @SuppressWarnings("all")
    public static void end(String operating)
    {
        endTime = System.nanoTime();     //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println(operating + "操作耗费时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println(operating + "操作耗费时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println(operating + "操作耗费时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        //System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        //System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
    }

    @Override
    public void insert()
    {
        Scanner input = new Scanner(System.in);
        long no;      //学号
        String name;  //名字
        String sex;   //性别
        int age;      //年龄
        String classes; //所在班级，class与关键字起冲突
        float GPA;      //平均学分绩点
        String number;  //电话号码
        String birthday; //生日
        String address;  //家庭地址
        //控制台输入变量:no
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:999999999999999999
                System.out.print("请输入学号：");
                no = input.nextLong();
                if (no >= 0 && no <= 999999999999999999L)
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
                    System.out.println("输入的数据不在范围内! 范围：[0,999999999999999999]");
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
        //姓名
        while (true)
        {
            System.out.print("请输入姓名：");
            name = input.next();
            if (name.length() >= 10)
            {
                System.out.println("名字长度太长，长度应该小于10！！！请重新输入！");
            }
            else
            {
                break;
            }
        }
        //性别
        while (true)
        {
            System.out.print("请输入性别：");
            sex = input.next();
            if (sex.equals("男"))
            {
                break;
            }
            else if (sex.equals("女"))
            {
                break;
            }
            else
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("性别只能是男或者女，输入错误！请重新输入！！！");
            }
        }
        //年龄
        //控制台输入变量:age
        errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:100
                System.out.print("请输入年龄：");
                age = input.nextInt();
                if (age >= 0 && age <= 100)
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
                    System.out.println("输入的数据不在范围内! 范围：[0,100]");
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
        //班级
        System.out.print("请输入班级：");
        classes = input.next();
        //平均学分绩点
        //控制台输入变量:GPA
        errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:5.0
                System.out.print("请输入平均学分绩点：");
                GPA = input.nextFloat();
                if (GPA >= 0 && GPA <= 5.0)
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
                    System.out.println("输入的数据不在范围内! 范围：[0,5.0]");
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
        //电话号码
        while (true)
        {
            System.out.print("请输入新的电话号码：");
            number = input.next();
            if (number.length() >= 12)
            {
                System.out.println("输入错误！电话号码应该最多为11位！请重新输入");
            }
            else
            {
                break;
            }
        }
        //生日
        System.out.println("开始输入生日信息");
        {
            int year;
            int month;
            int day;
            //控制台输入变量:year
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:1000
                    //max:3000
                    System.out.print("请输入年：");
                    year = input.nextInt();
                    if (year >= 1000 && year <= 3000)
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
                        System.out.println("输入的数据不在范围内! 范围：[1000,3000]");
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
            //控制台输入变量:month
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:1
                    //max:12
                    System.out.print("请输入月：");
                    month = input.nextInt();
                    if (month >= 1 && month <= 12)
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
                        System.out.println("输入的数据不在范围内! 范围：[1,12]");
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
            //控制台输入变量:day
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:1
                    //max:31
                    System.out.print("请输入日：");
                    day = input.nextInt();
                    if (day >= 1 && day <= 31)
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
                        System.out.println("输入的数据不在范围内! 范围：[1,31]");
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
            birthday = year + "-" + month + "-" + day;
        }
        //家庭地址
        System.out.print("请输入家庭地址：");
        address = input.next();
        start();
        //写入对象
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setSex(sex);
        student.setAge(age);
        student.setClasses(classes);
        student.setGPA(GPA);
        student.setNumber(number);
        student.setBirthday(birthday);
        student.setAddress(address);
        //检查是否有相同的数据
        for (int i = 0; i < Configuration.list.size(); i++)
        {
            if (student.equals(Configuration.list.get(i)))
            {
                //相同
                Toolkit.getDefaultToolkit().beep();
                System.out.println("输入的数据和已经存在的数据相同，写入失败！！！");
                return;
            }
        }
        //检查主键学号是否唯一，因为一个学号对应一个学生，前面的检查是检查所有的数据，这次只是检查学号信息，
        // 这样前面的检查显得多此一举？没办法，前后检查的算法运行时间差距很大
        for (Student student1 : data.Configuration.list)
        {
            if (student.getNo() == student1.getNo())
            {
                System.out.println("主键不唯一！！！");
                System.out.println("输入的数据：");
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                System.out.println("已经存在的数据：");
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student1.getNo(), student1.getName(),
                        student1.getSex(), student1.getAge(), student1.getClasses(), student1.getGPA(), student1.getNumber(),
                        student1.getBirthday(), student1.getAddress());
                return;
            }
        }
        //添加到数据
        Configuration.list.add(student);
        //写入文件
        io.Student.write(config);
        if (isIsAdministrator())             //管理员
        {
            io.Log.write("管理员","添加学生信息");
        }
        else                                 //访客
        {
            io.Log.write("访客","添加学生信息");
        }
        end("添加");
    }

    @Override
    public void display()        //输出
    {
        start();
        if (Configuration.list.size() == 0)
        {
            System.out.println("空");
        }
        else
        {
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
        }
        if (isIsAdministrator())             //管理员
        {
            io.Log.write("管理员","查看学生信息");
        }
        else                                 //访客
        {
            io.Log.write("访客","查看学生信息");
        }
        end("查看");
    }

    @Override
    public void global_search()
    {
        String keyword;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入搜索关键字：");
        keyword = input.next();
        start();
        Student student;
        int index;
        int count = 0;
        for (int i = 0; i < Configuration.list.size(); i++)
        {
            student = data.Configuration.list.get(i);
            if (student.toString_search().contains(keyword))
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                index = student.toString_search().indexOf(keyword);
                System.out.println("\t\t出现的索引位置：" + index);
                count++;
            }
        }
        System.out.println("一共" + count + "条记录");
        if (isIsAdministrator())             //管理员
        {
            io.Log.write("管理员","使用全局搜索搜索学生信息");
        }
        else                                 //访客
        {
            io.Log.write("访客","使用全局搜索搜索学生信息");
        }
        end("全局搜索");
    }

    @Override
    public void alter()
    {
        Scanner input = new Scanner(System.in);
        long no;
        //控制台输入变量:no
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:999999999999999999
                System.out.print("请输入要修改的学生的学号：");
                no = input.nextLong();
                if (no >= 0 && no <= 999999999999999999L)
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
                    System.out.println("输入的数据不在范围内! 范围：[0,999999999999999999]");
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
        Student student = null;
        int index = -1;
        for (int i = 0; i < Configuration.list.size(); i++)
        {
            student = data.Configuration.list.get(i);
            if (student.getNo() == no)
            {
                index = i;
                break;
            }
        }
        if (index == -1)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("未找到此学生的学号");
            return;
        }
        else
        {
            System.out.println("已找到，位于第" + index + "个位置，学生数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
        }

        System.out.println("""
                1.学号           2.姓名      3.性别   4.年龄     5.所在班级
                6.平均学分绩点    7.电话号码   8.生日   9.家庭地址  10.返回到主菜单""");
        int serialNumber;
        //控制台输入变量:serialNumber
        errCount = 0;
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
                    System.out.println("输入的数据不在范围内! 范围：[1,10]");
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
        if (serialNumber == 1)             //学号
        {
            long new_no;
            //控制台输入变量:new_no
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:999999999999999999
                    System.out.print("请输入新的学号：");
                    new_no = input.nextLong();
                    if (new_no >= 0 && new_no <= 999999999999999999L)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,999999999999999999]");
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
            //验证
            for (Student student1 : data.Configuration.list)
            {
                if (new_no == student1.getNo())
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("学号冲突，主键不唯一！！！");
                    System.out.println("已经存在的数据：");
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student1.getNo(), student1.getName(),
                            student1.getSex(), student1.getAge(), student1.getClasses(), student1.getGPA(), student1.getNumber(),
                            student1.getBirthday(), student1.getAddress());
                    System.out.println("修改失败！！！");
                    return;
                }
            }
            student.setNo(new_no);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 2)         //名字
        {
            String new_name;
            while (true)
            {
                System.out.print("请输入新的姓名：");
                new_name = input.next();
                if (new_name.length() >= 10)
                {
                    System.out.println("名字长度太长，长度应该小于10！！！请重新输入！");
                }
                else
                {
                    break;
                }
            }
            student.setName(new_name);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 3)        //性别
        {
            String new_sex;
            while (true)
            {
                System.out.print("请输入新的性别：");
                new_sex = input.next();
                if (new_sex.equals("男"))
                {
                    break;
                }
                else if (new_sex.equals("女"))
                {
                    break;
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("性别只能是男或者女，输入错误！请重新输入！！！");
                }
            }
            student.setSex(new_sex);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 4)        //年龄
        {
            int new_age;
            //控制台输入变量:new_age
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:100
                    System.out.print("请输入新的年龄：");
                    new_age = input.nextInt();
                    if (new_age >= 0 && new_age <= 100)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,100]");
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
            student.setAge(new_age);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 5)          //所在班级
        {
            String new_class;
            System.out.print("请输入新的班级：");
            new_class = input.next();
            student.setClasses(new_class);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 6)           //平均学分绩点
        {
            float new_GPA;
            //控制台输入变量:new_GPA
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:5.0
                    System.out.print("请输入新的平均学分绩点：");
                    new_GPA = input.nextFloat();
                    if (new_GPA >= 0 && new_GPA <= 5.0)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,5.0]");
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
            student.setGPA(new_GPA);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 7)          //电话号码
        {
            String new_number;
            while (true)
            {
                System.out.print("请输入新的电话号码：");
                new_number = input.next();
                if (new_number.length() >= 12)
                {
                    System.out.println("输入错误！电话号码应该最多为11位！请重新输入");
                }
                else
                {
                    break;
                }
            }
            student.setNumber(new_number);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 8)          //生日
        {
            String new_birthday;
            System.out.println("开始输入新的生日信息");
            {
                int year;
                int month;
                int day;
                //控制台输入变量:year
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1000
                        //max:3000
                        System.out.print("请输入年：");
                        year = input.nextInt();
                        if (year >= 1000 && year <= 3000)
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
                            System.out.println("输入的数据不在范围内! 范围：[1000,3000]");
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
                //控制台输入变量:month
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1
                        //max:12
                        System.out.print("请输入月：");
                        month = input.nextInt();
                        if (month >= 1 && month <= 12)
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
                            System.out.println("输入的数据不在范围内! 范围：[1,12]");
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
                //控制台输入变量:day
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1
                        //max:31
                        System.out.print("请输入日：");
                        day = input.nextInt();
                        if (day >= 1 && day <= 31)
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
                            System.out.println("输入的数据不在范围内! 范围：[1,31]");
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
                new_birthday = year + "-" + month + "-" + day;
            }
            student.setBirthday(new_birthday);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else if (serialNumber == 9)          //家庭地址
        {
            String new_address;
            System.out.print("请输入新的家庭地址：");
            new_address = input.next();
            student.setAddress(new_address);
            System.out.println("修改成功，新数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
            io.Student.write(config);       //写入到文件
        }
        else
        {
            System.out.println("返回到主菜单");
        }
        if (isIsAdministrator())             //管理员
        {
            io.Log.write("管理员","修改学生学号为"+no+"的信息  操作序号为"+serialNumber);
        }
        else                                 //访客
        {
            io.Log.write("访客","修改学生学号为"+no+"的信息  操作序号为"+serialNumber);
        }
    }

    @Override
    public void delete()             //删除
    {
        if (Configuration.list.size() == 0)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("空");
            return;
        }
        Scanner input = new Scanner(System.in);
        long no;
        //控制台输入变量:no
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:0
                //max:999999999999999999
                System.out.print("请输入要删除的学生的学号：");
                no = input.nextLong();
                if (no >= 0 && no <= 999999999999999999L)
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
                    System.out.println("输入的数据不在范围内! 范围：[0,999999999999999999]");
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
        Student student = null;
        int index = -1;
        for (int i = 0; i < Configuration.list.size(); i++)
        {
            student = data.Configuration.list.get(i);
            if (student.getNo() == no)
            {
                index = i;
                break;
            }
        }
        if (index == -1)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("未找到此学生的学号");
            return;
        }
        else
        {
            System.out.println("已找到，位于第" + index + "个位置，学生数据如下：");
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                    student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                    student.getBirthday(), student.getAddress());
        }
        String deleteKeyWord;
        System.err.println("输入关键字’delete‘来删除此学生！！！ 输入其它字符串取消删除");   //此方法所在线程和主线程不在同一线程里
        try
        {
            Thread.sleep(500);         //主线程进入阻塞队列500毫秒
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("请输入：");
        deleteKeyWord = input.next();
        start();
        if (deleteKeyWord.equals("delete"))
        {
            Configuration.list.remove(index);        //删除
            io.Student.write(config);                //写入
            //// TODO: 2021/11/27 log
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","删除学生学号为"+no+"的信息");
            }
            else                                 //访客
            {
                io.Log.write("访客","删除学生学号为"+no+"的信息");
            }
        }
        else
        {
            System.out.print("取消删除");
        }
        end("删除");
    }

    @Override
    public void sort()
    {
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
        Scanner input = new Scanner(System.in);
        int serialNumber;
        //控制台输入变量:serialNumber
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:1
                //max:18
                System.out.print("请输入序号：");
                serialNumber = input.nextInt();
                if (serialNumber >= 1 && serialNumber <= 18)
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
                    System.out.println("输入的数据不在范围内! 范围：[1,18]");
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
        start();
        if (serialNumber == 1)         //按学号升序
        {
            //对象集合排序方法1
            //使用Collections集合工具类进行排序
            Configuration.list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    //升序排序
                    return (int) (stu1.getNo() - stu2.getNo());
                }
            });
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示      //和日志起冲突
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按学号升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按学号升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 2)      //按学号降序
        {
            //方法2
            //lambda表达式
            Collections.sort(data.Configuration.list, (student1, student2) -> (int) (student2.getNo() - student1.getNo()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按学号降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按学号降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 3)              //按姓名升序
        {
            //使用Collections集合工具类进行排序，字符串操作
            Configuration.list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student stu1, Student stu2)
                {
                    //升序排序
                    return stu1.getName().compareTo(stu2.getName());
                }
            });
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按姓名升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按姓名升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 4)              //按姓名降序
        {
            //lambda表达式 ,字符串操作
            Configuration.list.sort((student1, student2) ->
                    (student2.getName().compareTo(student1.getName())));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按姓名降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按姓名降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 5)             //按性别升序
        {
            Collections.sort(Configuration.list, Comparator.comparing(Student::getSex));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按性别升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按性别升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 6)            //按性别降序
        {
            Collections.sort(Configuration.list, (student1, student2) -> student2.getSex().compareTo(student1.getSex()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按性别降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按性别降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 7)              //按年龄升序
        {
            Collections.sort(Configuration.list, (student1, student2) -> student1.getAge() - student2.getAge());
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按年龄升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按年龄升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 8)             //按年龄降序
        {
            Collections.sort(Configuration.list, (student1, student2) -> student2.getAge() - student1.getAge());
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按年龄降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按年龄降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 9)             //按所在班级升序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student1.getClasses().compareTo(student2.getClasses()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按所在班级升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按所在班级升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 10)             //按所在班级降序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student2.getClasses().compareTo(student1.getClasses()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按所在班级降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按所在班级降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 11)              //按平均学分绩点升序
        {
            Configuration.list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student student1, Student student2)
                {
                    //升序排序
                    //可以使用Float.compare(student1.getGPA(), student2.getGPA());
                    if (student1.getGPA() < student2.getGPA())
                    {
                        return -1;
                    }
                    else if (student1.getGPA() > student2.getGPA())
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按平均学分绩点升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按平均学分绩点升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 12)              //按平均学分绩点降序
        {
            Configuration.list.sort(new Comparator<Student>()
            {
                @Override
                public int compare(Student student1, Student student2)
                {
                    //升序排序
                    //可以使用Float.compare(student2.getGPA(), student1.getGPA());
                    if (student1.getGPA() < student2.getGPA())
                    {
                        return 1;
                    }
                    else if (student1.getGPA() > student2.getGPA())
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            });
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按平均学分绩点降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按平均学分绩点降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 13)             //按电话号码升序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student1.getNumber().compareTo(student2.getNumber()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按电话号码升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按电话号码升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 14)             //按电话号码降序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student2.getNumber().compareTo(student1.getNumber()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按电话号码降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按电话号码降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 15)             //按生日升序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student1.getBirthday().compareTo(student2.getBirthday()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按生日升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按生日升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 16)             //按生日降序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student2.getBirthday().compareTo(student1.getBirthday()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按生日降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按生日降序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 17)             //按家庭地址升序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student1.getAddress().compareTo(student2.getAddress()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按家庭地址升序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按家庭地址升序");
            }
            io.Student.write(config);
        }
        else if (serialNumber == 18)             //按家庭地址降序
        {
            Collections.sort(Configuration.list, (student1, student2) ->
                    student2.getAddress().compareTo(student1.getAddress()));
            System.out.println("排序完成！结果如下：");
            //this.display();            //显示
            System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", "学号", "姓名",
                    "性别", "年龄", "所在班级", "平均学分绩点", "电话号码",
                    "生日", "家庭地址");
            int count = 0;
            for (Student student : Configuration.list)
            {
                System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                        student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                        student.getBirthday(), student.getAddress());
                count++;
            }
            System.out.println("一共" + count + "条记录");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","按家庭地址降序");
            }
            else                                 //访客
            {
                io.Log.write("访客","按家庭地址降序");
            }
            io.Student.write(config);
        }
        end("排序");
    }

    @Override
    public void changePassword()
    {
        System.out.println("请输入原密码：");
        String password;
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
        //密码验证
        String password_SHA3_512;
        password_SHA3_512 = SHA.SHA3_512.getSHA3_512(password);
        if (config.getPassword_SHA3_512().equals(password_SHA3_512))
        {
            System.out.println("密码输入正确");
            config.setPassword_SHA3_512(password_SHA3_512);        //写入配置类
            io.Configuration.write(config);                       //写入配置文件
            System.out.println("密码已更新");
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","修改密码");
            }
            else                                 //访客
            {
                io.Log.write("访客","修改密码");
            }
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("密码输入错误");
        }
    }

    @Override
    public void search()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                1.搜索学号       2.搜索姓名     3.搜索性别
                4.搜索年龄       5.搜索班级     6.搜索平均学分绩点
                7.搜索电话号码    8.搜索生日     9.搜索家庭地址""");
        int serialNumber;
        //控制台输入变量:serialNumber
        int errCount = 0;
        while (true)
        {
            try
            {
                //min:1
                //max:9
                System.out.print("请输入序号：");
                serialNumber = input.nextInt();
                if (serialNumber >= 1 && serialNumber <= 9)
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
        if (serialNumber == 1)             //学号
        {
            long no;
            //控制台输入变量:no
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:999999999999999999
                    System.out.print("请输入要搜索的学号：");
                    no = input.nextLong();
                    if (no >= 0 && no <= 999999999999999999L)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,999999999999999999]");
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
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getNo() == no)
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到学号为" + no + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找学号");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找学号");
            }
        }
        else if (serialNumber == 2)
        {
            String name;
            System.out.print("请输入要查找的姓名：");
            name = input.next();
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getName().equals(name))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到名字为" + name + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找姓名");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找姓名");
            }
        }
        else if (serialNumber == 3)
        {
            String sex;
            System.out.print("请输入要搜索的性别：");
            sex = input.next();
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getSex().equals(sex))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到性别为" + sex + "的学生");
                System.out.println("请检查输入的性别，性别只能是男或者女");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找性别");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找性别");
            }
        }
        else if (serialNumber == 4)
        {
            int age;
            //控制台输入变量:age
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:100
                    System.out.print("请输入要搜索的年龄：");
                    age = input.nextInt();
                    if (age >= 0 && age <= 100)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,100]");
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
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getAge() == age)
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到年龄为" + age + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找年龄");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找年龄");
            }
        }
        else if (serialNumber == 5)
        {
            String classes;
            System.out.print("请输入要搜索的所在班级：");
            classes = input.next();
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getClasses().equals(classes))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到班级为" + classes + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找班级");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找班级");
            }
        }
        else if (serialNumber == 6)
        {
            float GPA;
            //控制台输入变量:GPA
            errCount = 0;
            while (true)
            {
                try
                {
                    //min:0
                    //max:5.0
                    System.out.print("请输入要搜索的平均学分绩点：");
                    GPA = input.nextFloat();
                    if (GPA >= 0 && GPA <= 5.0)
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
                        System.out.println("输入的数据不在范围内! 范围：[0,5.0]");
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
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getGPA() == GPA)
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到平均学分绩点为" + GPA + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找平均学分绩点");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找平均学分绩点");
            }
        }
        else if (serialNumber == 7)
        {
            String number;
            System.out.print("请输入要搜索的电话号码：");
            number = input.next();
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getNumber().equals(number))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到电话号码为" + number + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找电话号码");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找电话号码");
            }
        }
        else if (serialNumber == 8)
        {
            String birthday;
            System.out.println("开始输入生日信息");
            {
                int year;
                int month;
                int day;
                //控制台输入变量:year
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1000
                        //max:3000
                        System.out.print("请输入年：");
                        year = input.nextInt();
                        if (year >= 1000 && year <= 3000)
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
                            System.out.println("输入的数据不在范围内! 范围：[1000,3000]");
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
                //控制台输入变量:month
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1
                        //max:12
                        System.out.print("请输入月：");
                        month = input.nextInt();
                        if (month >= 1 && month <= 12)
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
                            System.out.println("输入的数据不在范围内! 范围：[1,12]");
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
                //控制台输入变量:day
                errCount = 0;
                while (true)
                {
                    try
                    {
                        //min:1
                        //max:31
                        System.out.print("请输入日：");
                        day = input.nextInt();
                        if (day >= 1 && day <= 31)
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
                            System.out.println("输入的数据不在范围内! 范围：[1,31]");
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
                birthday = year + "-" + month + "-" + day;
            }
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getBirthday().equals(birthday))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到生日为" + birthday + "的学生");
            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找生日");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找生日");
            }
        }
        else
        {
            String address;
            System.out.print("请输入要搜索的家庭地址：");
            address = input.next();
            int count = 0;
            Student student;
            for (int i = 0; i < Configuration.list.size(); i++)
            {
                student = data.Configuration.list.get(i);
                if (student.getAddress().equals(address))
                {
                    System.out.printf("%-15s%-8s%-5s%-5s%-15s%-8s%-15s%-15s%-10s\n", student.getNo(), student.getName(),
                            student.getSex(), student.getAge(), student.getClasses(), student.getGPA(), student.getNumber(),
                            student.getBirthday(), student.getAddress());
                    count++;
                }
            }
            if (count == 0)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未找到家庭地址为" + address + "的学生");

            }
            else
            {
                System.out.println("共计" + count + "条记录");
            }
            if (isIsAdministrator())             //管理员
            {
                io.Log.write("管理员","查找家庭地址");
            }
            else                                 //访客
            {
                io.Log.write("访客","查找家庭地址");
            }
        }
    }
}
