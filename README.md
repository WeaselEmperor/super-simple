## super-simple

Repo created for Recruitment-Process development. Current projects: [Super Simple Stocks Test]


### Super Simple Stocks Test

####Requirements
Provide source code that will:
   1. For a given stock
      1. Given a market price as input, calculate the dividend yield
      2. Given a market price as input, calculate the Price-Earnings Ratio
      3. Record a trade with timestamp, quantity of shares, buy/sell indicator, trade price
      4. Calculate Volume-Weighted Stock Price, based on trades in past 15 minutes
    2. Calculate the Global Beverage Corporation Exchange All Share Index, using the geometric mean of prices for all stocks
  

####Constraints & Notes
   1. Written in one of these languages:
      * Java, C#, C++, Python
   2. No database or GUI is required; all data need only be held in memory
   3. Formulae and data provided are simplified representations for the purpose of this exercise
   
####Supplied domain data:
#####Sample stock data
| Stock Symbol  | Type       | Last Dividend   | Fixed Dividend | Par Value |
|:------------- |:-----------| ---------------:|---------------:|----------:|
| TEA           | Common     | 0               |                | 100       |
| POP           | Common     |   8             |                | 100       |
| ALE           | Common     |    23           |                | 60        |
| GIN           | Preferred  |    23           |2%              | 100       |
| JOE           | Common     |    23           |                | 250       |

#####Formulae
Table of Formulae provided for calculation of:
  Dividend yield (both Common and Preferred)
  P/E ratio
  Geometric Mean
  Volume Weighted Stock Price

Provided table does not render its values in latest OS X Pages; will add the completed table soon.

---

### Build / Implementation notes
Code written in intelliJ using Java 1.8
Completed code can be run via Jar included in project's  directory.

i.e. (from the command line, inside the SuperSimpleStocks project folder): 
$ java -jar out/artifacts/SuperSimpleStocks_jar/SuperSimpleStocks.jar
