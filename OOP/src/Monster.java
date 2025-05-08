public class Monster {

    int eye;
    int hand;
    int foot;

    Monster(int eye, int hand, int foot){
        this.eye = eye;
        this.hand = hand;
        this.foot = foot;
    }

    Monster(int count){
        this(count, count, count);
    }
    Monster(){
        this(2);
    }

    void showInfo(){
        String info = "Eyes: "+eye+"\nHands: "+hand+"\nFoots: "+foot;
        System.out.println(info);
    }

}
