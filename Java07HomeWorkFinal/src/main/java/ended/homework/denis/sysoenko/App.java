package ended.homework.denis.sysoenko;

import java.sql.SQLOutput;
import java.io.*;

public class App 
{
    public static void main( String[] args ) throws CreditInquiryException {
        Customer a1 = new CreditInquiry("Vasya", "Pupkin", 30000.00, 43.0, 1.0, 36.0, 300000.0) {
        };
        System.out.println(a1.getInfo());
        System.out.println("++++++++++++++Test Processing++++++++++++++");
        System.out.println(((CreditInquiry) a1).getProfit() + " - проценты банка с кредита");
        System.out.println(((CreditInquiry) a1).getTotalSumm() + " - сумма возврата банку");
        System.out.println(((CreditInquiry) a1).getMonthLimit() + " - доступный процент зп для погашения кредита");
        System.out.println(((CreditInquiry) a1).getMonthReturn() + " - месячный платеж по кредиту");
        System.out.println(((CreditInquiry) a1).getRetrimentAge() + " месяцев - трудоспособный возраст");
        System.out.println(((CreditInquiry) a1).getCreditRetrimentAge() + " месяцев - возраст заемщика плюс срок погашения");
        System.out.println(((CreditInquiry) a1).getResult());
        System.out.println(a1);

    }

}
