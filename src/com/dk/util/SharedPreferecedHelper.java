package com.dk.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences的操作类
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
	
	//插入sp数据
	public void insert(Context context , String key , String value){
		getSharedPrefereced(context) ;
		sp.edit().putString(key, value).commit() ;
	}
	
	//删除sp数据
	public void delete(Context context , String key){
		getSharedPrefereced(context) ;
		sp.edit().remove(key).commit() ;
	}
	
	//查询sp数据
	public String query(Context context , String key){
		getSharedPrefereced(context) ;
		return sp.getString(key , "0") ;
		
	}

}
