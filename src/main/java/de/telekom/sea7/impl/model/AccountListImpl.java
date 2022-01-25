package de.telekom.sea7.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Account;
import de.telekom.sea7.inter.model.AccountList;

public class AccountListImpl extends BaseObjectImpl implements Iterable, AccountList {

	private List accountList;
	
	public AccountListImpl(Object parent) {
		super(parent);
		accountList = new ArrayList();
	}
	
	@Override
	public Account getAccount(int index) {
		return (Account)this.accountList.get(index);
	}

	@Override
	public void add(Account account) {
		this.accountList.add(account);
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index > this.accountList.size() - 1) {
			System.out.println("Specified entry does not belong to a transaction.");
		}
		else {
			this.accountList.remove(index);	
		}	
	}
	
	@Override
	public void remove(Account account) {
		this.accountList.remove(accountList);
	}
	
	@Override
	public int size() {
		return this.accountList.size();
	}
	
	@Override
	public int getIndex(Account account) {
		return this.accountList.indexOf(account);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return accountList.iterator();
	}
}
