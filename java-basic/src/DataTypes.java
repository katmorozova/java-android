public class DataTypes {

    public static void main(String[] args) {

        long speed = 300000L;
        long distance = 31536000L * speed;
        System.out.println(distance);

        byte b = 127;
        ++b;
        ++b;
        ++b;
        System.out.println(b);

        float radius = 10.8F;
        double pi = 3.14;
        double area = pi * (double)radius * (double)radius;
        System.out.println(area);

        //HOMEWORK
        int ageFather = 46;
        int ageMother = 38;
        int ageChild = 3;
        double ageSum = (double)(ageFather + ageMother + ageChild);
        double agePromedio = ageSum / (double)3.0F;
        System.out.println(agePromedio);
        //End


        char x = 'X';
        char x1 = 'X';
        ++x1;
        System.out.println("Value of x is " + x);
        System.out.println("Value of x1 is " + x1);


        int temp = 30;
        boolean hot = temp >= 25;
        boolean cold = temp <= 22;
        int time = 23;
        boolean isNight = time > 22 || time < 6;
        if (hot && !isNight) {
            System.out.println("Aire encendido");
        } else if (cold) {
            System.out.println("Aire apagado");
        } else {
            System.out.println("Aire no hace nada");
        }

        //HOMEWORK

        boolean goodWeather = false;
        boolean isDay = true;
        if (isDay && goodWeather) {
            System.out.println("Puedes salir a pasear");
        } else if (isDay & !goodWeather) {
            System.out.println("Puedes leer libro");
        } else if (!isDay || goodWeather) {
            System.out.println("Puedes ir a dormir");
        }
        //End

        String s = "Hello World!";
        System.out.println(s);
        String hello = "Hello";
        String world = "World";
        System.out.println(hello + " " + world + "!");
        String name = "John";
        int age = 34;
        String result = "Hola, \"" + name + "\".\nTienes " + age + " años.";
        System.out.println(result);


    }
}
