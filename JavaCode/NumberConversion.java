public class NumberConversion {
    public static String toRadix(String in, int inRadix, int outRadix) {
        assert inRadix == 2 || inRadix == 8 || inRadix == 10 || inRadix == 16;
        assert outRadix == 2 || outRadix == 8 || outRadix == 10 || outRadix == 16;
        //TODO

        int param = Integer.parseInt(in, inRadix);
        switch (outRadix){
            case 2: return Integer.toBinaryString(param);
            case 8: return Integer.toOctalString(param);
            case 10: return Integer.toString(param);
            case 16: return Integer.toHexString(param).toUpperCase();
        }
        return null;
    }
}
