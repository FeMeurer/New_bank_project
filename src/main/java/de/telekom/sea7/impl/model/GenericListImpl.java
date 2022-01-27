package de.telekom.sea7.impl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.telekom.sea7.impl.BaseObjectImpl;
import de.telekom.sea7.inter.model.GenericList;

public class GenericListImpl<T> extends BaseObjectImpl implements Iterable<T>, GenericList<T> {
	
	private List<T> genericList;
	
	public GenericListImpl(Object parent) {
		super(parent);
		genericList = new ArrayList<T>();
	}
	
	@Override
	public T getOneObject(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			return genericList.get(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void add(T tObject) {
		this.genericList.add(tObject);
	}
	
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if (checkIndex(index)) {
			this.genericList.remove(index);
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void remove(T tObject) {
		this.genericList.remove(tObject);
	}
	
	@Override
	public int size() {
		return this.genericList.size();
	}
	
	@Override
	public int getIndex(T tObject) {
		return this.genericList.indexOf(tObject);
	}

	@Override
	public Iterator<T> iterator() {
		return genericList.iterator();
	}
	
	@Override
	public boolean checkIndex(int index) {
		return index >= 0 && index < genericList.size();
	}
}
