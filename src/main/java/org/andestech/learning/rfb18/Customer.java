package org.andestech.learning.rfb18;

public class Customer {

    private int id;
    private String name;
    private String sname;
    private double salary;
    private int age;
    private String creditRating;


    //временное решение
    public Customer(String name, String sname, double salary, int age){
        this.id = 1;
        this.name = name;
        this.sname = sname;
        this.salary = salary;
        this.age = age;
    }


    public void getFromDB(){

    }

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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating() {
        if(age >= 25 && age <45
        && salary > 100_000.00){
            this.creditRating = "EXCELLENT";
        }
        else if(age >= 21 && age <= 50
        && salary >=25_000){
            this.creditRating = "GOOD";
        }
        else if(age < 21 || age > 50
        || salary <= 25_000){
            this.creditRating = "BAD";
        }
        else {
            System.out.println("не возможно определить кредитный рейтинг");
        }

    }
}
