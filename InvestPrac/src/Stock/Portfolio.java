package Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Portfolio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
		
		int input = 0;
		String Comp;
		int numShares;
		double comm = 9.99;
		double value = 0.0;
		int holdShares = 0;
		double holdValue = 0.0;
		String choice;
		String choiceSymbol;
		int count = 0;
		int shareLoss;
		double amountGain = 0.0;
		int G = 0;
		double updated = 0.0;
		
		
		Scanner user = new Scanner (System.in);
		
		String compName;

		// used for the search options but initially nothing is in their portfolio yet
		Stock s1 = new Stock("AAPL", "Apple Inc", 0, 156.99, 0.0);
		Stock s2 = new Stock("GOOAV", "Google Inc", 0, 568.67, 0.0);
		Stock s3 = new Stock("RY", "Royal Bank of Canada", 0, 99.08, 0.0);
		Stock s4 = new Stock("BBRY", "Blackberry Ltd", 0, 11.57, 0.0);
		Stock s5 = new Stock("BAC", "Bank of America", 0, 25.83, 0.0);
		Stock s6 = new Stock("DIS", "Walt Disney Inc", 0, 97.38, 0.0);
		Stock s7 = new Stock("IBM", "International Business Machines Corp", 0, 147.10, 0.0);
		Stock s8 = new Stock("MSFT", "Microsoft Inc", 0, 77.49, 0.0);
		Stock s9 = new Stock("INTC", "Intel Inc", 0, 39.67, 0.0);
		Stock s10 = new Stock("TSE:L", "Lobaw Companies Ltd", 0, 69.15, 0.0);
		Stock s11 = new Stock("FB", "Facebook Inc", 0, 173.74, 0.0);
		
	
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		ArrayList<Stock> stocksAdd = new ArrayList<Stock>();
		ArrayList<Double> amountGained = new ArrayList<Double>();
			
		// adding to stocks array list 
		stocks.add(0, s1);
		stocks.add(1, s2);
		stocks.add(2, s3);
		stocks.add(3, s4);
		stocks.add(4, s5);
		stocks.add(5, s6);
		stocks.add(6, s7);
		stocks.add(7, s8);
		stocks.add(8, s9);
		stocks.add(9, s10);
		stocks.add(10, s11);
	
		System.out.println("(1) buy: own a new investment or add more quantity to an existing investment");    
		 
		System.out.println("(2) sell: reduce some quantity of an existing investment"); 
		 
		System.out.println("(3) update: refresh the prices of all existing investments"); 
		 
		System.out.println("(4) getGain: compute the total gain of the portfolio by accumulating the gains of all its investments");    
		 
		System.out.println("(5) Search:");
		
		
		System.out.println("Enter Choice");
		
		input = Integer.parseInt(myinput.readLine());
		
		
	while(input!= 4)
	{
		switch(input)
		{
			case 1:
			{
				//pretend this is stock choice, do mutual stocks after 
				System.out.println("own a new investment (A) or add more quantity to an existing investment(B)?");
				choice =  user.nextLine();	
				
				if(choice.charAt(0) == 'B')
				{
					
					System.out.println("Which Company do you want to add shares to? (symbols):");
				
					choiceSymbol = user.nextLine();	
				
					System.out.println("How much shares you want to buy?");
				
					numShares = Integer.parseInt(myinput.readLine());
						
					for(int x = 0; x< stocksAdd.size(); x++)
					{
						System.out.println( stocksAdd.get(x).Name );
						
						if(choiceSymbol.equalsIgnoreCase(stocksAdd.get(x).symbol))
						{
							
							stocksAdd.get(x).sharesNum = stocksAdd.get(x).sharesNum + numShares;
							
							stocksAdd.get(x).bookValue = stocksAdd.get(x).bookValue + 
					        
							(((stocksAdd.get(x).price) * numShares) + comm ) ;
							
						
						}
					
					
					}
				
			
					for(int x = 0; x<stocksAdd.size(); x++)
					{
						System.out.println(stocksAdd.get(x));
					}
				
				
					break;
			
				}//end of if
				
				
				else if(choice.charAt(0) == 'A')
				{
							
					System.out.println("Which Company do you want to buy from? Enter symbol:");
					
					choiceSymbol = user.nextLine();	
					
					//searches whole stock list first to check if choice is valid
					for(int x = 0; x<stocks.size(); x++)
					{
						if(choiceSymbol.equals(stocks.get(x).symbol))
						{
							
							System.out.println("Choice is valid");
							
							Stock temp = new Stock(stocks.get(x).symbol, stocks.get(x).Name, 0, stocks.get(x).price, 0.0);
							
							stocksAdd.add(count,temp);	
							
							System.out.println("How much shares you want to buy?");
						
							numShares = Integer.parseInt(myinput.readLine());
								
							holdShares = holdShares + numShares;
								
							stocksAdd.get(count).sharesNum = holdShares;
								
							value = (stocksAdd.get(count).price) * (stocksAdd.get(count).sharesNum);
								
							//holdValue = holdValue + value;
							  
							value = value + comm;
								
							stocksAdd.get(count).bookValue =  value;
							
							value = 0;
							
							holdShares = 0;
									
							count++;
								
							
						}
						
						
					}
					
					
					
			    }
			
				
				//System.out.println("SIZE OF NEW ARRAY" + stocksAdd.size());
				
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					System.out.println(stocksAdd.get(x));
				}
				
				break;
			
			}// end of case1
			
			
			case 2:
			{
				//ask for current price??
				System.out.println("Enter company you want to make changes to: (symbols)");
				
				choiceSymbol = user.nextLine();	
				
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					if(choiceSymbol.equals(stocksAdd.get(x).symbol))
					{
						System.out.println("Enter amount of shares you want to sell");
						
						shareLoss = Integer.parseInt(myinput.readLine());
						
						if(shareLoss <= stocksAdd.get(x).sharesNum)
						{
						
							amountGain = ((stocksAdd.get(x).sharesNum * stocksAdd.get(x).price) - comm) - stocksAdd.get(x).bookValue;
					
							amountGained.add(G, amountGain);
						
							stocksAdd.get(x).bookValue = (stocksAdd.get(x).bookValue * shareLoss) / stocksAdd.get(x).sharesNum;
						
							stocksAdd.get(x).sharesNum = stocksAdd.get(x).sharesNum - shareLoss; 
							
							if(stocksAdd.get(x).sharesNum <= 0)
							{
								stocksAdd.remove(x);
							}
										
							G++;
					
						}
						
					}
					
				}
				
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					System.out.println(stocksAdd.get(x));
				}
			
				break;
				
			}//end of case2
			
			case 3:
			{
				
				for(int x = 0; x<stocksAdd.size(); x++)
				{
					
						System.out.println(stocksAdd.get(x).symbol + "\n" + stocksAdd.get(x).Name + "\n" +  stocksAdd.get(x).price + "\n");
					
						System.out.println("Enter updated price:");
						
						updated = Double.parseDouble(myinput.readLine());
						
						stocksAdd.get(x).price = updated;
				
					
				}
				
			
				
				break;
			}//end of case3
			
			
			
			
			
			
			
			
			
		}//end of switch
		
		
		
		
		System.out.println("Enter Choice");
		
		input = Integer.parseInt(myinput.readLine());
		
}
		
		
		
		
		
		
		
		
		
		
		//System.out.println(stocks.get(7));
	
	
	
	
	}

}
