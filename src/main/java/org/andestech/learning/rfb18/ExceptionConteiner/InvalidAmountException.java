package org.andestech.learning.rfb18.ExceptionConteiner;

public class InvalidAmountException extends Exception
{
    public InvalidAmountException(int invalidAmount)
    {
        System.out.println("Попытка указания невалидного значения суммы: " + invalidAmount);
    }
}
