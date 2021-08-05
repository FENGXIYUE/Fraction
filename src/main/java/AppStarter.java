import constants.OperatorEnum;
import exception.ArgumentNotValidException;
import exception.FractionArithmeticException;
import lombok.extern.slf4j.Slf4j;
import util.ExpressionPrepareUtil;
import utils.FractionUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/2 3:33 下午
 * @modified By
 */
@Slf4j
public class AppStarter {

    private static String OPTION_MSG = "1 分数转小数"
            + "\r\n" + "2 分数间运算"
            + "\r\n" + "3 退出此程序";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("欢迎使用分数运算工具："
                + "\r\n" + "请输入对应编码"
                + "\r\n" + OPTION_MSG);
        while (true) {
            try {
                String inputLine = scanner.nextLine();
                if ("3".equals(inputLine)) {
                    break;
                } else if ("1".equals(inputLine)) {
                    System.out.println("待转化分数");
                    String fraction = ExpressionPrepareUtil.removeStrSpace(scanner.nextLine());
                    //计算对应的小数值
                    System.out.println("结果为：" + FractionUtil.parse(fraction).getResult());
                    System.out.println(OPTION_MSG);
                } else if ("2".equals(inputLine)) {
                    System.out.println("选择相应运算"
                            + "\r\n" + "+"
                            + "\r\n" + "-"
                            + "\r\n" + "*"
                            + "\r\n" + "\\");
                    String operator = ExpressionPrepareUtil.removeStrSpace(scanner.nextLine());
                    if (Arrays.stream(OperatorEnum.values()).noneMatch(operatorEnum -> operatorEnum.getValue().equals(operator))) {
                        throw new ArgumentNotValidException("输入运算符异常");
                    }
                    System.out.println("请输入第一个分数");
                    String fraction1 = ExpressionPrepareUtil.removeStrSpace(scanner.nextLine());
                    System.out.println("请输入第二个分数");
                    String fraction2 = ExpressionPrepareUtil.removeStrSpace(scanner.nextLine());
                    System.out.println("结果为：" + FractionUtil.calculateExpression(fraction1,fraction2,operator));
                    System.out.println(OPTION_MSG);

                } else {
                    throw new ArgumentNotValidException("输入编码异常");
                }
            } catch (Exception e) {
                if (e instanceof ArgumentNotValidException) {
                    log.error(e.getMessage()
                            + "\r\n" + "大侠,请重新来过!"
                            + "\r\n" + OPTION_MSG);
                } else if (e instanceof FractionArithmeticException) {
                    log.error(e.getMessage()
                            + "\r\n" + "大侠,请重新来过!"
                            + "\r\n" + OPTION_MSG);
                }

            }


        }
    }
}
