package homeworks;

public class PersonWrappers {

    private String name;
    private int age;

    public PersonWrappers(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void showInfo(){
        String info = "Name: " +getName() +". Age: " +getAge();
        System.out.println(info);
    }
}
