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
    }

    def "Format"() {
        given:
        def fraction = new Fraction(numerator: numerator, denominator: denominator)
        expect:
        result == FractionUtil.format(fraction)
        where:
        result | numerator | denominator
        "1/4"  | 1         | 4
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
