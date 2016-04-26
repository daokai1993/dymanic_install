package com.dk.secure;

import java.io.File;


/*
 * ¼ÓÔØÊ±ºòµÄListener
 */
public class LoadListener {
	
	public boolean isListener = false ;
	
	public LoadListener(){
		
	}

	public boolean isListening(){
		return isListener ;
	}
	
	public boolean checkResource(String path , String jarOrDex){
		File file = new File(path + File.separator +jarOrDex) ;
		if(file.exists()){
			return true ;
		}
		return false ;
		
	}
	
	public void startListen(){
		isListener = true ;
	}
	
	public void onListening(){
		
	}
	
	public void finishListen(){
		isListener = false ;
	}

}