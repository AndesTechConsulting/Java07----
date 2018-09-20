package ended.homework.denis.sysoenko;

import java.util.Random;
import java.util.UUID;

public class Customer {

    String name;
    String sname;
    int id;
    Double salary,age,creditRating, creditTerm, amount;

    public Customer(String name, String sname, Double salary, Double age, Double creditRating, Double creditTerm, Double amount) {
        this.name = name;
        this.sname = sname;
        this.id = getId();
        this.salary = salary;
        this.age = age;
        this.creditRating = creditRating;
        this.creditTerm = creditTerm;
        this.amount = amount;
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

    public int getId() {
        Random rnd = new Random(System.currentTimeMillis());
        int number = 10000000 + rnd.nextInt(99999999 - 10000000 + 1);
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Double creditRating) {
        this.creditRating = creditRating;
    }

    public Double getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Double creditTerm) {
        this.creditTerm = creditTerm;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getInfo(){
        return  "Присвоен номер: " + getId()+
                "\nИмя: " + getName()+
                "\nФамилия: " + getSname()+
                "\nВозраст: " + getAge() +
                "\nЗарплата: " + getSalary()+
                "\nСрок займа :" + getCreditTerm()+
                "\nСумма займа: " + getAmount()+
                "\nКредитный рейтинг: " + getCreditRating();
    }
}
