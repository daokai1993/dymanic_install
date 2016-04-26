package com.dk.framework;

import java.io.File;
import com.dk.framework.biz.Business;
import com.dk.framework.classloader.HotpatchClassLoader;
import com.dk.secure.LoadListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.RelativeLayout;

public class BaseActivity extends Activity{
	
	protected RelativeLayout view ;
	protected HotpatchClassLoader classLoader ;
	String classPath , jarOrDex;
	protected Business biz ;
	protected LoadListener listener;

	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState) ;
		listener = new LoadListener() ;
		if(biz != null ){
			biz.onCreate() ;
		}
	}

	public void setClassPathAndJar(String classPath , String jarOrDex){
		this.classPath = classPath ;
		this.jarOrDex = jarOrDex ;
	}
	
	public void init(){
		if(classPath !=null && jarOrDex!=null){
			if(!listener.checkResource(classPath, jarOrDex)){
				return ;
			}
			listener.startListen() ;
			initClassLoader() ;
		}
	}
 
	private void initClassLoader(){
		File optimizedDexOutputPath = new File(Environment.getExternalStorageDirectory() + 
				File.separator + jarOrDex);
		classLoader = new HotpatchClassLoader(optimizedDexOutputPath.getAbsolutePath(),
	        		this.getDir("dex", 0).getAbsolutePath() , null, getClassLoader());
		try {
			Class<?> clazz = classLoader.loadClass(classPath) ;
			biz = (Business) clazz.newInstance() ;
		} catch (Exception e) {
			//init class failed
			e.printStackTrace();
		}finally{
			listener.finishListen() ;
		}
	 }
	

}
