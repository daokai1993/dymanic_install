package com.dk.framework.classloader;

public class ClassLoaderManager {
	HotpatchClassLoader classloader ;
	private static ClassLoaderManager manager ;
	
	private ClassLoaderManager(){
//		classloader = new 
	}
	
	public static ClassLoaderManager getInstancedClassLoaderManager(){
		if(manager == null){
			manager = new ClassLoaderManager() ;
		}
		return manager ;
	}

}
