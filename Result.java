package org.ping.lianghua;
import java.text.DecimalFormat;

/**
 * Created by ping on 19/8/29.
 */
public class Result {
    private Integer cishu;
    private float dingLiangPrice;
    private float dingEprice;

    public Result(Integer cishu, float dingLiangPrice, float dingEprice) {
        this.cishu = cishu;
        this.dingLiangPrice = dingLiangPrice;
        this.dingEprice = dingEprice;
    }

    public Integer getCishu() {
        return cishu;
    }

    public int getDingLiangPrice() {
        return Math.round(dingLiangPrice*100);
    }

    public int getDingEprice() {
        return Math.round(dingEprice*100);
    }
}
