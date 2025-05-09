public class Wrappers {

    public static void main(String[] args) {
        int a = 5;
        Integer a1 = 5;
        byte b;
        Byte b1;
        short c;
        Short c1;
        long d;
        Long d1;
        char e;
        Character e1;
        float g;
        Float g1;
        double h;
        Double h1;
        boolean i;
        Boolean i1;

        String s = "1000";
        String s1 = "2000";
        int k = Integer.parseInt(s);
        int m = Integer.parseInt(s1);
        System.out.println(k + m);


        String w = "This is John. He is 27 years old.";
        String name = w.substring(8, 12);
        System.out.println(name);
    }
}
