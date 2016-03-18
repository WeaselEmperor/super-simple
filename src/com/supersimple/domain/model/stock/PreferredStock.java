package com.supersimple.domain.model.stock;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class PreferredStock implements Stock {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private String symbol;
    private double lastDividend;
    private double fixedDividend;
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
     * @param fixedDividend The fixed dividend associated with this stock
     * @param parValue The current Par Value for this stock
     */
    public PreferredStock(String symbol, double lastDividend, double fixedDividend, double parValue)
    {
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    ///////////////////////////////////////////
    //                                       //
    //              Methods                  //
    //                                       //
    ///////////////////////////////////////////


    /**
     * Returns the Fixed Dividend for this PreferredStock
     * @return fixed dividend for this PreferredStock
     */
    public double getFixedDividend()
    {
        return fixedDividend;
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