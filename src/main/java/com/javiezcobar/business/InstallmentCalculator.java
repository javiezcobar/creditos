package com.javiezcobar.business;

import com.javiezcobar.domain.Installment;

public interface InstallmentCalculator {

        double calculateInstallmentAmount(String paymentOption, double amount, double interestRate);
        double calculateInterestRate(String paymentOption);
        Installment[] generateInstallments(String paymentOption, double installmentAmount);
        int calculateNumberOfInstallments(String paymentOption);


}
