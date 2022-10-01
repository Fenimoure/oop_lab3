import java.util.Objects;
import java.util.Scanner;

public class BigInt {
    private String num;

    public BigInt() {
        this.num = "0";
        System.out.println("Hello from unnamed!");
    }

    public BigInt(long num) {
        StringBuilder bigIntNum = new StringBuilder(Long.toString(num));
        while (bigIntNum.charAt(0) == '0' && bigIntNum.length() > 1) bigIntNum.deleteCharAt(0);
        this.num = bigIntNum.toString();
        System.out.println("Hello from " + this);
    }

    public BigInt(String num) {
        StringBuilder bigIntNum = new StringBuilder(num);
        while (bigIntNum.charAt(0) == '0' && bigIntNum.length() > 1) bigIntNum.deleteCharAt(0);
        this.num = bigIntNum.toString();
        System.out.println("Hello from " + this);
    }

    public BigInt(BigInt bigInt) {
        this.num = bigInt.num;
        System.out.println("Hello from " + this);
    }

    public String getNum() {
        return num;

    }

    public void setNum(String in_num) {
        checkInput(in_num);
        this.num = in_num;
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
        String input = reader.nextLine();
        while (!checkInput(input)) {
            input = reader.nextLine();
            checkInput(input);
        }
        this.num = input;
    }

    private boolean checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                System.out.println("Wrong BigInt.");
                return false;
            }
        }
        return true;
    }

    public BigInt addBigInt(BigInt bigInt) {
        int res_len = this.num.length() + 1;
        if (bigInt.num.length() > res_len) res_len = bigInt.num.length() + 1;
        int[] num1 = new int[this.num.length()];
        int[] num2 = new int[bigInt.num.length()];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < res_len; i++) res.append('0');
        for (int i = 0; i < num1.length; i++) num1[i] = Character.getNumericValue(this.num.charAt(i));
        for (int i = 0; i < num2.length; i++) num2[i] = Character.getNumericValue(bigInt.num.charAt(i));
        int temp = 0;
        int sum;
        for (int i = 1; i <= res_len; i++) {
            sum = 0;
            if (num1.length - i >= 0) sum += num1[num1.length - i];
            if (num2.length - i >= 0) sum += num2[num2.length - i];
            sum += temp;
            temp = sum / 10;
            res.setCharAt(res_len - i, (char) ((sum % 10) + '0'));
        }
        while (res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        this.setNum(res.toString());
        return this;
    }

    public BigInt subBigInt(BigInt bigInt) {
        int res_len = this.num.length();
        int[] num1;
        int[] num2;
        if (bigInt.num.length() > res_len) {
            res_len = bigInt.num.length();
            num1 = new int[bigInt.num.length()];
            num2 = new int[this.num.length()];
            for (int i = 0; i < num1.length; i++) num1[i] = Character.getNumericValue(bigInt.num.charAt(i));
            for (int i = 0; i < num2.length; i++) num2[i] = Character.getNumericValue(this.num.charAt(i));
        } else {
            num1 = new int[this.num.length()];
            num2 = new int[bigInt.num.length()];
            for (int i = 0; i < num1.length; i++) num1[i] = Character.getNumericValue(this.num.charAt(i));
            for (int i = 0; i < num2.length; i++) num2[i] = Character.getNumericValue(bigInt.num.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < res_len; i++) res.append('0');
        int temp = 0;
        int dif;
        for (int i = 1; i <= res_len; i++) {
            dif = 10;
            if (num1.length - i >= 0) dif += num1[num1.length - i];
            if (num2.length - i >= 0) dif -= num2[num2.length - i];
            dif -= temp;
            if (num2.length - i >= 0) temp = ((num1[num1.length - i] - temp) < num2[num2.length - i]) ? 1 : 0;
            res.setCharAt(res_len - i, (char) ((dif % 10) + '0'));
        }
        while (res.charAt(0) == '0' && res.length() != 1) {
            res.deleteCharAt(0);
        }
        this.setNum(res.toString());
        return this;
    }


    public BigInt multiplyBigInt(BigInt by) {
        long iter = Long.parseLong(by.getNum());
        BigInt temp = new BigInt(this);
        if (iter == 0) this.setNum("0");
        for (int i = 0; i < iter - 1; i++) {
            this.addBigInt(temp);
        }
        return this;
    }


    public BigInt divideBigInt(BigInt by) {
        if (Objects.equals(by.getNum(), "0")) {
            System.out.println("ZERO DIVISION! RETURN NULL.");
            return null;
        }
        int iter = 0;
        BigInt temp = new BigInt(this);
        while (temp.isGreater(by) || temp.isEqual(by)) {
            iter++;
            temp.subBigInt(by);
        }
        this.setNum((iter + ""));
        return this;
    }

    public boolean isGreater(BigInt bigInt) {
        if (this.num.length() < bigInt.num.length()) return false;
        else if (this.num.length() > bigInt.num.length()) return true;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) > Character.getNumericValue(bigInt.num.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean isGreater(int integer) {
        String temp = Integer.toString(integer);
        if (this.num.length() < temp.length()) return false;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) > Character.getNumericValue(temp.charAt(i))) return true;
        }
        return true;
    }

    public boolean isLesser(BigInt bigInt) {
        if (this.num.length() > bigInt.num.length()) return false;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) < Character.getNumericValue(bigInt.num.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean isLesser(int integer) {
        String temp = Integer.toString(integer);
        if (this.num.length() > temp.length()) return false;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) < Character.getNumericValue(temp.charAt(i))) return true;
        }
        return true;
    }

    public boolean isEqual(BigInt bigInt) {
        if (this.num.length() != bigInt.num.length()) return false;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) != Character.getNumericValue(bigInt.num.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isEqual(int integer) {
        String temp = Integer.toString(integer);
        if (this.num.length() != temp.length()) return false;
        for (int i = 0; i < this.num.length(); i++) {
            if (Character.getNumericValue(this.num.charAt(i)) != Character.getNumericValue(temp.charAt(i)))
                return false;
        }
        return true;
    }


    public void assign(BigInt bigInt) {
        this.num = bigInt.num;
    }

    public void assign(int integer) {
        this.num = Integer.toString(integer);
    }
}
