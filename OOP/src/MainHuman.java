import java.util.Random;

public class MainHuman {

    public static void main(String[] args) {

        //toString(), String.format()
        Human human = new Human("John", 17);
        System.out.println(human.toString());


        //Random
        Random random = new Random();
        for (int i = 0; i < 100; i++){
            //int a = random.nextInt(11);
            //int a = random.nextInt(5,11);
            int number = random.nextInt(1,7);
            String result = String.format("Vuestro numero: %s", number);
            //System.out.println(a + " ");
            System.out.println(result);
        }
    }
}
