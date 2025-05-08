public class ForEach {

    public static void main(String[] args) {

        String[] names = new String[]{
                "Elena",
                "Alfonso",
                "Gabriela",
                "Martin"
        };

        for(String name : names) {
            System.out.println(name);
        }

        int[] numbers = new int[100];

        for(int i = 0; i < numbers.length; ++i) {
            numbers[i] = i + 100;
            System.out.println(numbers[i]);
        }

        for(int number : numbers) {
            System.out.println(number);
        }


}
}
