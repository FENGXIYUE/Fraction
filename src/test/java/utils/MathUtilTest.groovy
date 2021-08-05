package utils

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/3 9:32 上午
 * @modified By
 */
class MathUtilTest extends Specification {
    @Unroll
    def "GetCommonFactor"() {
        expect:
        result == MathUtil.getCommonFactor(a, b)
        where:
        result | a | b
        2      | 4 | 2
        2      | 2 | 4
        4      | 4 | 4

    }

    @Unroll
    def "isNumeric"() {
        expect:
        result == MathUtil.isNumeric(str)
        where:
        result | str
        true   | "4"
        true   | "2222"
        true   | "-4"
        false  | "!4"
        false  | "--4"
        false  | "1.2"

    }
}
