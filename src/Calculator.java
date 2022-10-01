//I am aware this class is weird. I think I have not understood the task correctly.

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public void init(){
        BigInt op1 = new BigInt();
        BigInt op2 = new BigInt();
        System.out.print("Введіть операнд 1: ");
        op1.inBigInt();
        System.out.print("Введіть операнд 2: ");
        op2.inBigInt();
        Scanner reader = new Scanner(System.in);
        System.out.print("Введіть оператор (зверніть увагу, що множення та ділення — цілочисельні): ");
        String input = reader.nextLine();
        while (!Objects.equals(input, "Вихід")) {
            switch (input) {
                case "+":
                    System.out.println(op1.getNum() + " + " + op2.getNum() + " = " + op1.addBigInt(op2).getNum());
                    input = getInput(op1, op2, reader);
                    break;
                case "-":
                    System.out.println("abs(" + op1.getNum() + " - " + op2.getNum() + ") = " + op1.subBigInt(op2).getNum());
                    input = getInput(op1, op2, reader);
                    break;
                case "*":
                    System.out.println(op1.getNum() + " * " + op2.getNum() + " = " + op1.multiplyBigInt(op2).getNum());
                    input = getInput(op1, op2, reader);
                    break;
                case "/":
                    System.out.println(op1.getNum() + " / " + op2.getNum() + " = " + op1.divideBigInt(op2).getNum());
                    input = getInput(op1, op2, reader);
                    break;
                default: {
                    System.out.println("Можливі операції: '+', '-', '*', '/', \"Вихід\"");
                }
                input = getInput(op1, op2, reader);
            }
        }
    }

    private static String getInput(BigInt op1, BigInt op2, Scanner reader) {
        String input;
        System.out.print("Введіть операнд 1: ");
        op1.inBigInt();
        System.out.print("Введіть операнд 2: ");
        op2.inBigInt();
        System.out.print("Введіть оператор (зверніть увагу, що множення та ділення — цілочисельні): ");
        input = reader.nextLine();
        return input;
    }
}
