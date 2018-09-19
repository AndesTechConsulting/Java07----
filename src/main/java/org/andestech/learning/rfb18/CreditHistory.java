package org.andestech.learning.rfb18;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CreditHistory {

String acc = "";
String summary = "";


    public CreditHistory(String acc, String summary) {
        this.acc = acc;
        this.summary = summary;
    }

    ArrayList<CreditHistory>logs = new ArrayList<CreditHistory>();

    public void writeLogs () throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","dbpass");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);
        //Записываем логи в БД:
        Statement st = conn.createStatement();
        String insLog = "INSERT INTO public.\"Credit_history\" (account_number, operation_description) VALUES ('"+acc+"','"+summary+"')";
        System.out.println(insLog);
        for(int i = 0; i < logs.size(); i++)
        {st.executeUpdate(insLog);}
        st.close();
        conn.close();
    }

    public void readLogs()throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","dbpass");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);
        Statement st = conn.createStatement();
        String selectLog = "SELECT account_number, operation_description FROM public.\"Credit_history\"";
        String querynum = "";
        String querydesc = "";
        //st.executeQuery(selectLog);
        ResultSet rs = st.executeQuery(selectLog);
        if (rs.next()){
            querynum = rs.getString("account_number");
            querydesc = rs.getString("operation_description");
        }
        logs.add(new CreditHistory(querynum,querydesc));
    }





}
