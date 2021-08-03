package config;

import exception.ArgumentNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/2 5:20 下午
 * @modified By
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ArgumentNotValidException.class)
    public void handleArgumentNotValidException(ArgumentNotValidException exception) {
        log.info(exception.getMessage()
                + "\r\n" + "请输入正确编码"
                + "\r\n" + "1 分数转小数"
                + "\r\n" + "2 分数间运算"
                + "\r\n" + "3 退出此程序");
    }
}
