public class MainPerson {

    public static void main(String[] args) {

    Person dany = new Person();
    dany.name = "Dany";
    dany.age = 34;
    dany.weight = 76;

    Person olga = new Person();
    olga.name = "Olga";
    olga.age = 64;
    olga.weight = 53;

    Person xavi = new Person();
    xavi.name = "Xavi";
    xavi.age = 46;
    xavi.weight = 84;

    double sumAges = dany.age + olga.age + xavi.age;
    double average = sumAges / 3;

        System.out.println(average);




    }
}
