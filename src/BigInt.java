import java.util.Scanner;

public class BigInt {
    private String num;

    public BigInt() {
        System.out.println("Hello from unnamed!");
    }

    public BigInt(long num) {
        this.num = Long.toString(num);
    }

    public BigInt(String num) {
        this.num = num;
        System.out.println("Hello from " + this);
    }

    public BigInt(BigInt num) {
        this.num = num.num;
        System.out.println("Hello from " + this);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String inum) {
        checkInput(inum);
        this.num = inum;
    }

    @Override
    public String toString() {
        return "BigInt{" +
                "num=" + num +
                '}';
    }

    public void outBigInt() {
        System.out.println(this);
    }

    public void inBigInt() {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        checkInput(input);
        this.num = input;
    }

    private void checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                System.out.println("Wrong BigInt.");
                return;
            }
        }
    }

    public void sumBigInt(BigInt bigInt) {
        int tempr = 0;
        int len = this.num.length();
        if (bigInt.num.length() > len) len = bigInt.num.length();
        int first[];
//        char [] second = bigInt.num.charAt();
        /*
         00111111001010000
         -----------------
         12346791658349238+
         23453409530738240
         =================
         35800101189087478

         first iter:
         temp = (num1[len - 1 - 0] + num2[len - 1 - 0])
         result[len - 1 - 0] = num1[len - 1 - 0]
        */
    }
}
