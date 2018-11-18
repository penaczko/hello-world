public class FizzBuzzCreator {
    static void createFizzBuzzSequence(int number) {
        int i = 0;

        while(i <= number) {
            String fb = (i % 15 == 0 ? "Fizz-Buzz"
                    : (i % 3 == 0 ? "Fizz"
                        : (i % 5 == 0 ? "Buzz"
                            : String.valueOf(i))));
            System.out.println(fb);
            i++;
        }
    }
}