public class MainBox {

    public static void main(String[] args) {
        Box box1 = new Box();
       /*
        box1.height = 10;
        box1.width = 10;
        box1.length = 10;
        */
        box1.setDimens(10, 10, 10);

        Box box2 = new Box();
        box2.height = 20;
        box2.width = 20;
        box2.length = 20;

        Box box3 = box2;

        //double volume1 = box1.height * box1.length * box1.width;
        //double volume1 = box1.getVolume();
        //double volume2 = box2.height * box2.length * box2.width;
        //double volume2 = box2.getVolume();
        //System.out.println(volume1);
        //System.out.println(volume2);

        box1.showVolume();
        box2.showVolume();

    }
}
