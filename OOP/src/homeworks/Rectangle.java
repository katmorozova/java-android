package homeworks;

public class Rectangle {

    int length;
    int width;

    void setDimens(int length, int width){
        this.length = length;
        this.width = width;
    }

    int getArea(){
        return length * width;
    }

}
