package com.dk.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences�Ĳ�����
 * @author DK
 *
 */
public class SharedPreferecedHelper {
	
	private static SharedPreferences sp = null;
	
	private static void getSharedPrefereced(Context context){
		if(sp == null){
			sp = context.getSharedPreferences(Constants.spName , Activity.MODE_PRIVATE) ;
		}
	}
	
	//����sp����
	public void insert(Context context , String key , String value){
		getSharedPrefereced(context) ;
		sp.edit().putString(key, value).commit() ;
	}
	
	//ɾ��sp����
	public void delete(Context context , String key){
		getSharedPrefereced(context) ;
		sp.edit().remove(key).commit() ;
	}
	
	//��ѯsp����
	public String query(Context context , String key){
		getSharedPrefereced(context) ;
		return sp.getString(key , "0") ;
		
	}

}
