package org.andestech.learning.rfb18;

import org.junit.Test;

import org.junit.Assert;

public class CreditInquiryTest
{
    @Test
    public void Test01()
    {
        CreditInquiry crdInq01 = new CreditInquiry();
        Customer cust01 = new Customer("000",
                                    "Boris",
                                   "Blade",
                                    300,
                                      30,
                                5);

        String checkResult = crdInq01.checkCustomerCreditChance(cust01, 1_000_000, 24);
        Assert.assertEquals("Denied", checkResult);
    }

    @Test
    public void Test02()
    {
        CreditInquiry crdInq01 = new CreditInquiry();
        Customer cust01 = new Customer("000",
                "Boris",
                "Blade",
                700000,
                30,
                5);

        String checkResult = crdInq01.checkCustomerCreditChance(cust01, 1_000_000, 24);
        Assert.assertEquals("Approved", checkResult);
    }

    @Test
    public void Test03()
    {
        CreditInquiry crdInq01 = new CreditInquiry();
        Customer cust01 = new Customer("000",
                "Boris",
                "Blade",
                100000,
                30,
                5);

        boolean checkResult = crdInq01.createCreditAccount(cust01, 1_000_000, 12);
        Assert.assertTrue(checkResult);
    }

}
