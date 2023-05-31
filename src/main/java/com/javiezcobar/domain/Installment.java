package com.javiezcobar.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@DiscriminatorValue("installment")
public class Installment extends Transaction {
    private int number;
    private double amountPaid;
    private boolean isPaidInCash;
    private boolean isPaid;
    private String bankName;
    private LocalDate payDate;
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    public Installment() {
    }

    public Installment(int number, double amount, LocalDate date) {
        this.number = number;
        this.setAmount(amount);
        this.setDate(date);
        this.amountPaid = 0;
        this.isPaidInCash = false;
        this.isPaid = false;
        this.bankName = null;
    }

    public void payInstallment(double amountPaid, boolean isPaidInCash, String bankName) {
        this.amountPaid += amountPaid;
        this.isPaid = true;
        this.isPaidInCash = isPaidInCash;
        this.bankName = bankName;
        this.payDate = LocalDate.now();
    }

    // Getters and Setters

    public int getNumber() {
        return number;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public boolean isPaidInCash() {
        return isPaidInCash;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getBankName() {
        return bankName;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setPaidInCash(boolean paidInCash) {
        isPaidInCash = paidInCash;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Cuotas {" +
                "id: " + getId() +
                ", numero cuota: " + number +
                ", fecha: " + getDate() +
                ", total: " + getAmount() +
                ", total pagado: " + amountPaid +
                ", pago en efectivo: " + isPaidInCash +
                ", pagado en total: " + isPaid +
                ", banco: '" + bankName + '\'' +
                '}';
    }
}

