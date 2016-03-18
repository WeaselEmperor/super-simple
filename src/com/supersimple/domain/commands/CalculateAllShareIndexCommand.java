package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.domain.model.stock.Stock;

import java.util.Collection;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class CalculateAllShareIndexCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String displayMessage = "Calculating the GBCE All Share Index... \n Result: ";


    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * CalculateAllShareIndexCommand Constructor
     * @param exchange The stock exchange with which this command is concerned
     */
    public CalculateAllShareIndexCommand(StockExchange exchange)
    {
        this.exchange = exchange;
    }


    ///////////////////////////////////////////
    //                                       //
    //        Overridden Methods             //
    //     (SuperSimpleStockCommand)         //
    //                                       //
    ///////////////////////////////////////////

    @Override
    public void execute() {
        Collection<Stock> stocks = exchange.getAllStocks();

        double product = 1.0;
        for(Stock stock : stocks)
        {
            product = product *  stock.getParValue();
        }

        // Generally speaking - The nth root of x can be calculated by multiplying x to its (1/n)th power:
        double power = (1.0 / (double)stocks.size());
        double geometricMean = Math.pow(product,power);

        System.out.println(displayMessage);
        System.out.println(String.format("%.10f",geometricMean));
    }

}
