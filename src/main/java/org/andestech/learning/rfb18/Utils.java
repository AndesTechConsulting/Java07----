package org.andestech.learning.rfb18;

public class Utils
{
    public static boolean checkInvalideAmount(int amount)
    {
        if(amount <= 0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
