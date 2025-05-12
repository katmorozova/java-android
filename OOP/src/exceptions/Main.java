package exceptions;

public class Main {

    public static void main(String[] args) {
        int a = 1;
        try{
            int b = 7 / a;
            int c = Integer.parseInt("fjgkjgjjg");
        } catch (Exception e) {
            System.out.println("Encontrada excepcion " + e.getClass());
        }
        /*
        catch (ArithmeticException e){
            System.out.println("No se puede dividir en cero");
        }catch (NumberFormatException e1){
            System.out.println("NumberFormatException");
        }
         */

        System.out.println("Hello!");
    }
}
