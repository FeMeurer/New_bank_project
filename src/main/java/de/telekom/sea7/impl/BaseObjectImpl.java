package de.telekom.sea7.impl;

public class BaseObjectImpl implements BaseObject {
	private int id;
	private Object parent;
	private static int count;
	
	public BaseObjectImpl(Object parent) {
		this.id = count++;
		this.parent = parent;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public Object getParent() {
		return parent;
	}
}
