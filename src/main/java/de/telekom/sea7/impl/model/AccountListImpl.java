package de.telekom.sea7.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Account;
import de.telekom.sea7.inter.model.AccountList;
import de.telekom.sea7.inter.model.Transaction;

public class AccountListImpl extends BaseObjectImpl implements Iterable, AccountList {

	private List accountList;
	
	public AccountListImpl(Object parent) {
		super(parent);
		accountList = new ArrayList();
	}
	
	@Override
	public Account getAccount(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			return (Account)this.accountList.get(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void add(Account account) {
		this.accountList.add(account);
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			this.accountList.remove(index);	
		}
		else {
			throw new IndexOutOfBoundsException();
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
	
	public boolean checkIndex(int index) {
		return index >= 0 && index < accountList.size();
	}
}
