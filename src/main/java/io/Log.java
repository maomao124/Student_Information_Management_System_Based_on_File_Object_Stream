package io;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): io
 * Class(类名): Log
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/26
 * Time(创建时间)： 15:55
 * Version(版本): 1.0
 * Description(描述)： 日志类
 */

@SuppressWarnings("all")
public class Log
{
    private static final DecimalFormat decimalFormat1 = new DecimalFormat("00");

    public static void write(String identity, String operating)    //写入日志
    {
        Calendar calendar = Calendar.getInstance();// 获取当前时间
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;                         //月份从 0 开始，所以加 1
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        week = week - 1;                             //星期日为第一天
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //时
        int minute = calendar.get(Calendar.MINUTE);   //分
        int second = calendar.get(Calendar.SECOND);   //秒
        int millisecond = calendar.get(Calendar.MILLISECOND); //毫秒
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 获取今天是本月第几天
        int dayOfWeekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH); // 获取今天是本月第几周
        int many = calendar.get(Calendar.DAY_OF_YEAR); // 获取今天是今年第几天
        StringBuilder stringBuffer1 = new StringBuilder();
        //stringBuffer1.append(year).append("年 ").append(month).append("月 ").append(day).append("日 ")
        // .append(hour).append("时 ").append(minute).append("分 ").append(second).append("秒");
        stringBuffer1.append("日期：");
        stringBuffer1.append(decimalFormat1.format(year)).append("/").append(decimalFormat1.format(month)).append("/")
                .append(decimalFormat1.format(day)).append(" \t时间：").append(decimalFormat1.format(hour))
                .append(":").append(decimalFormat1.format(minute)).append(":").append(decimalFormat1.format(second));
        stringBuffer1.append(" \t用户：").append(System.getProperty("user.name"));
        stringBuffer1.append(" \t身份：").append(identity);
        stringBuffer1.append(" \t操作：").append(operating).append("\n");
        //System.out.println(stringBuffer1);
        //开始写入文件里
        File file = new File("student.log");
        FileWriter fileWriter = null;
        try                                  //文件流打开，文件读写
        {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(stringBuffer1.toString());
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

    public static void display()        //查看日志文件
    {
        File file = new File("student.log");
        if (!file.exists())
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("日志文件不存在！！！");
            return;
        }
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int count = 0;        //数量
        try                                  //文件流打开，文件读写
        {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null)
            {
                System.out.println(str);
                count++;
            }
            System.out.println("一共" + count + "条记录");
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
    }
}
