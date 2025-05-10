package inheritance;

public class MainBox {

    public static void main(String[] args) {
        Box box1 = new Box(10,10,10);
       /*
        box1.height = 10;
        box1.width = 10;
        box1.length = 10;
        */
        //box1.setDimens(10, 10, 10);

        Box box2 = new Box(20,20,20);
        /*
        box2.height = 20;
        box2.width = 20;
        box2.length = 20;

        inheritance.Box box3 = box2;

         */

        //double volume1 = box1.height * box1.length * box1.width;
        //double volume1 = box1.getVolume();
        //double volume2 = box2.height * box2.length * box2.width;
        //double volume2 = box2.getVolume();
        //System.out.println(volume1);
        //System.out.println(volume2);

        box1.showVolume();
        box2.showVolume();

        Box current = new Box(10, 10, 10);
        //inheritance.Box another = new inheritance.Box(20, 20, 20);
        Box another = current.copy();
        Box another2 = current.increase();
        current.compare(another);
        int count = current.compare(another);
        System.out.println(count);

        current.showVolume();
        another.showVolume();
        another2.showVolume();

        Box boxBox = new Box(10);
        WeightBox weightBox = new WeightBox(10, 13);
        boxBox.showInfo();
        weightBox.showInfo();


    }
}
