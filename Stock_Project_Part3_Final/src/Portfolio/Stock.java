package Portfolio;


import java.io.IOException;
import java.util.ArrayList;

public class Stock extends Investment {

	public Stock(String compSymbol, String compName, int shares, double stockPrice, double book) {

		super(compSymbol, compName, shares, stockPrice, book);

	}

	public Stock(Investment oldStock) {

		super(oldStock);

	}

	
	/**
	 * Abstract User-defined function to generic data by editing updated
	 * Investments with their respected calculations.
	 * 
	 * @pre user defined arrayList for type Investment
	 * 
	 * @param Investment ArrayList.
	 * 
	 * @param String choiceSymbol.
	 * 
	 * @param String compName.
	 * 
	 * @param int numShares.
	 * 
	 * @param double newPrice.
	 * 
	 * @return void
	 */

	public void CalculateFunds(ArrayList<Investment> investAdd, String choiceSymbol, String compName,
			int numShares, double newPrice) throws NumberFormatException, IOException {

		FirstWindow.textBuy.setText("");

		double comm = 9.99;
		int present = 0;

		for (int x = 0; x < investAdd.size(); x++) // keep
		{
			if (choiceSymbol.equals(investAdd.get(x).symbol)) {
				if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.MutualFund")) {

					FirstWindow.textBuy.append("Sorry, this investment already exists in your Mutual Funds List\n");

					present = 1;

				}
			}

		}

		for (int x = 0; x < investAdd.size(); x++) // keep
		{

			if (choiceSymbol.equals(investAdd.get(x).symbol)) {

				if (investAdd.get(x).getClass().getCanonicalName().equals("Portfolio.Stock")) {

					present = 1;

					FirstWindow.textBuy.append("**Note: this investment already exists in your Stock List (updated)\n");
					FirstWindow.textBuy.append("\n");

					investAdd.get(x).price = newPrice;

					investAdd.get(x).sharesNum = investAdd.get(x).sharesNum + numShares;

					investAdd.get(x).bookValue = investAdd.get(x).bookValue +

							(((investAdd.get(x).price) * numShares) + comm);

					// prints
					for (int i = 0; i < investAdd.size(); i++) {
						FirstWindow.textBuy.append(investAdd.get(i).toString() + "\n");
					}

				}

			}

		}

		if (present != 1)// if symbol doesn't exsit
		{

			FirstWindow.textBuy.append("Added:\n");

			AddingNew(investAdd, choiceSymbol, compName, numShares, newPrice);
		}

	}

	/**
	 * Abstract User defined function which is only responsible for adding new investments (not updating them)
	 * 
	 * @param ArrayList<Investment> investAdd
	 * @param String choiceSymbol
	 * @param String compName
	 * @param Integer numShares
	 * @param Double newPrice
	 */
	
	public void AddingNew(ArrayList<Investment> investAdd, String choiceSymbol, String compName, int numShares,
			double newPrice) {
		{

			double comm = 9.99;
			double value = 0.0;
			int holdShares = 0;
			int count = 0;

			Stock temp = new Stock(choiceSymbol, compName, 0, newPrice, 0.0);
			
			//creating cloned Objects of type Stock
			Stock clonedTemp = new Stock(temp);
			
			investAdd.add(count, clonedTemp);

			holdShares = holdShares + numShares;

			investAdd.get(count).sharesNum = holdShares;

			value = (investAdd.get(count).price) * (investAdd.get(count).sharesNum);

			value = value + comm;

			
			
			investAdd.get(count).bookValue = value;

			value = 0;

			holdShares = 0;

			count++;

		}

		for (int x = 0; x < investAdd.size(); x++) {
			FirstWindow.textBuy.append(investAdd.get(x).toString() + "\n");
		}

	}

	/**
	 * Abstract user-defined function that calculates Revenue (Payment) when user sells an
	 * Investment.
	 * 
	 * @param ArrayList<Investment> investAdd
	 * @param String choiceSymbol
	 * @param  int shareLoss
	 */
	
	public void Payment(ArrayList<Investment> investAdd, String choiceSymbol, int shareLoss) {
		
		double comm = 9.99;
		double revenueGained = 0.0;

		for (int x = 0; x < investAdd.size(); x++) {
			
			if (choiceSymbol.equals(investAdd.get(x).symbol)) {
			
				if (shareLoss <= investAdd.get(x).sharesNum) {
					
					revenueGained = ((shareLoss * investAdd.get(x).price) - comm);

					FirstWindow.textSell.append("Revenue Received: $" + revenueGained + "\n");
					FirstWindow.textSell.append("\n");

				}

			}

		}

		
	}

	
	/**
	 * User-defined function to represent object Stock in a textualized format.
	 * 
	 * @pre user defined object Investment
	 * 
	 * @return type object
	 */

	public String toString()

	{

		String Data1 = "Symbol:" + this.symbol + "\n" + "Name:" + this.Name + "\n";
		String Data3 = "Number of Shares:" + this.sharesNum + "\n";
		String Data8 = "Price:" + this.price + "\n";
		String Data9 = "Book Value:" + this.bookValue;

		String Data = Data1 + Data3 + Data8 + Data9 + "\n";

		return Data;

	}

	/**
	 * User-defined function to compare 2 objects and check if they are equal.
	 * 
	 * @pre user defined object Investment
	 * 
	 *@return type boolean
	 */

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Investment other = (Investment) obj;

		if (Double.compare(this.bookValue, other.bookValue) == 0 && Double.compare(this.price, other.price) == 0
				&& Integer.compare(this.sharesNum, other.sharesNum) == 0 && this.symbol.equalsIgnoreCase(other.symbol)
				&& this.Name.equalsIgnoreCase(other.Name)) {
			return true;
		}
		return false;
	}

}
