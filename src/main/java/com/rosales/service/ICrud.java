package com.rosales.service;

import java.util.List;

public interface ICrud<T, V> {

	T create(T obj);
	T update(T obj);
	List<T> list();
	boolean delete(V id);
}
