package de.telekom.sea7.inter.model;

public interface Account {

	GenericList<Transaction> getTransactionList();

	String getName();

	void setName(String name);

	String getType();

	void setType(String type);

	String getIban();

	void setIban(String iban);

	String getBic();

	void setBic(String bic);

}