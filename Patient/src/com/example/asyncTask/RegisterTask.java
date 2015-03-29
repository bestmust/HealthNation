package com.example.asyncTask;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.dataModel.RegisterModel;
import com.example.patient.Login;
import com.example.util.Constants;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

public class RegisterTask extends AsyncTask<RegisterModel, String, String>{

	Activity _login;
	ProgressDialog pd;
	String jsonResposnseString;
	
	
	public RegisterTask(Login login) {
		_login  = login;
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	//	pd.dismiss();
		
		
		/*
		 * mainpulate this flow that user can navigate to proper activity.
		 * Use intent bleow to navigate
		 */
		
		/*Intent objintent= new  Intent(_login,Login.class);
		_login.startActivity(objintent);*/

	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pd =new ProgressDialog(_login);
		pd.setMessage("Please Wait..");
		pd.setCancelable(false);
	//	pd.show();
	}

	@Override
	protected String doInBackground(RegisterModel... params) {
		// TODO Auto-generated method stub


		Gson objGson = new Gson();
		String request  = objGson.toJson(params[0]);

		HttpResponse response;

		//Creating Http client
		HttpClient httpclient = new DefaultHttpClient();

		//Building post parametrs key and value pair

		//------Modify your server url in Constants in util package-------

		HttpPost httpPost = new HttpPost(Constants.SERVER_URL+"/urc2");		
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("jsondata", request));

		//URl Encoding the POST parametrs

		try{

			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		}
		catch(Exception e){
			e.printStackTrace();
		}

		//making http request
		try{
			System.out.println("Executing");
			response = httpclient.execute(httpPost);
			System.out.println("check response"+response.toString());
			HttpEntity entity= response.getEntity();
			jsonResposnseString = EntityUtils.toString(entity);

			/**
			 * In 'jsonResposnseString' you will get response that you sent form server.
			 * 
			 */
			
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;


	}

}
