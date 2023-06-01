package com.javiezcobar.domain;

import com.javiezcobar.business.InstallmentCalculatorImp;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String name;
    private String telephone;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address = new Address();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Loan> loans = new HashSet<>();
    public Client() {
    }
    public Client(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
        this.date = LocalDate.now();
    }
    public void creditLoan (double loanAmount, String paymentOption){
        Loan loan = new Loan(loanAmount, paymentOption, new InstallmentCalculatorImp(), this);
        this.loans.add(loan);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }
    public Set<Loan> getLoans() {
        return loans;
    }

    public Loan getLoanById(int loanId) {
        for (Loan loan : loans) {
            if (loan.getId() == loanId) {
                return loan;
            }
        }
        return null; // Si no se encuentra la loan con el ID especificado
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }
    @Override
    public String toString() {
        return "Cliente {" +
                "id: " + id +
                ", fecha: " + date +
                ", nombre: '" + name + '\'' +
                ", telefono: '" + telephone + '\'' +
                ", direccion: " + address +
                ", creditos: " + loans +
                '}';
    }
}
