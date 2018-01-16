package Portfolio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MutualFund 
{


	
	String symbol;
	String Name;
	int sharesNum;
	double price;
	double bookValue;
	
	public MutualFund (String compSymbol, String compName, int shares, double stockPrice, double book)
	{
	
		this.symbol = compSymbol;
		this.Name = compName;
		this.sharesNum = shares;
		this.price = stockPrice;
		this.bookValue = book;
			
	}
	
	/*
	*User-defined function to generic data by adding and editing updated mutualFunds with
	* their respected calculations.

	 *@pre user defined arrayList for type Stocks, user defined arrayList for type Mutual Funds

	 *@param Stock arrayList.

	 *@param MutualFund ArrayList.

	* *@return void */ 
	
	public static void CalculateMutualFunds(ArrayList<MutualFund> mutualFunds, ArrayList<MutualFund> mutualFundsAdd, 
			ArrayList<Stock> stocksAdd)throws NumberFormatException, IOException{

		int numShares = 0;
		double value = 0.0;
		int holdShares = 0;
		String choice;
		String choiceSymbol;
		int count = 0;
		double newPrice = 0.0;
		String compName;
		int present = 0;
		int exit = 0;
		int found = 0;
		
		Scanner user = new Scanner (System.in);
			
		BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
	
					
		
					
					System.out.println("own a new investment (A) or add more quantity to an existing investment(B)?");
					
					choice =  user.nextLine();	
					
					while(choice.equalsIgnoreCase("A") == false && choice.equalsIgnoreCase("B") == false)
					{
						System.out.println("Invalid Input: own a new investment (A) or add more quantity to an existing investment(B)?");
						
						choice = user.nextLine();
					}
					
			  if(choice.charAt(0) == 'B')
			  {
						if(mutualFundsAdd.size() == 0)
						{
							System.out.println("Sorry, there are no MutualFunds to update shares");
							exit = 1;
							
						}
						
						
					if(exit != 1)
					{
						
						System.out.println("Which Company do you want to add shares to? (symbols):");
					
						choiceSymbol = user.nextLine();	
						
						while(choiceSymbol.length() == 0)
						{
							System.out.println("Invalid Choice, you must enter in a symbol");
							
							choiceSymbol = user.nextLine();	
						}
					
						
						//checks if symbol exits
						for(int x = 0; x<mutualFundsAdd.size(); x++)
						{
							if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(x).symbol))
							{
								found = 1;
							}
						}
						
						if(found != 1)
						{
							System.out.println("Investment does not exsit");
						}
						
						else
						{
						
						
						boolean done = false;
						while (!done) {
						    try {
						    	System.out.println("How much shares you want to buy?");
						    	numShares = Integer.parseInt(myinput.readLine());
						        done = true;
						    } catch (NumberFormatException e) 
						    {
						       System.out.println("Invalid Input");
						    }
				      	}
						
						
						while(numShares <= 0)
						{
							System.out.println("Sorry, you must enter in at least one share:");
							
							done = false;
							while (!done) {
							    try {
							    	System.out.println("How much shares you want to buy?");
							    	numShares = Integer.parseInt(myinput.readLine());
							        done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
							
						}
							
						for(int x = 0; x< mutualFundsAdd.size(); x++)
						{
							
							
							if(choiceSymbol.equalsIgnoreCase(mutualFundsAdd.get(x).symbol))
							{
								
								mutualFundsAdd.get(x).sharesNum = mutualFundsAdd.get(x).sharesNum + numShares;
								
								mutualFundsAdd.get(x).bookValue = mutualFundsAdd.get(x).bookValue + 
						        
								((mutualFundsAdd.get(x).price) * numShares) ;
								
							
							}
						
						
						}
					
						for(int x = 0; x<mutualFundsAdd.size(); x++)
						{
							System.out.println(mutualFundsAdd.get(x));
						}
					
					
						}//end of big else (if symbol doesn't exit)
				
					}//end of if
				
				}//end of exit if
					
					else if(choice.charAt(0) == 'A')
					{
								
								
								System.out.println("Which Company do you want to buy shares from? Enter Symbol:");
								
								choiceSymbol = user.nextLine();	
								
								while(choiceSymbol.length() == 0)
								{
									System.out.println("Invalid Choice, you must enter in a symbol");
									
									choiceSymbol = user.nextLine();	
								}
						
							
								for(int x = 0; x < stocksAdd.size(); x++)
								{
									if(choiceSymbol.equals(stocksAdd.get(x).symbol))
									{
											
										System.out.println("Sorry, this investment already exists in your Stock List");
										
										present = 1;	
								
									}
									
									
								}
								
											
								
								
								for(int x = 0; x < mutualFundsAdd.size(); x++)
								{
									if(choiceSymbol.equals(mutualFundsAdd.get(x).symbol))
									{
										present = 1;
										
										System.out.println("Sorry, this investment already exists in your Mutual Funds List");
										
										
										boolean done = false;
										while (!done) {
										    try {
										    	System.out.println("How much shares you want to buy?");
										    	numShares = Integer.parseInt(myinput.readLine());
										        done = true;
										    } catch (NumberFormatException e) 
										    {
										       System.out.println("Invalid Input");
										    }
								      	}
										
										while(numShares <= 0)
										{
											System.out.println("Sorry, you must enter in at least one share:");
											
											done = false;
											while (!done) {
											    try {
											    	System.out.println("How much shares you want to buy?");
											    	numShares = Integer.parseInt(myinput.readLine());
											        done = true;
											    } catch (NumberFormatException e) 
											    {
											       System.out.println("Invalid Input");
											    }
									      	}
											
										}
										
										mutualFundsAdd.get(x).sharesNum = mutualFundsAdd.get(x).sharesNum + numShares;
										
										mutualFundsAdd.get(x).bookValue = mutualFundsAdd.get(x).bookValue + 
								        
										((mutualFundsAdd.get(x).price) * numShares) ;
										
								
									}
									
									
								}
								
								if(present != 1)
								{
								
								System.out.println("Enter Name of company:");
								
								compName = user.nextLine();
								
								while(compName.length() == 0)
								{
									System.out.println("Invalid Choice, you must enter in a company name");
									
									compName = user.nextLine();
								}
								
								
								boolean done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter Current price for this investment:");
										
										newPrice = Double.parseDouble(myinput.readLine());
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
						
								
								if(newPrice < 0)
								{
									System.out.println("Invalid input: Can't have neg price");
									done = false;
									while (!done) {
									    try {
									    	System.out.println("Enter Current price for this investment:");
											
											newPrice = Double.parseDouble(myinput.readLine());
									       
											done = true;
									    } catch (NumberFormatException e) 
									    {
									       System.out.println("Invalid Input");
									    }
							      	}
							
									
								}
								
								
								
								
								
								
								MutualFund temp = new MutualFund( choiceSymbol, compName, 0, newPrice, 0.0);
								
								mutualFundsAdd.add(count,temp);	
								
								 done = false;
								while (!done) {
								    try {
								    	System.out.println("How much shares you want to buy?");
								    	numShares = Integer.parseInt(myinput.readLine());
								        done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
								
								while(numShares <= 0)
								{
									System.out.println("Sorry, you must enter in at least one share:");
									
								    done = false;
									while (!done) {
									    try {
									    	System.out.println("How much shares you want to buy?");
									    	numShares = Integer.parseInt(myinput.readLine());
									        done = true;
									    } catch (NumberFormatException e) 
									    {
									       System.out.println("Invalid Input");
									    }
							      	}
									
								}
									
								holdShares = holdShares + numShares;
									
								mutualFundsAdd.get(count).sharesNum = holdShares;
									
								value = (mutualFundsAdd.get(count).price) * (mutualFundsAdd.get(count).sharesNum);
									
								
									
								mutualFundsAdd.get(count).bookValue =  value;
								
								value = 0;
								
								holdShares = 0;
										
								count++;
								}
						
						
								
								
								for(int x = 0; x<mutualFundsAdd.size(); x++)
								{
									System.out.println(mutualFundsAdd.get(x));
								}
								
				    }
				
					
				
			}

	/*
	*User-defined function to enable user to sell MutuaFunds editing updated prices MutualFund with
	* their respected calculations and receiving total revenue.

	 *@pre user defined arrayList for type MutualFund

	 *@param Mutual arrayList.

	* *@return void */ 
	
	
				public static void SellMutualFunds(ArrayList<MutualFund> mutualFundsAdd) throws NumberFormatException, IOException
				{
			
				   BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
					String choiceSymbol;
					int shareLoss = 0;
					double comm = 45.00;
					double revenueGained = 0.0;
					double newPrice = 0.0;
					int flag = 0;
					
					Scanner user = new Scanner (System.in);
					
					
					System.out.println("Enter company investment you want to sell: (symbols)");
					
					choiceSymbol = user.nextLine();	
					
					while(choiceSymbol.length() == 0)
					{
						System.out.println("Invalid Choice, you must enter in a symbol");
						
						choiceSymbol = user.nextLine();	
					}
					
					
					for(int x = 0; x<mutualFundsAdd.size(); x++)
					{
						if(choiceSymbol.equals(mutualFundsAdd.get(x).symbol))
						{
							
							flag = 1;
							
							boolean done = false;
							while (!done) {
							    try {
							    	System.out.println("Enter Current price for this investment:");
									
									newPrice = Double.parseDouble(myinput.readLine());
							       
									done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
							
							
							if(newPrice < 0)
							{
								System.out.println("Invalid input: Can't have neg price");
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter Current price for this investment:");
										
										newPrice = Double.parseDouble(myinput.readLine());
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
						
								
							}
							
							
							
							mutualFundsAdd.get(x).price = newPrice;
							
							done = false;
							while (!done) {
							    try {
							    	System.out.println("Enter amount of shares you want to sell");
									
									shareLoss = Integer.parseInt(myinput.readLine());
									
							       
									done = true;
							    } catch (NumberFormatException e) 
							    {
							       System.out.println("Invalid Input");
							    }
					      	}
							
							
							
							
							while(shareLoss <= 0)
							{
								System.out.println("Invalid Input, you must at least enter in one share");
								
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter amount of shares you want to sell");
										
										shareLoss = Integer.parseInt(myinput.readLine());
										
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
								
								
							}
							
							
							while(shareLoss > mutualFundsAdd.get(x).sharesNum )
							{
								System.out.println("Invalid Input, shares entered exceeded limit amount");
								
								done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter amount of shares you want to sell");
										
										shareLoss = Integer.parseInt(myinput.readLine());
										
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
								
								
							}
							
							
									
							if(shareLoss <= mutualFundsAdd.get(x).sharesNum)
							{
							
							
								mutualFundsAdd.get(x).bookValue = (mutualFundsAdd.get(x).bookValue * (mutualFundsAdd.get(x).sharesNum - shareLoss)) / mutualFundsAdd.get(x).sharesNum;
							
								mutualFundsAdd.get(x).sharesNum = mutualFundsAdd.get(x).sharesNum - shareLoss; 
								
								revenueGained = ((shareLoss * mutualFundsAdd.get(x).price) - comm );
								
								System.out.println("Revenue Received: $" + revenueGained);
								
								
								
								if(mutualFundsAdd.get(x).sharesNum <= 0)
								{
									mutualFundsAdd.remove(x);
								}
											
								
						
							}
							
						}
						
					}
					
					if(flag != 1)
					{
						System.out.println("Sorry, investment doesn't exit");
					}
					
				}
				
				
				/*
				*User-defined function to generic data updated all stocks price with
				* their respected calculations.

				 *@pre user defined arrayList for type Stocks, user defined arrayList for type Mutual Funds

				 *@param MutualFund arrayList.

				* *@return void
				*  */ 
				
				public static void updateMutualFundPrice(ArrayList<MutualFund> mutualFundsAdd) throws NumberFormatException, IOException
				{
					BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
					double updated = 0.0;
					String choice;
					
					Scanner user = new Scanner (System.in);
					
					for(int x = 0; x<mutualFundsAdd.size(); x++)
					{
						
							System.out.println(mutualFundsAdd.get(x).symbol + "\n" + mutualFundsAdd.get(x).Name + "\n" +  "Current Price: $" + mutualFundsAdd.get(x).price + "\n");
						
							System.out.println("Enter 'P'- To Update Price, 'S'- To Skip This Investment, 'Q'- Quit)");
							
							choice = user.nextLine();
							
						
							while(choice.equalsIgnoreCase("P") == false && choice.equalsIgnoreCase("S") == false && choice.equalsIgnoreCase("Q") == false)
							{
								System.out.println("Invalid Choice, Enter 'P'- To Update Price, 'S'- To Skip This Investment, 'Q'- Quit)" );
								choice = user.nextLine();
							}
							
							
							
							if(choice.charAt(0) == 'P' || choice.charAt(0) == 'p')
							{
									
								boolean done = false;
								while (!done) {
								    try {
								    	System.out.println("Enter updated Price:");
										
										updated = Double.parseDouble(myinput.readLine());
										
								       
										done = true;
								    } catch (NumberFormatException e) 
								    {
								       System.out.println("Invalid Input");
								    }
						      	}
								
							
								if(updated < 0)
								{
									System.out.println("Invalid input: Can't have neg price");
									done = false;
									while (!done) {
									    try {
									    	System.out.println("Enter updated Price:");
											
											updated = Double.parseDouble(myinput.readLine());
									       
											done = true;
									    } catch (NumberFormatException e) 
									    {
									       System.out.println("Invalid Input");
									    }
							      	}
							
									
								}
								
								
									
								mutualFundsAdd.get(x).price = updated;
							}
							
							else if(choice.charAt(0) == 'Q' || choice.charAt(0) == 'q')
							{	
								break;
							}
					
						
					}
					
		
				}
				
				/*
				*User-defined function to generic data by adding  all gained fees from all the mutualFunds in list.

				 *@pre user defined arrayList for type Stocks, user defined arrayList for type Mutual Funds

				 *@param MutualFund arrayList.

				 *@param amountGained  ArrayList.

				* *@return double total amount gained for MutualFund list */ 
				
				
				
				public static Double MutualFundsGained(ArrayList<MutualFund> mutualFundsAdd, ArrayList<Double> amountGainedm)
				{
					
					double totalGained = 0.0;
					int G = 0;
					double amountGain = 0.0;
					double comm = 45.00;
					
					
					
					
					for(int x = 0; x<mutualFundsAdd.size(); x++)
					{

						amountGain = ((mutualFundsAdd.get(x).sharesNum * mutualFundsAdd.get(x).price) - comm) - mutualFundsAdd.get(x).bookValue;
				
						amountGainedm.add(G, amountGain);
						
						totalGained = totalGained +	amountGainedm.get(G);
						
						G++;
					
					}
					
					return totalGained;
					
				
					
					
					
				}
	
				
				
				/*
				*User-defined function to represent object MutualFund in a textualized format.

				 *@pre user defined object Stock

				* *@return type object 
				* */ 
				
				
	
	public String toString()

	{

		String Data1= "Symbol:"+ this.symbol+"\n"+"Name:"+ this.Name +"\n";
		String Data3= "Number of Shares:"+ this.sharesNum + "\n";
		String Data8= "Price:"+ this.price+ "\n";
		String Data9="Book Value:"+this.bookValue;
		
		String Data= Data1+Data3+ Data8+ Data9+ "\n";
			
		return Data;

	}


	
	

}
