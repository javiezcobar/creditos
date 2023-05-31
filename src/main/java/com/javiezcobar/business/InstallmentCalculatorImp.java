package com.javiezcobar.business;

import com.javiezcobar.domain.Installment;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class InstallmentCalculatorImp implements InstallmentCalculator {

    public double calculateInstallmentAmount(String paymentOption, double amount, double interestRate) {
        return (amount * (1 + interestRate)) / calculateNumberOfInstallments(paymentOption);
    }

    public double calculateInterestRate(String paymentOption) {
        return switch (paymentOption) {
            case "D10" -> 0.10;
            case "D20" -> 0.20;
            case "D" -> 0.30;
            case "S" -> 0.40;
            default -> 0.30; // Valor por defecto para la opción "Diario"
        };
    }


    public Installment[] generateInstallments(String paymentOption, double installmentAmount) {
        int numberOfInstallments = calculateNumberOfInstallments(paymentOption);
        LocalDate currentDate = LocalDate.now();
        Installment[] installmentArray = new Installment[numberOfInstallments];

        for (int i = 0; i < numberOfInstallments; i++) {
            if (paymentOption.equals("S")) {
                currentDate = currentDate.plusWeeks(1); // Pago semanal cada 7 días
                while (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    currentDate = currentDate.plusDays(1); // Salta el domingo
                }
            } else {
                currentDate = currentDate.plusDays(1); // Pago diario, excepto los domingos
                while (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    currentDate = currentDate.plusDays(1); // Salta el domingo
                }
            }

            Installment installment = new Installment(i + 1, installmentAmount, currentDate);
            installmentArray[i] = installment;
        }

        return installmentArray;
    }


    public int calculateNumberOfInstallments(String paymentOption) {
        return switch (paymentOption) {
            case "D10" -> 10;
            case "D20" -> 20;
            case "D" -> 26;
            case "S" -> 5;
            default -> 26; // Valor por defecto para la opción "Diario"
        };
    }
}
