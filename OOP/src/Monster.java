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

    void voice(){
        System.out.println("Grrrrrrrrr...");
    }

    void voice(int count){
            voice(count, "Grrrrrrrr...");
    }

    void voice(int count, String word){
        for(int i = 0; i < count; i++){
            System.out.println(word);
        }
    }

}
