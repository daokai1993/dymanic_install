package com.dk.dymanicinstall;

import com.dk.framework.BaseActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class Dynamic extends BaseActivity {
	
	RelativeLayout layout ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.setClassPathAndJar("com.dk.dymanicinstall.NewBiz", "dymanic.jar") ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        layout = (RelativeLayout)findViewById(R.id.parent) ;
        super.init() ;
  //      Log.v("activity" , ""+biz.getView(this).toString()) ;
        if(biz == null){
        	biz = new Biz() ; 
        }
        if( biz!=null){
        	layout.removeAllViews() ;
        	
        	layout.addView(biz.getView(this)) ;
        }
    }

}
