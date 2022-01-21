package de.telekom.sea7.inter.model;

import java.util.Iterator;

public interface AccountList extends Iterable {
	
	Account getAccount(int index);

	void add(Account account);

	void remove(int index);

	void remove(Account account);

	int size();

	int getIndex(Account account);

	Iterator iterator();

}