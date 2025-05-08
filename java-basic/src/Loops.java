public class Loops {

    public static void main(String[] args) {

        //ciclo while
        int i = 1;
        while(i <= 1000) {
            System.out.println(i);
            ++i;
            if (i == 5) {
                break;
            }
        }

        //HOMEWORK
        int e = 0;
        while (e <= 1000){
            //if(e % 2 == 0){....}
            System.out.println(e);
            e += 2;
        }
        //End


        //ciclo do()while{}
        int a = 0;
        do {
            System.out.println("Hello!");
        }while (a > 0);



        //ciclo for
        for(int j = 0; j <= 1000; ++j) {
            System.out.println(j);
        }

        //HOMEWORK
        for(int b = 1000; b > 0; b--) {
            if(b % 3 == 0) {
                System.out.println(b);
            }
        }
        //End


        //ciclo for anidado
        for(int k = 1; k <= 1000; ++k) {
            for(int m = 1000; m >= 0; --m) {
                if (m % 2 == 0) {
                    System.out.println(m);
                }
            }
        }



    }


}
