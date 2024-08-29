package com.model;

import java.time.LocalDate;

public class Product {

    private int id;
    private String name;
    private int price;
    private String company;
    private LocalDate  mdfDate;
    private LocalDate expDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getMdfDate() {
        return mdfDate;
    }

    public void setMdfDate(LocalDate mdfDate) {
        this.mdfDate = mdfDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", company=" + company +
                ", mdfDate=" + mdfDate +
                ", expDate=" + expDate +
                '}';
    }
}
