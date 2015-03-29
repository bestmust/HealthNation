package com.example.asyncTask;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;

import com.example.datamodels.LoginModel;
import com.example.datamodels.serialized.LoginResponse;
import com.example.patient.R;
import com.example.util.Constants;
import com.example.patient.Login;
import com.google.gson.Gson;

public class LoginTask extends AsyncTask<LoginModel, String, String> {

	Activity mLogin;
	ProgressDialog pd;
	String jsonResponseString;
	LoginModel objLoginModel;
	SharedPreferences sp;

	public LoginTask(Login login) {
		mLogin = login;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Log.d("response json is ", "" + result);
		pd.dismiss();
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pd = new ProgressDialog(mLogin);
		pd.setMessage("Please wait while we are signing you in..");
		pd.setTitle("Signing in");
		pd.setCancelable(false);
		pd.show();
	}

	@Override
	protected String doInBackground(LoginModel... params) {

		objLoginModel = params[0];

		Log.d("username", "" + objLoginModel.getUserName());
		Log.d("password", "" + objLoginModel.getPassword());

		Gson gson = new Gson();
		String request = gson.toJson(params[0]);
		Log.d("gson is", "" + request);

		HttpResponse response;

		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();

		// Creating HttpPost
		// Modify your url
		HttpPost httpPost = new HttpPost(Constants.SERVER_URL
				+ "/android_api/doctor.php");

		Log.d("Call to servlet", "Call servlet");

		// Building post parameters, key and value pair
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("tag", "login"));
		nameValuePair.add(new BasicNameValuePair("email", objLoginModel
				.getUserName()));
		nameValuePair.add(new BasicNameValuePair("password", objLoginModel
				.getPassword()));

		Log.d("cac", "NameValuePair" + nameValuePair);
		// Url Encoding the POST parameters
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		} catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}
		try {

			System.out.println("Executing...");
			response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			jsonResponseString = EntityUtils.toString(entity);
			// Log.d("Http Response:",jsonResponseString);

		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResponseString;
	}

}
