package numberTranslator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTranslatorTest {

    @Test
    void hundredPartShouldReturnZeroWithGivenZero() {
        //GIVEN
        int number = 0;

        //WHEN
        String output = NumberTranslator.hundredPart(number);

        //THEN
        Assertions.assertEquals("Zero" , output);
    }

    @Test
    void hundredPartShouldReturnTranslatedGivenNumber() {
        //GIVEN
        int number = 123;

        //WHEN
        String output = NumberTranslator.hundredPart(number);

        //THEN
        Assertions.assertEquals("one hundred twenty-three" , output);
    }

    @Test
    void numberTranslatorShouldReturnZeroWithGivenZero() {
        //GIVEN
        long number = 0;

        //WHEN
        String output = NumberTranslator.numberTranslator(number);

        //THEN
        Assertions.assertEquals("Zero" , output);
    }

    @Test
    void numberTranslatorShouldReturnTranslatedGivenNumber() {
        //GIVEN
        long number = 12345;

        //WHEN
        String output = NumberTranslator.numberTranslator(number);

        //THEN
        Assertions.assertEquals("twelve thousand three hundred forty-five" , output);
    }
}