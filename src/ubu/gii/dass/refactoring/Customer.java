package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			Movie movie = each.getMovie();
			// determine amounts for each line
			double amount = each.amount();
			frequentRenterPoints += each.points();
			
			// show figures for this rental
			result += "\t" + movie.getTitle() + "\t"
					+ amount + "\n";
			
			totalAmount += amount;
		}
		
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints
				+ " frequent renter points";
		return result;
	}
	
	public String HTMLstatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "<h1>Rental Record for " + getName() + "</h1>\n";
		
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			Movie movie = each.getMovie();
			// determine amounts for each line
			double amount = each.amount();
			frequentRenterPoints += each.points();
			
			// show figures for this rental
			result += "<h2>" + movie.getTitle() + " "
					+ amount + "</h2>\n";
			
			totalAmount += amount;
		}
		
		// add footer lines
		result += "<p>Amount owed is " + totalAmount + "</p>\n";
		result += "<p>You earned " + frequentRenterPoints
				+ " frequent renter points</p>";
		return result;
	}
}
