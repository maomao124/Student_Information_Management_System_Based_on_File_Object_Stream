package io;

import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): io
 * Class(类名): MD5
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 16:34
 * Version(版本): 1.0
 * Description(描述)： 验证数据，MD5文件的读写，文件验证
 */

public class MD5
{
    public static String getFileMD5(String filePath)  //获得文件的MD5值
    {
        try
        {
            InputStream fileInputStream = new FileInputStream(filePath);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fileInputStream.read(buffer, 0, 1024)) != -1)
            {
                md.update(buffer, 0, length);
            }
            fileInputStream.close();
            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes = md.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);
            return bigInt.toString(16);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static void write()          //验证两个文件并写入文件
    {
        //MD5文件应该放入c盘的用户某个路径下，隐藏起来让用户不能操作，这里只为了演示，放在了相对路径下
        File file = new File("MD5.txt");
        String student;     //student文件的散列值
        String configuration;   //配置文件的散列值
        student = getFileMD5("Student.dat");
        configuration = getFileMD5("Configuration.ini");
        FileWriter fileWriter = null;
        try                                  //文件流打开，文件读写
        {
            fileWriter = new FileWriter(file);
            fileWriter.write(student + "\n");
            fileWriter.write(configuration + "\n");
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
                if (fileWriter != null)
                {
                    fileWriter.close();
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

    public static boolean verification()            //验证数据
    {
        String student_MD5;
        String configuration_MD5;
        String student_file;
        String configuration_file;
        //从文件读：
        File file = new File("MD5.txt");
        if (!file.exists())
        {
            return false;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try                                  //文件流打开，文件读写
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            student_file = bufferedReader.readLine();
            configuration_file = bufferedReader.readLine();
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.toString());
            return false;
        }
        catch (Exception e)                  //其它异常
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
            return false;
        }
        finally
        {
            try                              //关闭流
            {
                if (fileReader != null)
                {
                    fileReader.close();
                }
                if (bufferedReader != null)
                {
                    bufferedReader.close();
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
        student_MD5 = getFileMD5("Student.dat");
        configuration_MD5 = getFileMD5("Configuration.ini");
        if (student_MD5.equals(""))
        {
            return false;
        }
        if (configuration_MD5.equals(""))
        {
            return false;
        }
        if (student_file == null)
        {
            return false;
        }
        if (configuration_file == null)
        {
            return false;
        }
        if (!student_MD5.equals(student_file))
        {
            return false;
        }
        if (!configuration_MD5.equals(configuration_file))
        {
            return false;
        }
        return true;
    }
}
