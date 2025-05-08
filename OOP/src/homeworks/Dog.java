package homeworks;

public class Dog {

    String name;
    String breed;
    int weight;
    int speed;


    String getInfo(){
        return "Nombre: "+name+"\nRasa: "+breed+"\nWeight: "+weight;
    }

    int run(){
        for (int i = 0; i < speed; i++){
            System.out.println("Running");
        }
        return speed;
    }
}
