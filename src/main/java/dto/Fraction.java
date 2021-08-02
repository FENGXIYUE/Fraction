package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/2 3:25 下午
 * @modified By
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fraction {
    /**
     * 分子
     */
    private int numerator;

    /**
     * 分母
     */
    private int denominator;

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
