package utils;

import cn.hutool.core.util.ObjectUtil;
import dto.Fraction;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/3 4:07 下午
 * @modified By
 */
public class FractionUtil {


    public static String DIVISION_SIGN = "/";

    /**
     * String To Fraction
     *
     * @param fraction
     * @return
     */
    public static Fraction parse(String fraction) {
        if (!checkIsValid(fraction)) {
            System.out.println("此分数不合法");
        }
        String[] split = fraction.split(DIVISION_SIGN);
        int numerator = Integer.parseInt(split[0]);
        int denominator = Integer.parseInt(split[1]);

        if (0 == numerator) {
            return Fraction.builder().numerator(0).denominator(1).result(BigDecimal.ZERO).build();
        } else if (numerator == denominator) {
            return Fraction.builder().numerator(1).denominator(1).result(BigDecimal.ONE).build();
        }
        int commonFactor = MathUtil.getCommonFactor(numerator, denominator);

        Fraction build = Fraction.builder().numerator(numerator / commonFactor).denominator(denominator / commonFactor).result((new BigDecimal(numerator)).divide(new BigDecimal(denominator))).build();
        return build;
    }

    /**
     * Fraction To String
     *
     * @param fraction
     * @return
     */
    public static String format(Fraction fraction) {
        String temp = fraction.getNumerator() + DIVISION_SIGN + fraction.getDenominator();
        if (fraction.getResult().equals(BigDecimal.ONE) || fraction.getResult().equals(BigDecimal.ZERO)) {
            return fraction.getResult().toString();
        }
        return temp;
    }

    /**
     * 分数合法性检验
     *
     * @param fraction
     * @return
     */
    public static boolean checkIsValid(String fraction) {

        //不为空字符串
        if (StringUtils.isBlank(fraction)) {
            return false;
        }

        //正常格式为a/b
        String[] split = fraction.split(DIVISION_SIGN);
        if (split.length != 2) {
            return false;
        }

        //必须为数字
        if (!Arrays.stream(split).allMatch(StringUtils::isNumeric)) {
            return false;
        }
        //分子不能为0
        if (0 == Integer.parseInt(split[1])) {
            return false;
        }

        return true;
    }
}
