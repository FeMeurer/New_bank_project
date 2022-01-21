package de.telekom.sea7.impl.view;

import java.time.LocalDateTime;
import java.util.Scanner;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.impl.model.AccountImpl;
import de.telekom.sea7.impl.model.TransactionImpl;
import de.telekom.sea7.inter.model.Account;
import de.telekom.sea7.inter.model.AccountList;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.view.AccountListView;
import de.telekom.sea7.inter.view.AccountView;
import de.telekom.sea7.inter.view.TransactionView;

public class AccountListViewImpl extends BaseObjectImpl implements AccountListView {

	private AccountList accountList;
	
	public AccountListViewImpl(Object parent, AccountList accountList) {
		super(parent);
		this.accountList = accountList;
	}
	
	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter account type: ");
		String type = scanner.nextLine();
		
		System.out.println("Enter IBAN: ");
		String iban = scanner.nextLine();
		
		System.out.println("Enter BIC: ");
		String bic = scanner.nextLine();

		Account account = new AccountImpl(this, name, type, iban, bic);
		accountList.add(account);
		//scanner.close();
	}

	@Override
	public void remove() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter position number of account: ");
		int position = scanner.nextInt();
		accountList.remove(position);
		//scanner.close();
	}
	
	//show
	@Override
	public void show() {
		Scanner scanner = new Scanner(System.in);
		if (accountList.size() > 0) { 
			for (Object o : accountList) {
				Account account = (Account)o;
				AccountView accountView = new AccountViewImpl(this, account);
				System.out.println("Position: " + accountList.getIndex(account));
				accountView.show();
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
		System.out.println("Enter position number of account: ");
		int index = scanner.nextInt();
		
		if (index < 0 || index > accountList.size() - 1) {
			System.out.println("Specified entry does not belong to an account.");
		}
		else {
			AccountView accountView = new AccountViewImpl(this, accountList.getAccount(index));
			accountView.menu();
		}
		//scanner.close();
	}
	
	//menu
	@Override
	public void menu() {
		String input = "";
		Scanner menuScanner = new Scanner(System.in);
		while (!input.equals("exit")) {
			System.out.println("Enter show, showOne, add, remove or exit to navigate.");
			System.out.println("Enter something:");
			input = menuScanner.next();
			switch (input) {
				case "show":
					show();
					break;
				case "showOne":
					showOne();
					break;
				case "add":
					add();
					break;
				case "remove":
					remove();
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
