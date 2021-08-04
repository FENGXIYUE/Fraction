package utils

import dto.Fraction
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/3 4:28 下午
 * @modified By
 */
class FractionUtilTest extends Specification {
    def "Parse"() {

        when:
        Fraction fraction = FractionUtil.parse(inputstr)
        then:
        numerator == fraction.getNumerator();
        denominator == fraction.getDenominator();
        result == fraction.getResult();
        where:
        inputstr | numerator | denominator | result
        "1/4"    | 1         | 4           | new BigDecimal(0.25)
    }

    def "Format"() {
        given:
        def fraction = new Fraction(numerator: numerator, denominator: denominator, result: result)
        expect:
        response == FractionUtil.format(fraction)
        where:
        response | numerator | denominator | result
        "1/4"    | 1         | 4           | 0.25
        "1"      | 1         | 1           | 1
        "0"      | 0         | 1           | 0

    }

    @Unroll
    def "CheckIsValid"() {
        expect:
        result == FractionUtil.checkIsValid(test)
        where:
        result | test
        true   | "1/4"
        false  | "r/3"
        false  | "3/r"
        false  | "2/0"
    }
}
