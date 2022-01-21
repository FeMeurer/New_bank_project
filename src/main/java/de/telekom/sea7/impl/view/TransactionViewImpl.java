package de.telekom.sea7.impl.view;

import java.util.Scanner;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.view.TransactionView;

public class TransactionViewImpl extends BaseObjectImpl implements TransactionView {
	
	private Transaction transaction;
	
	public TransactionViewImpl(Object parent, Transaction transaction) {
		super(parent);
		this.transaction = transaction;
	}
	
	@Override
	public void menu() {
		String input = "";
		Scanner menuScanner = new Scanner(System.in);
		while (!input.equals("back")) {
			System.out.println("Enter show, edit or back to navigate.");
			System.out.println("Enter something:");
			input = menuScanner.next();
			switch (input) {
			case "show":
				show();
				break;
			case "edit":
				editMenu();
				break;
			case "back":
				break;
			default:
				System.out.println("Command unknown");
			}
		}
		//menuScanner.close();
	}
	
	@Override
	public void editMenu() {
		String input = "";
		Scanner menuScanner = new Scanner(System.in);
		while (!input.equals("back")) {
			System.out.println("Enter receiver, iban, bic, purpose, amount to change the property or back to exit editing menu.");
			System.out.println("Enter something:");
			input = menuScanner.next();
			switch (input) {
			case "receiver":
				setReceiver();
				break;
			case "iban":
				setIban();
				break;
			case "bic":
				setBic();
				break;
			case "purpose":
				setPurpose();
				break;
			case "amount":
				setAmount();
				break;
			case "back":
				break;
			default:
				System.out.println("Command unknown");
			}
		}
		//menuScanner.close();
	}
	
	@Override
	public void show() {
		System.out.println("Receiver: " + transaction.getReceiver());
		System.out.println("IBAN: " + transaction.getIban());
		System.out.println("BIC: " + transaction.getBic());
		System.out.println("Purpose: " + transaction.getPurpose());
		System.out.println("Amount: " + String.format("%.2f", transaction.getAmount()) + " €");
		System.out.println("Date: " + transaction.getReceiver());
	}
	
	@Override
	public void setReceiver() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new receiver: ");
		String newEntry = editScanner.nextLine();
		transaction.setReceiver(newEntry);
		//editScanner.close();
	}
	
	@Override
	public void setIban() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new IBAN: ");
		String newEntry = editScanner.nextLine();
		transaction.setIban(newEntry);
		//editScanner.close();
	}
	
	@Override
	public void setBic() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new BIC: ");
		String newEntry = editScanner.nextLine();
		transaction.setBic(newEntry);
		//editScanner.close();
	}
	
	@Override
	public void setPurpose() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new purpose: ");
		String newEntry = editScanner.nextLine();
		transaction.setPurpose(newEntry);
		//editScanner.close();
	}
	
	@Override
	public void setAmount() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new amount: ");
		Float newEntry = editScanner.nextFloat();
		transaction.setAmount(newEntry);
		//editScanner.close();
	}
}
