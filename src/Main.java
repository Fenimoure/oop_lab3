public class Main {
    public static void main(String[] args) {
        BigInt anum = new BigInt("92357686");
        BigInt bnum = new BigInt(141935678);
        BigInt cnum = new BigInt(anum);
        Calculator Calc = new Calculator();

//        System.out.println(anum);
//        System.out.println(bnum);
//        System.out.println(cnum);
        cnum.inBigInt();
//        System.out.println(cnum);

        Calc.init();
        System.out.println(anum.isEqual(cnum));
        System.out.println(anum.subBigInt(bnum).getNum());
        System.out.println(anum.multiplyBigInt(bnum));
    }
}