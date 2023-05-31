package com.javiezcobar.domain;

import com.javiezcobar.business.InstallmentCalculator;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private double interestRate;
    private double installmentAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan")
    private Installment[] installments;
    @Transient
    private InstallmentCalculator calculator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Loan() {
    }

    public Loan(double loanAmount, String paymentOption, InstallmentCalculator calc, Client client) {
        this.amount = loanAmount;
        this.calculator = calc;
        this.interestRate = calculator.calculateInterestRate(paymentOption);
        this.installmentAmount = calculator.calculateInstallmentAmount(paymentOption, loanAmount, interestRate);
        this.installments = calculator.generateInstallments(paymentOption, installmentAmount);
        this.client = client;

        // Asignar el préstamo a las cuotas
        for (Installment installment : installments) {
            installment.setLoan(this);
        }
    }

    // Getters para acceder a los atributos

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public Installment[] getInstallments() {
        return installments;
    }

    public Installment getInstallment(int installmentNumber){
        return installments[installmentNumber - 1];
        //TODO error handler
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public void setInstallments(Installment[] installments) {
        this.installments = installments;
    }

    public void setCalculator(InstallmentCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String toString() {
        return "Credito {" +
                "id: " + id +
                ", cliente: " + client +
                ", total: " + amount +
                ", tasa de interes: " + interestRate +
                ", valor de cuotas: " + installmentAmount +
                '}';
    }
}

