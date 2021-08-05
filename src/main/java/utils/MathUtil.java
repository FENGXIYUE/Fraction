package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/3 9:19 上午
 * @modified By
 */
public class MathUtil {

    /**
     * 计算a,b两个数的公因数
     *
     * @param a
     * @param b
     * @return
     */
    public static int getCommonFactor(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        //辗转相除法
        if (max >= min) {
            int remainder = max % min;
            while (remainder != 0) {
                max = min;
                min = remainder;
                remainder = max % min;
            }
        }
        return Math.abs(min);
    }

    /**
     * 判断字符是否为数字
     */
    public static boolean isNumeric(String strNum) {
        //String pattern = "^[\\+\\-]?[\\d]+(\\.[\\d]+)?$";
        String pattern = "^[\\+\\-]?[\\d]*?$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(strNum);

        return m.matches();
    }
}
