package com.dk.dymanicinstall;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.dk.framework.biz.Business;
import com.dk.framework.dao.Dao;

public class Biz implements Business {

	public Object query() {
		return null;
	}

	public View getView(Context context) {
		Button btn = new Button(context) ;
		btn.setText("xx") ;
		return btn;
	}

	public Dao getDao() {
		return null;
	}

	public void setListener() {

	}

	public void onCreate() {
		
	}

	public void onStart() {
		
	}

	public void onResume() {
		
	}

	public void onPause() {
		
	}

	public void onStop() {
		
	}

	public void onFinish() {
		
	}

	public void onReStart() {
		
	}

}
