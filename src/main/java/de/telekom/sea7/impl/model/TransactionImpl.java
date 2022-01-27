package de.telekom.sea7.impl.model;

import java.time.LocalDateTime;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.Transaction;

public class TransactionImpl extends BaseObjectImpl implements Transaction {
	
	private float amount;
	private String receiver; 
	private String iban;
	private String bic;
	private String purpose;
	private LocalDateTime date;
	
	//enum Headers {amount,receiver,iban,bic,purpose,date}
	
	public TransactionImpl(Object parent, float amount, String receiver, String iban, String bic, String purpose, LocalDateTime date) {
		super(parent);
		this.amount = amount;
		this.receiver = receiver;
		this.iban = iban;
		this.bic = bic;
		this.purpose = purpose;
		this.date = date;
	}

	@Override
	public float getAmount() {
		return amount;
	}

	@Override
	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	@Override
	public String getPurpose() {
		return purpose;
	}

	@Override
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
