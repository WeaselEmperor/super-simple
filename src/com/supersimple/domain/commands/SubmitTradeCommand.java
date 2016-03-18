package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.domain.model.trade.Trade;
import com.supersimple.domain.model.trade.TradeDirection;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class SubmitTradeCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String displayMessage = "Calculating Price-Earnings Ratio... \n Result is : ";
    private String stockSymbol;
    private double price;
    private int numShares;
    private TradeDirection side;


    ///////////////////////////////////////////
    //                                       //
    //            Class Variables            //
    //                                       //
    ///////////////////////////////////////////

    static final int expectedArgCount = 4;


    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * SubmitTradeCommand Constructor
     * @param exchange The StockExchange with which to associate this Command
     * @param commandArgs User-provided arguments with which to execute this Command
     */
    public SubmitTradeCommand(StockExchange exchange, String[] commandArgs)
    {
        if(commandArgs.length != expectedArgCount)
        {
            System.err.println(String.format("Exiting command... "+
                            "Incorrect number arguments passed to command; expected %d, recieved %d",
                    expectedArgCount,commandArgs.length));
            return;
        }

        stockSymbol = commandArgs[0];
        numShares = Integer.parseInt(commandArgs[1]);
        side = TradeDirection.getDirection(commandArgs[2]);
        price = Math.abs(Double.parseDouble(commandArgs[3]));

        this.exchange = exchange;
    }

    ///////////////////////////////////////////
    //                                       //
    //        Overridden Methods             //
    //     (SuperSimpleStockCommand)         //
    //                                       //
    ///////////////////////////////////////////

    @Override
    public void execute()
    {
        //TimeStamp is created when Trade object is constructed
        Trade trade = new Trade(stockSymbol,numShares,side,price);
        exchange.submitTrade(trade);

        System.out.println("Trade submitted:");
        System.out.println(trade);
    }
}
