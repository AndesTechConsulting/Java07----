package org.andestech.learning.rfb18;

public class Customer
{
    private String id, name, sname;
    private int salary, age, creditRating;

    public Customer(String id, String name, String sname, int salary, int age, int creditRating )
    {
        this.id = id;
        this.name = name;
        this.sname = sname;
        this.salary = salary;
        this.age = age;
        this.creditRating = creditRating;
    }
//---------------------------------------
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSname() { return sname; }
    public int getSalary()
    {
        return salary;
    }
    public int getAge()
    {
        return age;
    }
    public int getCreditRating()
    {
        return creditRating;
    }
//---------------------------------------
    void setName(String name)
    {
        this.name = name;
    }
    void setSname(String sname)
    {
        this.sname = sname;
    }
    void setSalary(int salary)
    {
        this.salary = salary;
    }
    void setAge(int creditRating)
    {
        this.age = age;
    }
    void setCreditRating(int creditRating)
    {
        this.creditRating = creditRating;
    }
//---------------------------------------

}
