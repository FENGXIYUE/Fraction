package exception;

/**
 * @author: LLT
 * @description: 参数选择异常
 * @date: 2021/8/2 5:17 下午
 * @modified By
 */

public class ArgumentNotValidException extends RuntimeException {

    /**
     * 异常信息
     */
    private String message;


    public ArgumentNotValidException(String message) {
        super(message);
        this.message = message;

    }

}
