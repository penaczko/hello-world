import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import piCreator.PiCreator;
import java.math.BigDecimal;


class PiCreatorTest {


    @Test
    public void shouldReturnNaughtForInvalidDecimalPlaces() {
        //GIVEN
        double precision = 0.001;
        int decimalPlaces = 101;

        //WHEN
        BigDecimal actualPi = PiCreator.createPiNumber(precision , decimalPlaces);

        //THEN
        Assertions.assertEquals(BigDecimal.ZERO , actualPi);
    }

    @Test
    public void shouldReturnNaughtForInvalidPrecision() {
        //GIVEN
        double precision = -1;
        int decimalPlaces = 20;

        //WHEN
        BigDecimal actualPi = PiCreator.createPiNumber(precision , decimalPlaces);

        //THEN
        Assertions.assertEquals(BigDecimal.ZERO , actualPi);
    }

    @Test
    public void shouldReturnApproximatePiValueWithGivenPrecision() {
        //GIVEN
        double precision = 0.001;
        int decimalPlaces = 25;

        //WHEN
        BigDecimal actualPi = PiCreator.createPiNumber(precision , decimalPlaces);
        BigDecimal absDifference = PiCreator.getMath_PI().subtract(actualPi).abs();

        //THEN
        Assertions.assertTrue(absDifference.compareTo(BigDecimal.valueOf(precision)) < 0);
    }
}