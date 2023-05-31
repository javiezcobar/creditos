package com.javiezcobar.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private boolean isIncome;
    private String description;

    public Transaction() {
    }

    public Transaction(LocalDate date, double amount, boolean isIncome, String description) {
        this.date = date;
        this.amount = amount;
        this.isIncome = isIncome;
        this.description = description;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaccion {" +
                "id: " + id +
                ", fecha: " + date +
                ", total: " + amount +
                ", es ingreso: " + isIncome +
                ", descripcion: '" + description + '\'' +
                '}';
    }
}
