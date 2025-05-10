package homeworks.inheritance;

public abstract class Shape {

    int a;
    int b;

    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getPerimeter(){
        return a + b;
    }

    public void showInfo(){
        System.out.println(getPerimeter());
    }
}
