package com.dk.framework.biz;

import android.content.Context;
import android.view.View;

import com.dk.framework.dao.Dao;

public interface Business {
	
	public Object query() ;
	
	public View getView(Context context) ;
	
	public Dao getDao() ;
	
	public void onCreate() ;
	
	public void onStart() ;
	
	public void onResume() ;
	
	public void onPause() ;
	
	public void onStop() ;
	
	public void onFinish() ;
	
	public void onReStart() ;

}
