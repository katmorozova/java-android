

public class Human {
    private String name;
    private int age;


    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        //return "Name: "+name+" Age: "+age;//toString()
        return String.format("Name: %s Age: %s", name, age);//String.format()
    }


}
