package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.domain.model.stock.Stock;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class CalculatePriceEarningsRatioCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String displayMessage = "Calculating Price-Earnings Ratio... \n Result is : ";
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
     * CalculatePriceEarningsRatioCommand Constructor
     * @param exchange The StockExchange with which to associate this Command
     * @param commandArgs User-provided arguments with which to execute this Command
     */
    public CalculatePriceEarningsRatioCommand(StockExchange exchange, String[] commandArgs)
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
        //double result = marketPrice / exchange.
        Stock stock = exchange.getStock(stockSymbol);

        double result = 0.0;
        double lastDividend = stock.getLastDividend();

        if(lastDividend != 0.0)
        {
            result = marketPrice / lastDividend;
        }

        System.out.println(displayMessage);
        System.out.println(result);
    }

}
