package com.supersimple.domain.model.trade;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public enum TradeDirection {
    BUY,SELL;

    private static String buy = "buy";
    private static String sell = "sell";

    public static TradeDirection getDirection(String value)
    {
        return sell.equals(value.toLowerCase())
                ? SELL
                : BUY;
    }
}
