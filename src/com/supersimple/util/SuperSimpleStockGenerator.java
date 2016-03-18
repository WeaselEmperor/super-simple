package com.supersimple.util;

import com.supersimple.domain.model.stock.CommonStock;
import com.supersimple.domain.model.stock.PreferredStock;
import com.supersimple.domain.model.stock.Stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamiecarmichael on 18/03/2016.
 */
public class SuperSimpleStockGenerator {

    /**
     * util method to return a List of generated stocks; generated as per Problem Specification for this application
     * @return
     */
    public static List<Stock> generateStocks()
    {
        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(new CommonStock("TEA",0.0,100.0));
        stocks.add(new CommonStock("POP",8.0,100.0));
        stocks.add(new CommonStock("ALE",23.0,60.0));
        stocks.add(new PreferredStock("GIN",8.0,2.0,100.0));
        stocks.add(new CommonStock("JOE",13.0,250.0));

        return stocks;
    }
}
