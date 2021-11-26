package io;

import data.Configuration;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): io
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 22:11
 * Version(版本): 1.0
 * Description(描述)： 学生数据的输入和输出
 */

public class Student
{
    public static void write(Configuration config)
    {
        config.setSize();          //同步
        File file = new File("Student.dat");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < Configuration.list.size(); i++)      //写入
            {
                objectOutputStream.writeObject(Configuration.list.get(i));
            }

        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭流
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
        //todo：同步配置文件和MD5文件 完成
        //System.out.println("写："+config.getSize());
        io.Configuration.write(config);
        io.MD5.write();
    }

    public static data.Configuration read(Configuration config)
    {
        //todo：读配置文件，确保同步和更新 完成
        //System.out.println("读1："+config.getSize());
        config = io.Configuration.read();  //再次读入确保同步
        //System.out.println("读2："+config.getSize());
        if (config == null)                 //确保数据正常
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("配置文件读取异常");
            System.exit(1);
        }
        //System.out.println("配置文件："+config.getSize());
        ArrayList<data.Student> list1 = new ArrayList<>();
        File file = new File("Student.dat");
        FileInputStream fileInputStream = null;
        ObjectInputStream ObjectInputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream = new ObjectInputStream(fileInputStream);
            for (int i = 0; i < config.getSize(); i++)
            {
                data.Student student = (data.Student) ObjectInputStream.readObject();
                list1.add(student);
            }
            Configuration.list = list1;
            System.gc();
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (ObjectInputStream != null)
                {
                    ObjectInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                Toolkit.getDefaultToolkit().beep();
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                Toolkit.getDefaultToolkit().beep();
                e.printStackTrace();
            }
        }
        return config;
    }
}
