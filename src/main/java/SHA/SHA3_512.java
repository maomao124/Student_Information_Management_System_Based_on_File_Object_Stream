package SHA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Project name(项目名称)：基于文件对象流的学生信息管理系统
 * Package(包名): SHA
 * Class(类名): SHA3_512
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 21:38
 * Version(版本): 1.0
 * Description(描述)： 散列算法 SHA3_512
 */

public class SHA3_512
{
    private static String SHA(final String strText)
    {
        String strResult = null;
        if (strText != null && strText.length() > 0)
        {
            try
            {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA3-512");
                messageDigest.update(strText.getBytes());
                byte[] byteBuffer = messageDigest.digest();
                StringBuilder strHexString = new StringBuilder();
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    public static String getSHA3_512(String strText)
    {
        return SHA(strText);
    }

    public static String getSHA3_512toUpperCase(String strText)
    {
        return SHA(strText).toUpperCase();
    }
}

