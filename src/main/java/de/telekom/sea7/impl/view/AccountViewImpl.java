package de.telekom.sea7.impl.view;

import java.util.Scanner;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Account;
import de.telekom.sea7.inter.model.TransactionList;
import de.telekom.sea7.inter.view.AccountView;
import de.telekom.sea7.inter.view.TransactionListView;

public class AccountViewImpl extends BaseObjectImpl implements AccountView {
	
	private Account account;
	
	public AccountViewImpl(Object parent, Account account) {
		super(parent);
		this.account = account;
	}

	//menu
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
			case "transactions":
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
	
	//editMenu
	@Override
	public void editMenu() {
		String input = "";
		Scanner menuScanner = new Scanner(System.in);
		while (!input.equals("back")) {
			System.out.println("Enter name, type, iban or bic to change the property or back to exit editing menu.");
			System.out.println("Enter something:");
			input = menuScanner.next();
			switch (input) {
			case "name":
				setName();
				break;
			case "iban":
				setIban();
				break;
			case "bic":
				setBic();
				break;
			case "type":
				setType();
				break;
			case "back":
				break;
			default:
				System.out.println("Command unknown");
			}
		}
		//menuScanner.close();
	}
	
	//setName
	@Override
	public void setName() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new account name: ");
		String newEntry = editScanner.nextLine();
		account.setIban(newEntry);
		//editScanner.close();
	}
	
	//setType
	@Override
	public void setType() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new account type: ");
		String newEntry = editScanner.nextLine();
		account.setIban(newEntry);
		//editScanner.close();
	}
	
	//setIban
	@Override
	public void setIban() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new IBAN: ");
		String newEntry = editScanner.nextLine();
		account.setIban(newEntry);
		//editScanner.close();
	}
	
	//setBic
	@Override
	public void setBic() {
		Scanner editScanner = new Scanner(System.in);
		System.out.println("Enter new BIC: ");
		String newEntry = editScanner.nextLine();
		account.setIban(newEntry);
		//editScanner.close();
	}
	
	//show
	@Override
	public void show() {
		System.out.println("Account name: " + account.getName());
		System.out.println("Account type: " + account.getType());
		System.out.println("IBAN: " + account.getIban());
		System.out.println("BIC: " + account.getBic());
		
		TransactionList transactionList = account.getTransactionList();
		System.out.println("Balance: " + String.format("%.2f", transactionList.getBalance()) + " €");
	}
	
	//getTransactionList
	@Override
	public void getTransactionList() {
		TransactionList transactionList = account.getTransactionList();
		TransactionListView transactionListView = new TransactionListViewImpl(this, transactionList);
		transactionListView.menu();
	}
}
