public class MainMonster {

    public static void main(String[] args) {

        Monster monster = new Monster();
        monster.showInfo();
        monster.voice();
        monster.voice(5);
        monster.voice(4, "Aaaaaaaa....");
    }
}
