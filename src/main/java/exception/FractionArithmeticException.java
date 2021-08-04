package exception;

/**
 * @author: LLT
 * @description: 分数算数异常
 * @date: 2021/8/4 3:35 下午
 * @modified By
 */
public class FractionArithmeticException extends RuntimeException{
    /**
     * 异常信息
     */
    private String message;


    public FractionArithmeticException(String message) {
        super(message);
        this.message = message;

    }

}
