package org.andestech.learning.rfb18;

public class CreditAccount
{
    Customer creditAccountOwner;
    private final float creditSum;
    float percent;
    float amount;

    CreditAccount(Customer creditAccountOwner, float creditSum, float percent)
    {
        this.creditAccountOwner = creditAccountOwner;
        this.creditSum = creditSum;
        this.percent = percent;
        this.amount = 0.00f;
    }

}
