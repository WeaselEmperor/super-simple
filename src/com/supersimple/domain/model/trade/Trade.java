package com.supersimple.domain.model.trade;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class Trade {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private String stockSymbol;
    private Date timeStamp;
    private int numShares;
    private TradeDirection side;
    private double price;

    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * Trade Constructor
     * @param numShares The number of shares being bought / sold
     * @param side      The direction/side of the trade (i.e. Buy/Sell)
     * @param price     The price of the trade
     */
    public Trade(String stockSymbol, int numShares, TradeDirection side, double price)
    {
        timeStamp = Calendar.getInstance().getTime();
        this.stockSymbol = stockSymbol;
        this.numShares = numShares;
        this.side = side;
        this.price = price;
    }

    ///////////////////////////////////////////
    //                                       //
    //              Methods                  //
    //                                       //
    ///////////////////////////////////////////

    /**
     * Return the stockSymbol against which this trade is positioned
     * @return this trade's stockSymbol
     */
    public String getStockSymbol() { return stockSymbol; }

    /**
     * Return the timeStamp
     * @return the time at which this trade was submitted
     */
    public Date getTimeStamp() { return timeStamp; }

    /**
     * Return the number of shares being traded
     * @return number of shares being traded
     */
    public int getNumShares() { return numShares; }

    /**
     * Return the side of this trade (i.e. TradeDirection.BUY | TradeDirection.SELL)
     * @return the side of this trade
     */
    public TradeDirection getSide() { return side; }

    /**
     * Return the price at which this trade is to be submitted
     * @return this trade's price (per share)
     */
    public double getPrice() { return price; }


    ///////////////////////////////////////////
    //                                       //
    //  Overridden Methods (Object)          //
    //                                       //
    ///////////////////////////////////////////

    /**
     *
     * @return String representation of the Trade object
     */
    public String toString()
    {
        return String.format("{stock=%s, quantity=%d, side=%s, price=%.2f, time=%5$tF %5$tT}",
                stockSymbol,numShares,side,price, timeStamp);
    }

}
