public class Box {

    double length;
    double width;
    double height;

    Box(){
        /*
        this.length = 10;
        this.width = 10;
        this.height = 10;
         */
        this(10);
    }

    Box(Box another){
        this(another.length, another.width, another.height);
    }

    Box copy(){
        return new Box(
                this.length = length,
                this.width = width,
                this.height = height
        );
    }

    Box increase(){
        return new Box(
                this.length = length * 2,
                this.width = width * 2,
                this.height = height * 2
        );
    }

    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    Box(double size){
        this(size, size, size);
    }
/*
    void compare(Box another){
        double currentVolume = getVolume();
        double anotherVolume = another.getVolume();
        if(currentVolume > anotherVolume){
            System.out.println("Current > Another");
        } else if (currentVolume < anotherVolume) {
            System.out.println("Current < Another");
        } else {
            System.out.println("Current == Another");
        }
    }

 */

    int compare(Box another){
        double currentVolume = getVolume();
        double anotherVolume = another.getVolume();
        int count;
        if(currentVolume > anotherVolume){
            count = 1;
        } else if (currentVolume < anotherVolume) {
            count = - 1;
        } else {
            count = 0;
        }
        return count;
    }

    void setDimens(double length, double width, double height ){
        this.length = length;
        this.width = width;
        this.height = height;

    }


    double getVolume(){
        /*
        double volume = length * width * height;
        return  volume;
         */
        return length * width * height;
    }

    void showVolume(){
        //double volume = length * width * height;
        //double volume = getVolume();
        //System.out.println(volume);
        System.out.println(getVolume());
    }

}
