package org.andestech.learning.rfb18.ExceptionConteiner;

public class CreditOverdraftException extends Exception {
    public CreditOverdraftException()
    {
        System.out.println("Попытка снятия со счета суммы, превыщающей остаток на счете!");
        System.out.println("Измените сумму и повторить попытку");
    }
}
