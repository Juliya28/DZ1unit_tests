package org.example;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
public class CalculatorTest {
    public static void main(String[] args) {

        assertThatThrownBy(()->Calculator
                .calculatingDiscount(-5000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");

        assertThatThrownBy(()->Calculator
                .calculatingDiscount(5000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0% до 100%");

        assertThatThrownBy(()->Calculator
                .calculatingDiscount(5000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0% до 100%");

        assertThatThrownBy(() ->Calculator
                .calculatingDiscount(500, 0.15))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Cкидка не может быть указана не целым числом");

        //Метод должен возвращать правильный результат 5000 - 5000(25%/100) = 3750

        assertThat(Calculator.calculatingDiscount(5000, 25)).isEqualTo(3750);
        assertThat(Calculator.calculatingDiscount(5000, 100)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(5000, 0)).isEqualTo(5000);
    }
}
