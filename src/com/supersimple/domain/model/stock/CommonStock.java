package com.supersimple.domain.model.stock;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class CommonStock implements Stock {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private String symbol;
    private double lastDividend;
    private double parValue;

    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * PreferredStock Constructor
     *
     * @param symbol The symbol with which to identify this stock
     * @param lastDividend The last recorded annual dividend
     * @param parValue The current Par Value for this stock
     */
    public CommonStock(String symbol, double lastDividend, double parValue)
    {
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    ///////////////////////////////////////////
    //                                       //
    //  Overridden Methods (Stock)           //
    //                                       //
    ///////////////////////////////////////////

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double getLastDividend() {
        return lastDividend;
    }

    @Override
    public double getParValue() {
        return parValue;
    }
}
