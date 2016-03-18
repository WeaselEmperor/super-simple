package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.domain.model.trade.Trade;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class CalculateVolumeWeightedAverageCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String stockSymbol;
    private String displayMessage = "Calculating Volume Weighted Average ... \n Result: ";


    ///////////////////////////////////////////
    //                                       //
    //            Class Variables            //
    //                                       //
    ///////////////////////////////////////////

    static final int expectedArgCount = 1;


    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * CalculateVolumeWeightedAverageCommand Constructor
     * @param exchange The StockExchange with which to associate this Command
     * @param commandArgs User-provided arguments with which to execute this Command
     */
    public CalculateVolumeWeightedAverageCommand(StockExchange exchange, String[] commandArgs)
    {
        if(commandArgs.length != expectedArgCount)
        {
            System.err.println(String.format("Exiting command... "+
                            "Incorrect number arguments passed to command; expected %d, recieved %d",
                    expectedArgCount,commandArgs.length));
            return;
        }


        stockSymbol = commandArgs[0];
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
        Calendar cal = Calendar.getInstance(); // get the current time
        cal.add(Calendar.MINUTE, -15); // subtract 15 minutes
        Date fifteenMinutesAgo = cal.getTime();

        Collection<Trade> trades = exchange.getTradesFromStartDate(stockSymbol, fifteenMinutesAgo);

        double result = 0.0;
        if(trades.size() != 0)
        {
            double totalDollarsTraded = 0.0;
            double totalVolume = 0.0;
            for(Trade trade : trades)
            {
                //no need to check side; VWAP calculated based on total Trading volume;
                totalDollarsTraded += (trade.getNumShares() * trade.getPrice());
                totalVolume += trade.getNumShares();
            }

            result = totalDollarsTraded / totalVolume;
        }

        System.out.println(displayMessage);
        System.out.println(String.format("%.4f",result));
    }
}
