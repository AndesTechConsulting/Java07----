package org.andestech.learning.rfb18;

import java.util.ArrayList;
import java.util.List;

public class CreditAccount {
    double sumCred;
    double persent;
    double everymonthpay;
    String creditAcc;
    CreditHistory credHis = new CreditHistory();

    public CreditAccount(double sumCred, double persent, double everymonthpay,String creditAcc) {
        this.sumCred = sumCred;
        this.persent = persent;
        this.everymonthpay = everymonthpay;
        this.creditAcc=creditAcc;
    }

    public void addHistory(String oper) {
        CreditHistory.history.add(oper);
    }

    public List<String> getAllHistory() {
        return CreditHistory.history;
    }



}
