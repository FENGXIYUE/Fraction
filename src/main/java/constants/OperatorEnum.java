package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/4 4:53 下午
 * @modified By
 */
@AllArgsConstructor
@Getter
public enum OperatorEnum {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    private String value;

}
