package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class CloseStockExchangeCommand implements SuperSimpleStockCommand {

    ///////////////////////////////////////////
    //                                       //
    //           Member Variables            //
    //                                       //
    ///////////////////////////////////////////

    private StockExchange exchange;
    private String displayMessage = "Closing Stock Exchange...";


    ///////////////////////////////////////////
    //                                       //
    //              Constructor              //
    //                                       //
    ///////////////////////////////////////////

    /**
     * CloseStockExchange Constructor
     * @param exchange The stock exchange with which this command is concerned
     */
    public CloseStockExchangeCommand(StockExchange exchange)
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
        exchange.setIsLive(false);
        System.out.println(displayMessage);
    }
}
