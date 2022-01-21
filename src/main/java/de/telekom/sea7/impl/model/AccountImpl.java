package de.telekom.sea7.impl.model;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Account;
import de.telekom.sea7.inter.model.TransactionList;

public class AccountImpl extends BaseObjectImpl implements Account {

	private String name;
	private String type;
	private String iban;
	private String bic;
	private TransactionList transactionList;
	
	public AccountImpl(Object parent, String name, String type, String iban, String bic) {
		super(parent);
		this.name = name;
		this.type = type;
		this.iban = iban;
		this.bic = bic;
		transactionList = new TransactionListImpl(this);
	}

	@Override
	public TransactionList getTransactionList() {
		return transactionList;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getIban() {
		return iban;
	}

	@Override
	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String getBic() {
		return bic;
	}

	@Override
	public void setBic(String bic) {
		this.bic = bic;
	}
}
