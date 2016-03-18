package com.supersimple.domain.model.stock;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public interface Stock {

    /**
     * Returns this Stock's symbol
     * @return The stock symbol associated with this Stock
     */
    String getSymbol();

    /**
     * Returns this Stock's last Dividend
     * @return The last annual dividend recorded for this stock
     */
    double getLastDividend();

    /**
     * Returns the Par Value for this stock
     * @return The current Par Value for this tock
     */
    double getParValue();
}
