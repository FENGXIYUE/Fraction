package exception;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/2 5:17 下午
 * @modified By
 */

public class ArgumentNotValidException extends RuntimeException {
    private String message;

    public ArgumentNotValidException(Throwable cause){
        super(cause);

    }

    public ArgumentNotValidException(String message){
        super(message);
        this.message = message;

    }

}
