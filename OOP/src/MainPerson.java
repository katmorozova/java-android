public class MainPerson {

    public static void main(String[] args) {

    Person dany = new Person("Dany", 34, 76);
    /*
    dany.name = "Dany";
    dany.age = 34;
    dany.weight = 76;
     */

    Person olga = new Person("Olga", 64, 53);
    /*
    olga.name = "Olga";
    olga.age = 64;
    olga.weight = 53;
     */

    Person xavi = new Person("Xavi", 46, 84);
    /*
    xavi.name = "Xavi";
    xavi.age = 46;
    xavi.weight = 84;
     */

    double sumAges = dany.getAge() + olga.getAge() + xavi.getAge();
    double average = sumAges / 3;

        System.out.println(average);




    }
}
