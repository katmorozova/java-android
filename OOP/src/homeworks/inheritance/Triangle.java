package homeworks.inheritance;

public class Triangle extends Shape{

    int c;

    public Triangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public int getPerimeter() {
        return super.getPerimeter() + c;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
