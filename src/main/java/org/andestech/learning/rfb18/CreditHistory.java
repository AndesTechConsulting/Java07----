package org.andestech.learning.rfb18;

import com.mysql.jdbc.Driver;

import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class CreditHistory
{

    private static ArrayList<String[]> accountHistory = new ArrayList();
    private static ArrayList<String[]> operationHistory = new ArrayList();

    //-------------------------------------------------------------------------------------
    private static final String dbUrl = "jdbc:mysql://192.168.1.9:3306/test";
    private static final String user = "root";
    private static final String password = "2003Alisa";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    //--------------------------------------------------------------------------------------

    public static void addInAccountHistory(String operationType, String customer, int creditAmount, int repaymentPeriod, String decision)
    {
        Date date = new Date();
        accountHistory.add(new String[] {  date.toString(),
                                           operationType,
                                           customer,
                                           creditAmount + "",
                                           repaymentPeriod + "",
                                           decision});
    }
    public static void addInOperationHistory(String operationType, String customer, int operationAmount, int currBalance,
                                             int repaymentAmount, String decision)
    {
        Date date = new Date();
        operationHistory.add(new String[] {date.toString(),
                                           operationType,
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

    public static void loadingHistoryFromFile(String fileName, ArrayList<String[]> historyList)
    {
        FileInputStream fstream = null;
        BufferedReader br = null;
        try
        {
            fstream = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fstream));

            String temp;
            String[] tempArr;
            ArrayList<String> tempArrList = new ArrayList();

            while((temp = br.readLine()) != null)
            {
                    tempArrList.add(temp);

            }

            for(int i = 0; i < tempArrList.size();  i++)
            {
                historyList.add(tempArrList.get(i).split("\t"));
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Нет такого файла или ошибка при его чтение");
        } catch (IOException e)
        {
            System.out.println("Что - то не так с выводом ...");
        }
    }


    public static void unloadingAccountHistoryToDB() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");

        try{
           con = DriverManager,getConnection(dbUrl, user, password);
           stmt = con.createStatement();
           for(int i = 0; i < accountHistory.size(); i++) {
               rs = stmt.executeQuery(
                       "insert into 'account_history' ('DateTime', 'Operation_Type', 'Customer', 'Credit_Amount', 'Repayment_Period', 'Decision' )" +
                               "values ('" + accountHistory.get(i)[0] + "', '"+  accountHistory.get(i)[1]
                                           + "', '"+  accountHistory.get(i)[2] + "', '"+  accountHistory.get(i)[3]
                                           + "', '"+  accountHistory.get(i)[4] + "', '"+  accountHistory.get(i)[5] +"')"
               );
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try { con.close(); } catch(SQLException e) {System.out.println("Error: Cann't close connection");}
            try { stmt.close(); } catch(SQLException e) {System.out.println("Error: Cann't close Statement");}
            try { rs.close(); } catch(SQLException e) {System.out.println("Error: Cann't close Result");}
        }

    }

    public static void unloadingOperationHistoryToDB() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");

        try{
            con = DriverManager,getConnection(dbUrl, user, password);
            stmt = con.createStatement();
            for(int i = 0; i < operationHistory.size(); i++) {
                rs = stmt.executeQuery(
                        "insert into 'account_history' ('DateTime','Operation_Type', 'Customer', 'Operation_Amount', 'Current_Balance', 'Repayment_Amount', 'Decision' )" +
                                "values ('" + operationHistory.get(i)[0] + "', '"+  operationHistory.get(i)[1]
                                + "', '"+  operationHistory.get(i)[2] + "', '"+  operationHistory.get(i)[3]
                                + "', '"+  operationHistory.get(i)[4] + "', '"+  accountHistory.get(i)[5] + "', '"+  accountHistory.get(i)[6] + "')"
                );
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try { con.close(); } catch(SQLException e) {System.out.println("Error: Cann't close connection");}
            try { stmt.close(); } catch(SQLException e) {System.out.println("Error: Cann't close Statement");}
            try { rs.close(); } catch(SQLException e) {System.out.println("Error: Cann't close Result");}
        }

    }

    public static void cleanHistory(ArrayList<String[]> a)
    {
        a.clear();
    }

}
