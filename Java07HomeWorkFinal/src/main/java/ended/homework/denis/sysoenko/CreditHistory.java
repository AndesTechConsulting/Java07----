package ended.homework.denis.sysoenko;

import java.io.*;
import java.util.ArrayList;

public class CreditHistory extends CreditAccount{

    public CreditHistory(Double endedSumm, Double takeSumm, Double returnsumm) {
        super(endedSumm, takeSumm, returnsumm);
    }

    public void writeHistoryCredit(){

        String text = getCreditAccountInfo();

    try(FileOutputStream fos=new FileOutputStream("C://historyCredit.txt"))
    {
        byte[] buffer = text.getBytes();
        fos.write(buffer, 0, buffer.length);
    }
    catch(IOException ex){

        System.out.println(ex.getMessage());
    }
        System.out.println("The file has been written");
    }
}


