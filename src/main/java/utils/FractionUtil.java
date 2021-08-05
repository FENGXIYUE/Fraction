package utils;

import constants.OperatorEnum;
import dto.Fraction;
import exception.FractionArithmeticException;
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
            throw new FractionArithmeticException("此分数不合法");
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
        if (fraction.getNumerator()%fraction.getDenominator()==0) {
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

        if (!Arrays.stream(split).allMatch(MathUtil::isNumeric)) {
            return false;
        }
        //分子不能为0
        if (0 == Integer.parseInt(split[1])) {
            return false;
        }

        return true;
    }
    public static Fraction addSub(Fraction fraction1,Fraction fraction2, boolean isAdd) {
        int numerator;
        int denominator = fraction1.getDenominator() * fraction2.getDenominator();
        if(isAdd){
            numerator = fraction1.getNumerator() * fraction2.getDenominator() + fraction1.getDenominator() * fraction2.getNumerator();

        }else{
            numerator = fraction1.getNumerator() * fraction2.getDenominator() - fraction1.getDenominator() * fraction2.getNumerator();
        }
        System.out.println(numerator + DIVISION_SIGN + denominator);
        return parse(numerator + DIVISION_SIGN + denominator);

}
    public static String calculateExpression(String fraction1, String fraction2, String operator) {
        Fraction response = Fraction.builder().build();

        if (OperatorEnum.ADD.getValue().equals(operator)) {
            response = addSub(parse(fraction1),parse(fraction2),true);
        } else if (OperatorEnum.SUBTRACT.getValue().equals(operator)) {
            response = addSub(parse(fraction1),parse(fraction2),false);
        } else if (OperatorEnum.MULTIPLY.getValue().equals(operator)) {


        } else if (OperatorEnum.DIVIDE.getValue().equals(operator)) {

        }
        return fraction1 + operator + fraction2 + "=" + format(response);
    }
}
