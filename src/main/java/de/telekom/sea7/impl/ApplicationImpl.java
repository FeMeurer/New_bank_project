package de.telekom.sea7.impl;

import de.telekom.sea7.impl.model.TransactionListImpl;
import de.telekom.sea7.impl.view.TransactionListViewImpl;
import de.telekom.sea7.inter.model.TransactionList;
import de.telekom.sea7.inter.view.TransactionListView;

public class ApplicationImpl extends BaseObjectImpl implements Application{
	
	public ApplicationImpl(Object parent) {
		super(parent);
	}
	
	@Override
	public void run() {
		TransactionList transactionList = new TransactionListImpl(this);
		TransactionListView transactionListView = new TransactionListViewImpl(this, transactionList);
		transactionListView.menu();
	}
}
