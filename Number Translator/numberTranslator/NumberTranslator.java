package numberTranslator;

import static java.lang.Math.toIntExact;
import static jdk.nashorn.internal.objects.NativeString.trim;

public class NumberTranslator {
    private static String digit[] = {"one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
    private static String teen[] = {"eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "seventeen" , "eighteen" , "nineteen"};
    private static String ten[] = {"ten" , "twenty" , "thirty" , "forty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
    private static String thousandMillionBillion[] = {"" , "thousand" , "million" , "billion"};

    static String hundredPart(int number) {
        String output = "";

        if(number == 0) {
            return "zero";
        }

        if(number >= 100) {
            output += digit[(number / 100) - 1] + " hundred" + (number % 100 == 0 ? "" : " ");
            number %= 100;
        }

        if(number == 10 || number >= 20) {
            output += ten[(number / 10) - 1] + (number % 10 == 0 ? "" : "-");
            number %= 10;
        }
        else if(number >= 11) {
            output += teen[number - 11];
            number = 0;
        }

        if(number > 0 && number <= 9) {
            output += digit[number - 1];
        }

        return output;
    }

    public static String numberTranslator(long number) {
        String output = "";
        int counter = 0;

        if(number == 0) {
            return "zero";
        }

        while(number > 0) {
            if(number % 1000 != 0) {
                output = hundredPart(toIntExact(number % 1000)) + " " + thousandMillionBillion[counter] + " " + output;
            }
            number /= 1000;
            counter++;
        }

        return trim(output);
    }
}
