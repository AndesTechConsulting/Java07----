package org.andestech.learning.rfb18;

import org.andestech.learning.rfb18.ExceptionConteiner.CreditOverdraftException;
import org.andestech.learning.rfb18.ExceptionConteiner.InvalidAmountException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditAccount
{
    private String accountId;
    private Customer creditAccountOwner;
    private final int creditAmount;
    private double percent;
    private double withdrawalAmount;
    private double depositAmount;
    private int repaymentPeriod;
    private String creditOpenDate;

//-------------------------------------------------------------------------------------------------------

    CreditAccount(Customer creditAccountOwner, int creditAmount, double percent, int repaymentPeriod)
    {
        CreditHistory.addInAccountHistory("Open credit account", creditAccountOwner.getSname() + " " + creditAccountOwner.getName(),
                                    creditAmount, repaymentPeriod, "Successfully");
        this.creditAccountOwner = creditAccountOwner;
        this.creditAmount = creditAmount;
        this.percent = percent;
        this.withdrawalAmount = creditAmount;
        this.depositAmount = 0.00;
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        creditOpenDate = dateFormat.format(new Date());
    }

//-------------------------------------------------------------------------------------------------------

    public int withdrawl(int amount) throws CreditOverdraftException, InvalidAmountException
    {
        if(Utils.checkInvalideAmount(amount))
        {
            throw new InvalidAmountException(amount);
        }
        if(withdrawalAmount < amount)
        {
            throw new CreditOverdraftException();
        }
        else if (withdrawalAmount == amount)
        {
            withdrawalAmount = withdrawalAmount - amount;
            CreditHistory.addInAccountHistory("Closing of a loan", creditAccountOwner.getSname() + " " + creditAccountOwner.getName(),
                    creditAmount, repaymentPeriod, "Successfully");
            return 0;
        }
            CreditHistory.addInOperationHistory("Withdrawl funds", creditAccountOwner.getSname() + " "
                        + creditAccountOwner.getName(), amount, (int) withdrawalAmount, (int)depositAmount, "Successfully");
        return 1;
    }

    public int deposit(int amount) throws InvalidAmountException
    {
        if(Utils.checkInvalideAmount(amount))
        {
            throw new InvalidAmountException(amount);
        }
        depositAmount = depositAmount + amount;
        if(depositAmount >= (creditAmount*percent + creditAmount))
        {
            CreditHistory.addInAccountHistory("Closing credit account", creditAccountOwner.getSname() + " " + creditAccountOwner.getName(),
                    creditAmount, repaymentPeriod, "Successfully");
            return 0;
        }
        CreditHistory.addInOperationHistory("Dipositing funds", creditAccountOwner.getSname() + " "
                + creditAccountOwner.getName(), amount, (int) depositAmount, (int)withdrawalAmount, "Successfully");
        return 1;
    }

}
