package org.ping.lianghua;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.security.SecureRandom;

/**
 * Created by ping on 19/8/29.
 */
public class ResultFactory {
    public static Result GetResult(int n) throws NoSuchAlgorithmException {
        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
        ArrayList<Integer> l = new ArrayList();
        for(int i=0; i<n; i++) {
            l.add(rand.nextInt(10) + 1);
        }
        float fenmu =0;
        float fenzi =0;
        Iterator iter = l.iterator();
        while(iter.hasNext()){
            Integer j= (Integer) iter.next();
            float i = (float) 1/j;
            fenmu=fenmu+i;
            fenzi=fenzi+j;
        }
        return new Result(n,fenzi/n,n/fenmu);

    }
    public static void main(String[] args) {
            try {
                FileWriter writer = new FileWriter("/Users/ping/lianghua1.csv", true);
                writer.write("Number of fixed casts,"+"Position unit price,"+"Trading mode"+"\n");
                for(int i=1; i<500; i++) {
                    Result r= null;
                    try {
                        r = ResultFactory.GetResult(i);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    writer.write(r.getCishu()+","+r.getDingLiangPrice()+",Quantitative Trading"+"\n");
                    writer.write(r.getCishu()+","+r.getDingEprice()+",Fixed Trading"+"\n");
                }
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }



    }
}
