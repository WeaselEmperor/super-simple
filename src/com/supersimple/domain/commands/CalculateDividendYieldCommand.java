package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.domain.model.stock.PreferredStock;
import com.supersimple.domain.model.stock.Stock;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class CalculateDividendYieldCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String displayMessage = "Calculating Dividend Yield... \n Yield per share: ";
    private String stockSymbol;
    private double marketPrice;


    ///////////////////////////////////////////
    //                                       //
    //            Class Variables            //
    //                                       //
    ///////////////////////////////////////////

    static final int expectedArgCount = 2;


    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * Constructor
     * @param exchange The StockExchange with which to associate this Command
     * @param commandArgs User-provided arguments with which to execute this Command
     */
    public CalculateDividendYieldCommand(StockExchange exchange, String[] commandArgs)
    {
        if(commandArgs.length != expectedArgCount)
        {
            System.err.println(String.format("Exiting command... "+
                    "Incorrect number arguments passed to command; expected %d, recieved %d",
                    expectedArgCount,commandArgs.length));
            return;
        }

        stockSymbol = commandArgs[0];
        marketPrice = Double.parseDouble(commandArgs[1]);
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

        Stock stock = exchange.getStock(stockSymbol);
        double result = 0.0;

        if(stock instanceof PreferredStock)
        {

            double fixedDivPercentage = ((PreferredStock) stock).getFixedDividend() / 100;
            double parValue = stock.getParValue();

            result = (fixedDivPercentage * parValue);

        }
        else
        {
            //else is CommonStock
            result = stock.getLastDividend() / marketPrice;
        }

        System.out.println(displayMessage);
        System.out.println(String.format("%.2f",result));
    }

}
