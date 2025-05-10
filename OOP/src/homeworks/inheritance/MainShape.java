package homeworks.inheritance;

public class MainShape {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(4, 8,4);
        rectangle.showInfo();
        triangle.showInfo();
    }

}
