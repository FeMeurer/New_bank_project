package de.telekom.sea7.impl.view;

import java.time.LocalDateTime;
import java.util.Scanner;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.impl.model.TransactionImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;
import de.telekom.sea7.inter.view.TransactionListView;
import de.telekom.sea7.inter.view.TransactionView;

public class TransactionListViewImpl extends BaseObjectImpl implements TransactionListView {
	
	private TransactionList transactionList;
	private Scanner scanner;
	
	public TransactionListViewImpl(Object parent, Scanner scanner, TransactionList transactionList) {
		super(parent);
		this.transactionList = transactionList;
		this.scanner = scanner;
	}
	
	@Override
	public void add() {
		System.out.println("Enter receiver: ");
		String receiver = this.scanner.nextLine();
		
		System.out.println("Enter IBAN: ");
		String iban = this.scanner.nextLine();
		
		System.out.println("Enter BIC: ");
		String bic = this.scanner.nextLine();
		
		System.out.println("Enter purpose: ");
		String purpose = this.scanner.nextLine();
		
		System.out.println("Enter amount: ");
		while(!this.scanner.hasNextFloat()) {
			System.out.println("Your entered value");
			this.scanner.next();
		}
		Float amount = this.scanner.nextFloat();
		this.scanner.nextLine();
		
		LocalDateTime date = LocalDateTime.now();
		Transaction transaction = new TransactionImpl(this, amount, receiver, iban, bic, purpose, date);
		transactionList.add(transaction);
		//scanner.close();
	}

	@Override
	public void remove() {
		System.out.println("Enter position number of transaction: ");
		int position = this.scanner.nextInt();
		transactionList.remove(position);
		//scanner.close();
	}
	
	//show
	@Override
	public void show() {
		if (transactionList.size() > 0) { 
			for (Object o : transactionList) {
				Transaction transaction = (Transaction)o;
				TransactionView transactionView = new TransactionViewImpl(this, this.scanner, transaction);
				System.out.println("Position: " + transactionList.getIndex(transaction));
				transactionView.show();
				System.out.println();
			}
		}
		else {
			System.out.println("No entries");
		}
		//scanner.close();
	}
	
	//showOne
	@Override
	public void showOne() {
		System.out.println("Enter position number of transaction: ");
		int index = this.scanner.nextInt();
		
		if (index < 0 || index > transactionList.size() - 1) {
			System.out.println("Specified entry does not belong to a transaction.");
		}
		else {
			TransactionView transactionView = new TransactionViewImpl(this, this.scanner, transactionList.getTransaction(index));
			transactionView.menu();
		}
		//scanner.close();
	}
	
	//amount
	@Override
	public void balance() {
		System.out.println("Your Balance is: " + String.format("%.2f", transactionList.getBalance()) + " €");
	}
	
	public void exportCsv() {
		System.out.println("Enter Filename: ");
		String fileName = this.scanner.nextLine();
		if (!fileName.endsWith(".csv")) {
			fileName = fileName + ".csv";
		}
		transactionList.exportCsv(fileName);
	}
	
	public void importCsv() {
		System.out.println("Enter Filename: ");
		String fileName = this.scanner.nextLine();
		if (!fileName.endsWith(".csv")) {
			fileName = fileName + ".csv";
		}
		transactionList.importCsv(fileName);
	}
	
	//menu
	@Override
	public void menu() {
		String input = "";
		while (!input.equals("exit")) {
			System.out.println("Enter show, showOne, balance, add, remove, import, export or exit to navigate.");
			System.out.println("Enter something:");
			input = this.scanner.next();
			this.scanner.nextLine();
			switch (input) {
				case "show":
					show();
					break;
				case "showOne":
					showOne();
					break;
				case "balance":
					balance();
					break;
				case "add":
					add();
					break;
				case "remove":
					remove();
					break;
				case "export":
					exportCsv();
					break;
				case "import":
					importCsv();
					break;
				case "exit":
					break;
				default:
					System.out.println("Command unknown");
			}
		}
		//menuScanner.close();
	}
}
