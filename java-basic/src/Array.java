public class Array {

    public static void main(String[] args) {
        String[] namesOfMonths = new String[]{"January", "February", "March", "April", "May", "Juny", "July", "Augost", "September", "October", "November", "December"};

        for(int i = 0; i < namesOfMonths.length; ++i) {
            System.out.print(namesOfMonths[i]);
            if (i < namesOfMonths.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }

        int[] numbers = new int[]{4, 1, 34, 45, 13};

        for(int i = 0; i < numbers.length; ++i) {
            System.out.println(numbers[i]);
        }

        for(int i = numbers.length - 1; i > 0; --i) {
            System.out.println(numbers[i]);
        }


    }
}
