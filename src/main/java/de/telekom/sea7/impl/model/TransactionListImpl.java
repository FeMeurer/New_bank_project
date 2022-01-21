package de.telekom.sea7.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Transaction;
import de.telekom.sea7.inter.model.TransactionList;

public class TransactionListImpl extends BaseObjectImpl implements Iterable, TransactionList {
	
	private List transactionList;
	
	public TransactionListImpl(Object parent) {
		super(parent);
		transactionList = new ArrayList();
	}
	
	@Override
	public Transaction getTransaction(int index) {
		return (Transaction)transactionList.get(index);
	}
	
	@Override
	public void add(Transaction transaction) {
		this.transactionList.add(transaction);
	}
	
	@Override
	public void remove(int index) {
		if (index < 0 || index > this.transactionList.size() - 1) {
			System.out.println("Specified entry does not belong to a transaction.");
		}
		else {
			this.transactionList.remove(index);
			
		}
	}
	
	@Override
	public void remove(Transaction transaction) {
		this.transactionList.remove(transaction);
	}
	
	@Override
	public int size() {
		return this.transactionList.size();
	}
	
	@Override
	public int getIndex(Transaction transaction) {
		return this.transactionList.indexOf(transaction);
	}

	@Override
	public Iterator iterator() {
		return transactionList.iterator();
	}
	
	@Override
	public float getBalance() {
		float amount = 0.00f;
		for (Object o : transactionList) {
			Transaction transaction = (Transaction)o;
			amount = amount + transaction.getAmount();
		}
		return amount;
	}
	
}
