public class Variables {

    public static void main(String[] args) {
        int x = 5;
        int y = x + 5;
        System.out.println(y);

    //HOMEWORK
        int john = 100;
        int nick = john * 5;
        int result = john + nick;
        System.out.println(result);
    //End

    int a = 10;
    int b = 3;
    int c = a / b;
    int c1 = a % b;
        System.out.println(c);
        System.out.println(c1);


    int days = 10_000;
    int year = 365;
    int years = days / year;
    int months = (days - (years * year) / 30);
    int leftDays = days - (years * year) - (months * 30);
        System.out.println(years);
        System.out.println(months);
        System.out.println(leftDays);

    }
}
