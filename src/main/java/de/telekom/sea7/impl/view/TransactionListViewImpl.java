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
	
	public TransactionListViewImpl(Object parent, TransactionList transactionList) {
		super(parent);
		this.transactionList = transactionList;
	}
	
	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter receiver: ");
		String receiver = scanner.nextLine();
		
		System.out.println("Enter IBAN: ");
		String iban = scanner.nextLine();
		
		System.out.println("Enter BIC: ");
		String bic = scanner.nextLine();
		
		System.out.println("Enter purpose: ");
		String purpose = scanner.nextLine();
		
		System.out.println("Enter amount: ");
		while(!scanner.hasNextFloat()) {
			System.out.println("Your entered value");
			scanner.next();
		}
		Float amount = scanner.nextFloat();
		scanner.nextLine();
		
		LocalDateTime date = LocalDateTime.now();
		Transaction transaction = new TransactionImpl(this, amount, receiver, iban, bic, purpose, date);
		transactionList.add(transaction);
		//scanner.close();
	}

	@Override
	public void remove() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter position number of transaction: ");
		int position = scanner.nextInt();
		transactionList.remove(position);
		//scanner.close();
	}
	
	//show
	@Override
	public void show() {
		Scanner scanner = new Scanner(System.in);
		if (transactionList.size() > 0) { 
			for (Object o : transactionList) {
				Transaction transaction = (Transaction)o;
				TransactionView transactionView = new TransactionViewImpl(this, transaction);
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter position number of transaction: ");
		int index = scanner.nextInt();
		
		if (index < 0 || index > transactionList.size() - 1) {
			System.out.println("Specified entry does not belong to a transaction.");
		}
		else {
			TransactionView transactionView = new TransactionViewImpl(this, transactionList.getTransaction(index));
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Filename: ");
		String fileName = scanner.nextLine();
		if (!fileName.endsWith(".csv")) {
			fileName = fileName + ".csv";
		}
		transactionList.exportCsv(fileName);
	}
	
	public void importCsv() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Filename: ");
		String fileName = scanner.nextLine();
		if (!fileName.endsWith(".csv")) {
			fileName = fileName + ".csv";
		}
		transactionList.importCsv(fileName);
	}
	
	//menu
	@Override
	public void menu() {
		String input = "";
		Scanner menuScanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out.println("Enter show, showOne, balance, add, remove, import, export or exit to navigate.");
			System.out.println("Enter something:");
			input = menuScanner.next();
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
