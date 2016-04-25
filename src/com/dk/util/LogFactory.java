package com.dk.util;

import android.util.Log;

public class LogFactory {
	
	public static boolean logSwitch = true;
	
	public static void v(String tag , String content){
		if(logSwitch == true){
			Log.v(tag, content) ;
		}
	}
	
	public static void d(String tag , String content){
		if(logSwitch == true){
			Log.d(tag, content) ;
		}
	}
	
	public static void i(String tag , String content){
		if(logSwitch == true){
			Log.i(tag, content) ;
		}
	}
	
	public static void e(String tag , String content){
		if(logSwitch == true){
			Log.e(tag, content) ;
		}
	}
	
	public static void w(String tag , String content){
		if(logSwitch == true){
			Log.w(tag, content) ;
		}
	}

}
