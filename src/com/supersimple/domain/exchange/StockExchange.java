package com.supersimple.domain.exchange;

import com.supersimple.domain.model.stock.Stock;
import com.supersimple.domain.model.trade.Trade;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Interface designed to represent the behaviours of a StockExchange
 * Created by jamiecarmichael on 17/03/2016.
 */
public interface StockExchange {

    /**
     * Submit a trade
     * @param trade Trade for submission to the exchange
     */
    void submitTrade(Trade trade);

    /**
     * Retreive a Stock object by its Symbol
     * @param stockSymbol Symbol referring to the desired stock
     * @return the Stock object referred to by the provided stockSymbol
     */
    Stock getStock(String stockSymbol);

    /**
     * Retrieve a Collection of all Stocks on this StockExchange
     * @return All stocks on this exchange
     */
    Collection<Stock> getAllStocks();

    /**
     * Retrieve a List of all Trades for a specified stockSymbol occuring after the specified start Date
     * @param start
     * @return
     */
    List<Trade> getTradesFromStartDate(String stockSymbol, Date start);

    /**
     * Whether or not the StockExchange is currently live
     *
     * @return true if StockExchange is live; otherwise false
     */
    Boolean getIsLive();

    /**
     * Set the live status of the Stock Exchange
     * @param live true=exchange live; false=exchange not live
     */
    void setIsLive(Boolean live);

}
