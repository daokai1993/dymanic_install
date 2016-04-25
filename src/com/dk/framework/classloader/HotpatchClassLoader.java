package com.dk.framework.classloader;

import java.lang.reflect.Field;
import java.util.List;

import dalvik.system.DexClassLoader;

public class HotpatchClassLoader extends DexClassLoader{

	public HotpatchClassLoader(String dexPath, String optimizedDirectory,
			String libraryPath, ClassLoader parent) {
		super(dexPath, optimizedDirectory, libraryPath, parent);
	}
	
	public List<?> getPathList() throws Exception{
		Object classloader = this.getClass().getClassLoader().loadClass("dalvik.system.DexClassLoader") ;
		Field field = classloader.getClass().getDeclaredField("pathList") ;
		return (List<?>)field.get(classloader) ;
	}

}
