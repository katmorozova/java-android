package homeworks;

public class Worker {

    String name;
    String profession;
    double salary;

    Worker(String name, String profession, double salary){
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    void showInfo(){
        String info = "Name: "+name+"\nProfession: "+profession+"\nSalary: "+salary;
        System.out.println(info);
    }
}
