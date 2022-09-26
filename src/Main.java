public class Main {
    public static void main(String[] args) {
        BigInt anum = new BigInt("1234567891123");
        BigInt bnum = new BigInt(999999999);
        BigInt cnum = new BigInt(anum);
        System.out.println(anum);
        System.out.println(bnum);
        System.out.println(cnum);
        cnum.inBigInt();
        System.out.println(cnum);
        System.out.println();
    }
}