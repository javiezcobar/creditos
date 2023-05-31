package com.javiezcobar.business;

import com.javiezcobar.domain.Installment;
import com.javiezcobar.domain.Loan;

public class PaymentService {
    public void distributePayment(Loan loan, double paymentAmount, boolean isPaidInCash, String bankName) {
        Installment[] installments = loan.getInstallments();

        for (Installment installment : installments) {
            if (!installment.isPaid()) {
                double remainingAmount = installment.getAmount() - installment.getAmountPaid();
                double installmentPayment = Math.min(paymentAmount, remainingAmount);
                installment.payInstallment(installmentPayment, isPaidInCash, bankName);
                paymentAmount -= installmentPayment;
                if (paymentAmount <= 0) {
                    break;
                }
            }
        }
    }

    // Sobrecarga del método para el caso donde el pago se realiza en efectivo
    public void distributePayment(Loan loan, double paymentAmount) {
        distributePayment(loan, paymentAmount, true, null);
    }

    public boolean isInstallmentFullyPaid(Installment installment) {
        return installment.getAmountPaid() >= installment.getAmount();
    }
}