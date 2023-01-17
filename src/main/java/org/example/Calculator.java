package org.example;

public class Calculator {
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0;

        if (purchaseAmount >= 0) {
            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            }
            else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0% до 100%");
            }
        }
        else {
            throw new ArithmeticException("Сумма покупки не должна быть отрицательной!!!");
        }
        return discountedAmount;
    }
}
