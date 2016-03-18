package com.supersimple.domain.exchange;

import com.supersimple.domain.model.stock.Stock;
import com.supersimple.domain.model.trade.Trade;

import java.util.*;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class GlobalBeverageCorporationExchange implements StockExchange {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private HashMap<String,Stock> stocksBySymbol;
    private List<Trade> trades;
    private Boolean exchangeIsLive;

    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * GlobalBeverageCorporationExchange Constructor
     * @param stocks The List of Stocks with which to populate this StockExchange
     */
    public GlobalBeverageCorporationExchange(List<Stock> stocks)
    {
        stocksBySymbol = new HashMap<String,Stock>();
        trades = new ArrayList<Trade>();

        for(Stock stock : stocks)
        {
            stocksBySymbol.put(stock.getSymbol(),stock);
        }

        exchangeIsLive = true;
    }


    ///////////////////////////////////////////
    //                                       //
    //  Overridden Methods (Stock)           //
    //                                       //
    ///////////////////////////////////////////


    @Override
    public void setIsLive(Boolean isLive)
    {
        exchangeIsLive = isLive;
    }

    @Override
    public Boolean getIsLive() {
        return exchangeIsLive;
    }

    @Override
    public Stock getStock(String stockSymbol) {

        Stock stock = stocksBySymbol.get(stockSymbol);

        return stock;
    }

    @Override
    public Collection<Stock> getAllStocks() {
        return stocksBySymbol.values();
    }

    @Override
    public List<Trade> getTradesFromStartDate(String stockSymbol, Date start)
    {
        List<Trade> filteredTrades = new ArrayList<Trade>();

        for(Trade trade : trades)
        {
            if( stockSymbol.equals(trade.getStockSymbol()) && trade.getTimeStamp().after(start))
                filteredTrades.add(trade);
        }

        return filteredTrades;
    }

    @Override
    public void submitTrade(Trade trade) {
        trades.add(trade);
    }

}
