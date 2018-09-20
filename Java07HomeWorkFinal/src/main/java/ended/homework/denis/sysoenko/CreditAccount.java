package ended.homework.denis.sysoenko;

import java.util.Random;

public class CreditAccount extends CreditInquiry {


    int Account; Double EndedSumm, TakeSumm, Returnsumm;

    public CreditAccount(String name, String sname, Double salary, Double age, Double creditRating, Double creditTerm, Double amount, int account, Double endedSumm, Double takeSumm, Double returnsumm) {
        super(name, sname, salary, age, creditRating, creditTerm, amount);
        Account = getAccount();
        EndedSumm = getAmount();
        TakeSumm = getTakeSumm();
        Returnsumm = getReturnSumm();
    }

    public int getAccount() {
        Random rnd = new Random(System.currentTimeMillis());
        int number = 100000 + rnd.nextInt(999999 - 100000 + 1);
        return number;
    }


    public Double getReturnSumm() {
        Random rnd = new Random(System.currentTimeMillis());
        int number = 10000 + rnd.nextInt(99999 - 10000 + 1);
        return Double.valueOf(number);
    }


    public Double getTakeSumm() {
        Random rnd = new Random(System.currentTimeMillis());
        int number = 10000 + rnd.nextInt(99999 - 10000 + 1);
        return Double.valueOf(number);
    }
    public Double getEndedSumm(){
        return this.amount;


    }

    public String  getCreditAccountInfo(){
         return "Номер счета: " + getAccount() +
                "\nДвижения по счету: " +
                 getReturnSumm() + getTakeSumm() + getEndedSumm();
    }

}
