package com.sourabh.demo.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "customers")
@ApiModel(description = "Details about the Customer.")
public class Customer {

    @Transient
    public static final String SEQUENCE_NAME = "customers_sequence";
    @Id
    private int cid;
    private String name;
    private String type;
    private int days;
    private float totalFair;
    private boolean fullPay;
    private String paymentMethod;
    private LocalDateTime bookDate;
    private boolean status;
    public Customer(){}

    public Customer(int cid, String name, String type, int days, float totalFair, boolean fullPay, String paymentMethod, LocalDateTime bookDate, boolean status) {
        this.cid = cid;
        this.name = name;
        this.type = type;
        this.days = days;
        this.totalFair = totalFair;
        this.fullPay = fullPay;
        this.paymentMethod = paymentMethod;
        this.bookDate = bookDate;
        this.status = status;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getTotalFair() {
        return totalFair;
    }

    public void setTotalFair(float totalFair) {
        this.totalFair = totalFair;
    }

    public boolean isFullPay() {
        return fullPay;
    }

    public void setFullPay(boolean fullPay) {
        this.fullPay = fullPay;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", days=" + days +
                ", totalFair=" + totalFair +
                ", fullPay=" + fullPay +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", bookDate=" + bookDate +
                ", status=" + status +
                '}';
    }
}
