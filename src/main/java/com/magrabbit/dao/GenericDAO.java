package com.magrabbit.dao;

import java.io.Serializable;

public interface GenericDAO<T, K extends Serializable> {
	void insertOrUpdate(T entity);
	void delete(T entity);
}
