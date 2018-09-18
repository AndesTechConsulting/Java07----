package org.andestech.learning.rfb18;


import java.util.Scanner;

/**
 * TODO:
 *
 * Java07-Course-materials
 * Итоговое задание. Срок выполнения - к 17.09.18.
 *
 * Вашему подразделению поручено разработать программный стек для обработки заявок по кредитам и
 * сопровождению выданных кредитов. Архитектор проекта предложил следующий шаблон для выполнения задачи:
 *
 * Заявители должы описываться классом Customer, в котором должны быть следующие поля (как минимум):
 * id, name, sname, salary, age, creditRating.
 *
 * Заявки на кредит должны сопровождаться и обрабатываться классом CreditInquiry.
 *
 * На основе данных клиента - salary, age, creditRating, а также суммы запрашиваемого кредита и срока погашения,
 * принимается решение.
 * При отклонении заявки на кредит должно генерироваться исключение CreditInquiryException.
 *
 * Для получивших кредит заявителей должен создаваться экземпляр класса CreditAccount,
 * который должен описывать все данные кредита и операции по нему.
 * Если Вы не знаете, как написать реализацию какого-либо метода, сделайте класс абстрактным.
 *
 * Добавьте стек исключений, обслуживающий операции по кредитам.
 * Например, при превышении лимита по кредиту, должно генерироваться исключение CreditOverdraftException.
 *
 * Вся история операций по выданным кредитам и заявкам на кредит должна
 * обслуживаться в типе CreditHistory. Этот класс должен уметь сохранять историю во внутренней коллекции,
 * выгружать историю на диск или БД, загружать историю с диска или БД обратно в коллекцию.
 * При необходимости, генерировать исключения.
 *
 * Установите проект в локальный репозиторий maven.
 * Протестируйте проект на основе отдельного приложения (нового проекта maven).
 *
 *
 *
 */

public class App 
{
    public static void main( String[] args )
    {

        String name;
        String sname;
        double salary;
        int age;

        double amount_of_credit;
        int maturity;//monht
        double rate;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добрый день!");
        System.out.println("Вам предлагается заполнить данные для получения кредита");
        System.out.println("Введите ваше имя: ");
        name = scanner.nextLine();
        System.out.println("Введите вашу фамилию: ");
        sname = scanner.nextLine();
        System.out.println("Введите ваш возраст: ");
        age = scanner.nextInt();
        System.out.println("Введите вашу заработную плату: ");
        salary = scanner.nextDouble();

        Customer customer = new Customer(name,sname,salary,age);
        customer.setCreditRating();
        //System.out.println("Ваш кредитный рейтинг: " + customer.getCreditRating());

        System.out.println("Введите желаемую сумму кредита: ");
        amount_of_credit = scanner.nextDouble();
        System.out.println("Введите срок кредита в месяцах: ");
        maturity = scanner.nextInt();
        System.out.println("Введите процентную ставку от 8 до 15 процентов в виде 0,хх :");
        rate = scanner.nextDouble();



        CreditInquiry creditInquiry = new CreditInquiry(customer.getId(),amount_of_credit,maturity,rate,customer.getCreditRating());
        System.out.println("Заявка на кредит отправлена");
        creditInquiry.decisionCreditInqury();
        creditInquiry.checkStatus();


    }
}
