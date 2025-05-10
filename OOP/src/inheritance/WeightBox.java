package inheritance;

public class WeightBox extends Box {

    double weight;

    WeightBox() {
        this.weight = 10;
    }

    WeightBox(Box another, double weight) {
        super(another);
        this.weight = weight;
    }

    WeightBox(double length, double width, double height, double weight) {
        super(length, width, height);
        this.weight = weight;
    }

    WeightBox(double size, double weight) {
        super(size);
        this.weight = weight;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Weight: " + weight);
    }
}
