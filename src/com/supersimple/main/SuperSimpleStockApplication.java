package com.supersimple.main;

import com.supersimple.domain.commands.SuperSimpleStockCommand;
import com.supersimple.domain.commands.SuperSimpleStockCommandFactory;
import com.supersimple.domain.exchange.GlobalBeverageCorporationExchange;
import com.supersimple.domain.exchange.StockExchange;
import com.supersimple.util.SuperSimpleStockGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperSimpleStockApplication {

    ///////////////////////////////////////////
    //                                       //
    //           Class  Variables            //
    //                                       //
    ///////////////////////////////////////////

    static final String welcome = "Hello and welcome to the Super Simple Stock Application \n"
            + "Please enter a command";
    static final String prompt = "> ";


    ///////////////////////////////////////////
    //                                       //
    //           Method: main                //
    //                                       //
    ///////////////////////////////////////////

    public static void main(String[] args) {

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        //Create our stock exchange, and populate it with test data (taken from Problem Sheet)
        StockExchange exchange = new GlobalBeverageCorporationExchange(SuperSimpleStockGenerator.generateStocks());

        //Create our command factory - this is where we will be passing User-provided input,
        // and retrieving executable commands
        SuperSimpleStockCommandFactory commandFactory = new SuperSimpleStockCommandFactory();

        // say hello
        printWelcome();

        //process user commands as long as Exchange is live
        while(exchange.getIsLive())
        {
            // Show the prompt
            System.out.println();
            System.out.print(prompt);

            String userInput;

            try {
                userInput = inputReader.readLine();
            } catch(IOException ex) {
                System.err.println(ex.getMessage());
                printUsage();
                continue; // do not process user input any further in this iteration; continue
            }

            String[] inputElements = userInput.split(" ");
            if(inputElements.length < 1 || inputElements[0].isEmpty())
            {
                System.err.println("No recognised command received");
                printUsage();
                continue;
            }
            else if("help".equals(inputElements[0].toLowerCase()) )
            {
                printHelp();
                continue;
            }

            // retrieve the appropriate command for execution
            SuperSimpleStockCommand command = commandFactory.getCommand(inputElements,exchange);

            if(command == null) {
                // if no command is returned, printHelp
                System.err.println("Construction of command failed due to bad input");
                printUsage();
            }
            else
            {
                command.execute();
            }
        }

        printGoodbye();
        // exit
    }


    ///////////////////////////////////////////
    //                                       //
    //           Class methods               //
    //                                       //
    ///////////////////////////////////////////

    /**
     * Print a welcome message to the user
     */
    public static void printWelcome()
    {
        System.out.println(welcome);
    }

    /**
     * Print a goodbye message to the user
     */
    public static void printGoodbye()
    {
        System.out.println("Thanks for using SuperSimpleStockApplication; goodbye.");
    }

    /**
     * Print the usage doc for this application
     */
    public static void printUsage()
    {
        System.out.println("Usage:");
        System.out.println("<divyield|pe|trade|vwap|all|help> [commandArgs]");
        System.out.println("( enter 'help' for preferred commandArg formats)");
    }

    /**
     * Print SuperSimpleStockApplication help
     * (i.e. Supported commands, their descriptions, and at least 1 example of each)
     */
    public static void printHelp()
    {
        System.out.println("Supported Commands: ");
        System.out.println(); //empty line

        // Dividend Yield
        System.out.printf("%-10s <stockSymbol> <marketPrice> %n", "divyield");
        System.out.println("Description: Return the Dividend Yield for a specified stock, given a specified marketPrice");
        System.out.printf("Example: %s %s %.2f %n %n", "divyield", "TEA",88.0);

        // Calculate Price-Earnings Ratio
        System.out.printf("%-10s <stockSymbol> <marketPrice> %n", "pe");
        System.out.println("Description: Return the P/E Ratio for a specified stock, given a specified marketPrice");
        System.out.printf("Example: %s %s %.2f %n %n", "pe", "JOE",79.0);

        // Submit Trade
        System.out.printf("%-10s <stockSymbol> <quantity> <side> <price> %n", "trade");
        System.out.println("Description: Submit a trade of a specified stockSymbol, with specified arguments");
        System.out.println("n.b. do not enter negative prices: price will be treated as its absolute value (side denotes trade direction");
        System.out.printf("Example1: %s %s %d %s %.2f %n", "trade", "TEA",4,"buy",76.0);
        System.out.printf("Example2: %s %s %d %s %.2f %n %n", "trade", "GIN", 200, "sell",110.0);

        // VWAP
        System.out.printf("%-10s <stockSymbol> %n", "vwap");
        System.out.println("Description: Return the Volume-Weighted Average Stock Price, based on the last 15 mins' trades");
        System.out.printf("Example: %s %s %n %n", "vwap", "POP");

        // All Share Index
        System.out.printf("%-10s %n", "all");
        System.out.println("Description: Return the StockExchange All Share Index (using Geometric Mean)");
        System.out.printf("Example: %s %n %n", "all");

    }
}
