package org.andestech.learning.rfb18;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Customer customer = new Customer(123, "Виталий", "Блажчук", 10000, 25, 50);
        CreditInquiry creditInquiry = new CreditInquiry(customer, 4000);
        if (creditInquiry.checkCustomer()) {
            CreditAccount creditAccount = new CreditAccount(creditInquiry.sum, creditInquiry.countercredpersen, creditInquiry.everymonthpersen, creditInquiry.account);
            creditAccount.addHistory("Вам одобрен кредит на сумму: " + creditAccount.sumCred);

            System.out.println("Вся история: ");
            for (String str : creditAccount.getAllHistory()) {
                System.out.println(str);
            }
        }

    }
}
