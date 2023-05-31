package com.javiezcobar.domain;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street, number, nextTo, location, cp;
    @OneToOne(mappedBy = "address")
    private Client client;
    public Address() {
    }

    public void setAddress(String st, String number, String nextTo, String city, String cp){
        this.street = st;
        this.number = number;
        this.nextTo = nextTo;
        this.location = city;
        this.cp = cp;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNextTo() {
        return nextTo;
    }

    public void setNextTo(String nextTo) {
        this.nextTo = nextTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion {" +
                "id: " + id +
                ", calle: '" + street + '\'' +
                ", numero: '" + number + '\'' +
                ", entre calles: '" + nextTo + '\'' +
                ", barrio: '" + location + '\'' +
                ", codigo postal: '" + cp + '\'' +
                '}';
    }
}
