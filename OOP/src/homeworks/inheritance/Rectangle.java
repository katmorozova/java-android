package homeworks.inheritance;

public class Rectangle extends Shape{
    public Rectangle(int a, int b) {
        super(a, b);
    }

    @Override
    public int getPerimeter() {
        return super.getPerimeter() * 2;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
