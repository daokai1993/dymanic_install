package com.dk.framework.dao;

public interface Dao {
	public Object query(String tableName , String ...param) ;
	public boolean add(String tableName , String ...param) ;
	public boolean delete(String tableName , String ... param) ;
	public boolean update(String tableName , String ...param) ;
}
