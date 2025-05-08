public class Box {

    double length;
    double width;
    double height;

    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
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
