package ended.homework.denis.sysoenko;

public class CreditInquiry extends Customer {

    Double Profit, Percent =9.0, LimitZp = 50.0, TotalSumm, MonthLimit, MonthReturn, RetrimentAge, CreditRetrimentAge;

    public CreditInquiry(String name, String sname, Double salary, Double age, Double creditRating, Double creditTerm, Double amount) {
        super(name, sname, salary, age, creditRating, creditTerm, amount);
        this.Profit = getProfit();
        this.TotalSumm=getTotalSumm();
        this.MonthLimit=getMonthLimit();
        this.MonthReturn=getMonthReturn();
        this.RetrimentAge=getRetrimentAge();
        this.CreditRetrimentAge=getCreditRetrimentAge();
    }


    public String getResult() throws CreditInquiryException {
        String s;
       try {
           if(getCreditRating()<0)
               throw new CreditInquiryException("Отрицательный рейтинг!");
           else
               {
                   if (getCreditRetrimentAge()>RetrimentAge)
                       throw  new RetrimentAgeException("Срок погащения кредита превышает трудоспособный возраст");
                   else
                   {
                       if(getMonthReturn()>getMonthLimit())
                           throw new CreditOverdraftException("Сумма ежемесячных платежей по кредиту превышает сумму доступную заявителю");
                       else {
                           s = "Выдача кредита одобрена!";
                           System.out.println(CreditAccount.getCreditAccountInfo());{
                           }
                       }
                   }

           }
       }catch (CreditInquiryException e)
       {
             e.getStackTrace();
            s = "Отказано в выдачи кредита. Причина: Отрицательная кредитная история!";
       }
       catch (RetrimentAgeException e)
       {
           e.getStackTrace();
           s = "Отказано в выдачи кредита. Причина: Срок займа превышает трудоспособный возвраст заявителя!";
       }
       catch (CreditOverdraftException e)
       {
           e.getStackTrace();
           s = "Отказано в выдачи кредита. Причина: Ежемесячный платеж по кредиту больше суммы доступной к удержанию с заработной платы заявителя";
       }
        return s;
    }




    public Double getProfit() {
        return getAmount()/100*Percent;
    }

    public Double getTotalSumm() {
        return getAmount()+Profit;
    }

    public Double getMonthLimit() {
        return getSalary()/100*LimitZp;
    }

    public Double getMonthReturn() {
        return TotalSumm/getCreditTerm();
    }

    public Double getRetrimentAge() {
        return 65.0*12.0;
    }

    public Double getCreditRetrimentAge() {
        return getAge()*12+getCreditTerm();
    }
}


