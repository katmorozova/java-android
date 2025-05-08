public class Conditionals {
    public static void main(String[] args) {

        int temp = 27;
        if (temp > 25) {
            System.out.println("Aire encendido");
        } else if (temp < 22) {
            System.out.println("Aire apagado");
        } else {
            System.out.println("Aire no hace nada");
        }

        int money = 6;
        if (money >= 10) {
            System.out.println("Hoy comes pizza!");
        } else if (money >= 6 && money < 10) {
            System.out.println("Hoy comes hamburguesa!");
        } else {
            System.out.println("Hoy comes sandwich!");
        }
    }
}
