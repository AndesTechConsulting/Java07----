package org.andestech.learning.rfb18;

import java.util.ArrayList;
import java.io.*;
import java.util.Date;

public class CreditHistory
{
    private static ArrayList<String[]> accountHistory = new ArrayList();
    private static ArrayList<String[]> operationHistory = new ArrayList();

    public static void addInAccountHistory(String operationType, String customer, int creditAmount, int repaymentPeriod, String decision)
    {
        accountHistory.add(new String[] {operationType,
                                           customer,
                                           creditAmount + "",
                                           repaymentPeriod + "",
                                           decision});
    }
    public static void addInOperationHistory(String operationType, String customer, int operationAmount, int currBalance,
                                             int repaymentAmount, String decision)
    {
        operationHistory.add(new String[] {operationType,
                                           customer,
                                           operationAmount + "",
                                           currBalance + "",
                                           repaymentAmount + "",
                                           decision});
    }

    public static void unloadingAccountHistoryToFile()
    {
        Date date = new Date();
        FileWriter fileWriter = null;
        String fileName = "AccHst" + date.toString() + ".txt";
        File file = null;
        try
        {
            file = new File(fileName);
            fileWriter = new FileWriter(file, true);

            String temp = "";

            for(int i = 0; i < accountHistory.size(); i++ )
            {
                for(int y = 0; y < accountHistory.get(i).length; y ++)
                {
                    temp.concat(accountHistory.get(i) + "\t");
                }
                fileWriter.write(temp);
                fileWriter.write("\n");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Нет такого файла или ошибка при его создание");
        } catch (IOException e)
        {
            System.out.println("Что - то не так с выводом ...");
        }
    }

    public static void unloadingOperationHistoryToFile()
    {
        Date date = new Date();
        FileWriter fileWriter = null;
        String fileName = "OperHst" + date.toString() + ".txt";
        File file = null;
        try
        {
            file = new File(fileName);
            fileWriter = new FileWriter(file, true);

            String temp = "";

            for(int i = 0; i < operationHistory.size(); i++ )
            {
                for(int y = 0; y < operationHistory.get(i).length; y ++)
                {
                    temp.concat(operationHistory.get(i) + "\t");
                }
                fileWriter.write(temp);
                fileWriter.write("\n");
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Нет такого файла или ошибка при его создание");
        } catch (IOException e)
        {
            System.out.println("Что - то не так с выводом ...");
        }
    }

    public static void loadingAccountHistoryFromFile(String fileName)
    {
        FileReader fileReader = null;
        File file = null;
        try
        {
            file = new File(fileName);
            fileReader = new FileReader(file);

        } catch (FileNotFoundException e)
        {
            System.out.println("Нет такого файла или ошибка при его чтение");
        } catch (IOException e)
        {
            System.out.println("Что - то не так с выводом ...");
        }
    }

    public static void loadingOperationHistoryFromFile(String fileName)
    {
        FileReader fileReader = null;
        File file = null;
        try
        {
            file = new File(fileName);
            fileReader = new FileReader(file);

        } catch (FileNotFoundException e)
        {
            System.out.println("Нет такого файла или ошибка при его чтение");
        } catch (IOException e)
        {
            System.out.println("Что - то не так с выводом ...");
        }
    }


}
