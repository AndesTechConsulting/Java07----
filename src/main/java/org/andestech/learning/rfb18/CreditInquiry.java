package org.andestech.learning.rfb18;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

public class CreditInquiry  {
    public CreditAccount calcCreditInquiry( Customer customer ) throws CrediException {
     if (customer.getSalary()>5 && customer.getAge()>18 && customer.getCreditRating() == 2 && customer.getSum() < 1000
             && customer.getExpDate().compareTo(Date.valueOf("10.10.2020")) < 0)  {
         CreditAccount creditAccount = new CreditAccount();
         try {
             addToHistory(creditAccount);
         } catch (IOException e) {
             e.printStackTrace();
         }
         return creditAccount;
     }
    else {throw new CrediException("Заявка на кредит отклонена!");}
    }

    public void addToHistory(CreditAccount creditInquiry) throws IOException {
        FileWriter fr = new FileWriter(CreditHistory.f);
        fr.write(String.valueOf(creditInquiry));
}

}
