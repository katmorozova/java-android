package homeworks.anonimclases;

public class MainClient {

    public static void main(String[] args) {

        Client client = new Client();
        client.demanar(new Waiter() {
            @Override
            public void servir(String plato) {
                System.out.println("Vuestro plato: " + plato);
            }
        }, "Pizza");


    }
}
