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

    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    Box(double size){
        this(size, size, size);
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
