public class ZYAlgorithm {
    public static void main(String[] args) {
        /*
        System.out.println("cb-i-0000000001-15359567255-6193".length());
        encrypt(1000000000L);
        encrypt(1000000001L);
        */
    }

    private static String encrypt(Long theNumber) {
        long f1 = (theNumber & 0x0000000f) << 28;
        long f2 = (theNumber & 0x000000f0) << 20;
        long f3 = (theNumber & 0x00000f00) << 12;
        long f4 = (theNumber & 0x0000f000) << 4;
        long f5 = (theNumber & 0x000f0000) >> 4;
        long f6 = (theNumber & 0x00f00000) >> 12;
        long f7 = (theNumber & 0x0f000000) >> 20;
        long f8 = (theNumber & 0xf0000000) >> 28;
        long i = f1 | f2 | f3 | f4 | f5 | f6 | f7 | f8;
        String res = Long.toString(i, 36);
        res = String.format("%8s", res).replace(' ', '0');
        System.out.println("source=" + theNumber + ", to=" + i + ", hex=" + res + ", decrypt=" + decrypt(res));
        return res;
    }

    private static long decrypt(String theNumber) {
        long parseLong = Long.parseLong(theNumber, 36);
        long f1 = (parseLong & 0x0000000f) << 28;
        long f2 = (parseLong & 0x000000f0) << 20;
        long f3 = (parseLong & 0x00000f00) << 12;
        long f4 = (parseLong & 0x0000f000) << 4;
        long f5 = (parseLong & 0x000f0000) >> 4;
        long f6 = (parseLong & 0x00f00000) >> 12;
        long f7 = (parseLong & 0x0f000000) >> 20;
        long f8 = (parseLong & 0xf0000000) >> 28;
        long i = f8 | f7 | f6 | f5 | f4 | f3 | f2 | f1;
        return i;
    }
}