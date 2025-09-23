package com.likeliom.demo.dto;

import java.time.LocalDateTime;

public class ProductDTO {
    private int id;
    private String nsme;
    private int price;
    private LocalDateTime regDate;

    public ProductDTO() {}

    public ProductDTO(String nsme, int price) {
        // id, date는 자동으로 입력되도록
        this.nsme = nsme;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNsme() {
        return nsme;
    }

    public void setNsme(String nsme) {
        this.nsme = nsme;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", nsme='" + nsme + '\'' + ", price=" + price + ", regDate=" + regDate + '}';
    }
}
