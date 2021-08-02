import java.util.Scanner;

/**
 * @author: LLT
 * @description:
 * @date: 2021/8/2 3:33 下午
 * @modified By
 */
public class AppStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用分数运算工具："
                + "\r\n" + "请输入对应编码"
                + "\r\n" + "1 分数转小数"
                + "\r\n" + "2 分数间运算"
                + "\r\n" + "3 退出此程序");
        while (true) {
            String inputLine = scanner.nextLine();
            if ("3".equals(inputLine)) {
                break;
            } else if ("1".equals(inputLine)) {
                System.out.println("待转化分数");
                String fraction = scanner.nextLine();
                System.out.println("结果为：");
            } else if ("2".equals(inputLine)) {
                System.out.println("运算表达式");
                String expression = scanner.nextLine();
                System.out.println("结果为：");
            } else {
                System.out.println("编码未识别："
                        + "\r\n" + "请输入正确编码"
                        + "\r\n" + "1 分数转小数"
                        + "\r\n" + "2 分数间运算"
                        + "\r\n" + "3 退出此程序");
            }

        }
    }
}
