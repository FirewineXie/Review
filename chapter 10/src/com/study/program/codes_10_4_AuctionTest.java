package com.study.program;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-28-17:16
 */
public class codes_10_4_AuctionTest {

    private double initPrice = 30.0;

    //因为这个方法显示抛出了AuctionException 异常
    //所以此处需要声明抛出AuctionException

    public void bid(String bidPrice)throws AuctionException{
        double d = 0.0;
        try{
            d = Double.parseDouble(bidPrice);
        }catch (Exception e){
            e.printStackTrace();

            //再次抛出异常
            throw new AuctionException("竞拍价比起拍价低，不容许竞拍");
        }
        initPrice = d;
    }

    public static void main(String[] args) {

        codes_10_4_AuctionTest at = new codes_10_4_AuctionTest();
        try{
            at.bid("df");
        }catch (AuctionException as){
            System.out.println(as.getMessage());
        }
    }
}
