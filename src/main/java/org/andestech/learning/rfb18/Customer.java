package org.andestech.learning.rfb18;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private String sname;
    private int salary;
    private int age;
    private int creditRating;
    private int sum;
    private Date expDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getSum() {
        return sum;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSname() {
        return sname;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getCreditRating() {
        return creditRating;
    }
}


