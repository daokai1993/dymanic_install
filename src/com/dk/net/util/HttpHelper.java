package com.dk.net.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.dk.util.LogFactory;

//网络访问类
public class HttpHelper {
	
	private static final String BASEURL = "http://localhost" ;
	
	private static void toJson(String json){
		
	}
	
	//get请求
	public static String doGet(Request request){
		StringBuffer sb = null;
		HttpClient client = new DefaultHttpClient() ;
		HttpGet get = new HttpGet(BASEURL + request.toTail()) ;
		try{
			HttpResponse response = client.execute(get) ;			//进行网络请求
			if(response.getEntity()!=null){
				BufferedReader in = 
						new BufferedReader(new InputStreamReader(
								response.getEntity().getContent()));
				String temp ;
				sb = new StringBuffer();  
				while ((temp = in.readLine()) != null) {
					LogFactory.v("2333333", "" + temp) ;
	                sb.append(temp);  
	            }
				toJson(sb.toString()) ;			//将字符串转为JSON
	            in.close();
	            return sb.toString() ; 
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	//post请求
	public static String doPost(Request request){
		try{ 
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(BASEURL);
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			Map<String , ?> map = request.toMap() ;
			for(String s : map.keySet()){
				BasicNameValuePair param = new BasicNameValuePair(s , map.get(s).toString());
				paramList.add(param);
			}

			post.setEntity(new UrlEncodedFormEntity(paramList,HTTP.UTF_8)); 
			HttpResponse httpResponse = httpClient.execute(post); 
			if(httpResponse.getStatusLine().getStatusCode() == 200){ 
				String result = EntityUtils.toString(httpResponse.getEntity());
				LogFactory.d("HttpHelper", result) ;
				return result ;
			} 
		}catch(Exception e){
			e.printStackTrace() ;
		} 
		return null ;
	}

}