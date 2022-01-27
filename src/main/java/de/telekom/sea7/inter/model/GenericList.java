package de.telekom.sea7.inter.model;

import java.util.Iterator;

public interface GenericList<T> extends Iterable<T> {

	T getOneObject(int index) throws IndexOutOfBoundsException;

	void add(T tObject);

	void remove(int index) throws IndexOutOfBoundsException;

	void remove(T tObject);

	int size();

	int getIndex(T tObject);

	Iterator<T> iterator();

	boolean checkIndex(int index);

}