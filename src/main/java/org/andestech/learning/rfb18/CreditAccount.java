package org.andestech.learning.rfb18;

import org.andestech.learning.rfb18.ExceptionConteiner.CreditOverdraftException;
import org.andestech.learning.rfb18.ExceptionConteiner.InvalidAmountException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditAccount
{
    String accountId;
    Customer creditAccountOwner;
    private final int creditSum;
    double percent;
    double amount;
    int repaymentPeriod;
    String creditOpenDate;

    CreditAccount(Customer creditAccountOwner, int creditSum, double percent, int repaymentPeriod)
    {
        this.creditAccountOwner = creditAccountOwner;
        this.creditSum = creditSum;
        this.percent = percent;
        this.amount = 0.00;
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        creditOpenDate = dateFormat.format(new Date());
    }

    public int withdrawl(int amount) throws CreditOverdraftException, InvalidAmountException
    {
        if(Utils.checkInvalideAmount(amount))
        {
            throw new InvalidAmountException(amount);
        }
        if(creditSum < amount)
        {
            throw new CreditOverdraftException();
        }
        else if (creditSum == amount)
        {
            return 0;
        }
        return 1;
    }

    public int deposit(int amount) throws InvalidAmountException
    {
        if(Utils.checkInvalideAmount(amount))
        {
            throw new InvalidAmountException(amount);
        }
        this.amount = this.amount + amount;
        if(this.amount >= (creditSum*percent + creditSum))
        {
            return 0;
        }
        return 1;
    }



}
