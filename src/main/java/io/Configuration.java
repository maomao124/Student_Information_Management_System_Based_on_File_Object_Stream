package io;

import java.awt.*;
import java.io.*;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): io
 * Class(类名): Configuration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 22:46
 * Version(版本): 1.0
 * Description(描述)： 配置文件的输入和输出
 */

public class Configuration
{
    public static void write(data.Configuration config)
    {
        config.setSize();     //再次确保同步
        File file = new File("Configuration.ini");
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //System.out.println("配置写："+config.getSize());
            objectOutputStream.writeObject(config);        //写
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
    }

    public static data.Configuration read()
    {
        File file = new File("Configuration.ini");
        FileInputStream fileInputStream = null;
        ObjectInputStream ObjectInputStream = null;
        try                                  //文件流打开，文件读写
        {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream = new ObjectInputStream(fileInputStream);
            data.Configuration config = (data.Configuration) ObjectInputStream.readObject();
            //System.out.println("配置读："+config.getSize());
            //验证size
            if (config.getSize() < 0)
            {
                System.out.println("读取异常！！！");
                return null;
            }
            return config;
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
        return null;
    }

    public static void main(String[] args)
    {
        data.Configuration configuration;
        configuration=read();
        System.out.println(configuration.getSize());
    }
}
