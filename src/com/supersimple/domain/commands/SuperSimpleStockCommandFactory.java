package com.supersimple.domain.commands;

import com.supersimple.domain.exchange.StockExchange;

import java.util.Arrays;

/**
 * Created by jamiecarmichael on 17/03/2016.
 */
public class SuperSimpleStockCommandFactory {

    ///////////////////////////////////////////
    //                                       //
    //           Class Variables             //
    //                                       //
    ///////////////////////////////////////////

    //Commands
    private static final String CALCULATE_DIVIDEND_YIELD = "divyield";
    private static final String CALCULATE_P_E_RATIO = "pe";
    private static final String SUBMIT_TRADE = "trade";
    private static final String CALCULATE_VWSP = "vwap";
    private static final String CALCULATE_ALL_SHARE_INDEX = "all";
    private static final String CLOSE_STOCK_EXCHANGE = "exit";

    // array of Supported Commands
    public static final String[] supportedCommands = {CALCULATE_DIVIDEND_YIELD,CALCULATE_P_E_RATIO,
    SUBMIT_TRADE, CALCULATE_VWSP, CALCULATE_ALL_SHARE_INDEX, CLOSE_STOCK_EXCHANGE};


    ///////////////////////////////////////////
    //                                       //
    //              Methods                  //
    //                                       //
    ///////////////////////////////////////////

    /**
     * Create the appropriate command based on userInput, and return it (associated with the provided
     * stockExchange)
     * @param userInput an array of Strings representing the command to be returned (and its parameters if any)
     * @param stockExchange the stockExchange with which to register the returned SuperSimpleStockCommand
     * @return a SuperSimpleStockCommand configured with regards to given input (poorly formed (or handled)
     *  input returns null)
     */
    public SuperSimpleStockCommand getCommand(String[] userInput, StockExchange stockExchange)
    {
        if( userInput == null || userInput.length ==0 )
        {
            System.out.println("Command factory received unsupported command type ... cannot create command");
            return null;
        }
        else if( userInput.length == 1 )
        {
            if(CALCULATE_ALL_SHARE_INDEX.equals(userInput[0])) {
                return new CalculateAllShareIndexCommand(stockExchange);
            }
            else if(CLOSE_STOCK_EXCHANGE.equals(userInput[0])) {
                return new CloseStockExchangeCommand(stockExchange);
            }
        }// else we have multiple command arguments to deal with...


        String commandType = userInput[0];
        // Remaining input contains the arguments for the command;
        String[] commandArgs = Arrays.copyOfRange(userInput,1,userInput.length);

        SuperSimpleStockCommand command = null;
        int argCount = commandArgs.length;
        switch(commandType)
        {
            case CALCULATE_DIVIDEND_YIELD:
                if(CalculateDividendYieldCommand.expectedArgCount == argCount)
                    command = new CalculateDividendYieldCommand(stockExchange, commandArgs);
                break;
            case CALCULATE_P_E_RATIO:
                if(CalculatePriceEarningsRatioCommand.expectedArgCount == argCount)
                    command = new CalculatePriceEarningsRatioCommand(stockExchange, commandArgs);
                break;
            case SUBMIT_TRADE:
                if(SubmitTradeCommand.expectedArgCount == argCount)
                    command = new SubmitTradeCommand(stockExchange, commandArgs);
                break;
            case CALCULATE_VWSP:
                if(CalculateVolumeWeightedAverageCommand.expectedArgCount == argCount)
                    command = new CalculateVolumeWeightedAverageCommand(stockExchange, commandArgs);
                break;
            default:
                System.err.println("Command factory received unsupported command type ... cannot create command");
                command = null;
        }

        return command; // possibly null
    }
}
