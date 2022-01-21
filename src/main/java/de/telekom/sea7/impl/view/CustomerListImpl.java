package de.telekom.sea7.impl.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.impl.model.AccountListImpl;
import de.telekom.sea7.inter.model.AccountList;

public class CustomerListImpl extends BaseObjectImpl {

	private List customerList;
	
	public CustomerListImpl(Object parent) {
		super(parent);
		this.customerList = new ArrayList();
	}
	
	
}
