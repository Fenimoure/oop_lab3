public class BigInt {
    private long num;

    public BigInt() {
        System.out.println("Hello from unnamed!");
    }

    public BigInt(long num) {
        this.num = num;
    }
    public BigInt(String num) {
        this.num = Long.parseLong(num);
        System.out.println("Hello from " + num);
    }
    public BigInt(BigInt num) {
        this.num = num.num;
        System.out.println("Hello from " + num.num);
    }
}
