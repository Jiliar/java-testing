package co.com.jsolutions.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void total_zero_when_there_are_prices() {
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(), is(25.7));
    }

    @Test
    public void apply_discount_to_price_50() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(12.5);
        calculator.addPrice(17.5);
        calculator.setDiscount(50);
        assertThat(calculator.getTotal(), is(15.0));
    }

    @Test
    public void apply_discount_to_price_25() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.setDiscount(25);
        assertThat(calculator.getTotal(), is(150.0));
    }
}