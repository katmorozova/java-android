package homeworks;

public class Exceptions {

    public static void main(String[] args) {
        //ArrayIndexOutOfBoundsException
        int[] numbers = new int[10];
        try {
            for (int i = 1; i < numbers.length; i++) {
                System.out.println(numbers[10]);
            }
        }catch (Exception e){
            System.out.println("Encontrada excepcion " + e.getClass());
        }
    }
}
