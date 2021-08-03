package utils;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/3 9:19 上午
 * @modified By
 */
public class MathUtil {

    /**
     * 计算a,b两个数的公因数
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
        return min;
    }
}
