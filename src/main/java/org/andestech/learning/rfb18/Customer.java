package org.andestech.learning.rfb18;

/**
 * Created by Евгений on 28.08.2018.
 */
public class Customer {

    private int id;
    private String name;
    private String sname;
    private int salary;
    private int age;
    private int creditRating;

   Customer(int id, String name, String sname, int salary, int age, int creditRating) {
        this.id = id;
        this.name = name;
        this.sname = sname;
        this.salary = salary;
        this.age = age;
        this.creditRating = creditRating;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}
