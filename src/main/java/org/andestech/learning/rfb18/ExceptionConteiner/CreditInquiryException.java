package org.andestech.learning.rfb18.ExceptionConteiner;

public class CreditInquiryException extends Exception
{
    public CreditInquiryException()
    {
        System.out.println("Не возможна выдача кредита - несоответствие заявителя требованиям банка!");
    }
}
