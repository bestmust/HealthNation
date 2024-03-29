package com.example.asyctask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.datamodels.PatientsParameterModel;
import com.google.gson.Gson;

public class SavePrescriptionTask extends
		AsyncTask<PatientsParameterModel, String, String> {

	Activity _savePerscription;
	ProgressDialog pd;
	String jsonResponseString;

	public SavePrescriptionTask(Activity activity) {
		_savePerscription = activity;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pd = new ProgressDialog(_savePerscription);
		pd.setMessage("Please Wait..");
		pd.setCancelable(false);
		// pd.show();
	}

	@Override
	protected String doInBackground(PatientsParameterModel... params) {

		PatientsParameterModel objParameterModel = params[0];

		Log.d("id", "" + objParameterModel.getPatientsId());
		Log.d("date", "" + objParameterModel.getTreatmentDate());

		Gson gson = new Gson();
		String request = gson.toJson(objParameterModel);
		Log.d("gson is", "" + request);

		HttpResponse response;

		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();

		// Creating HttpPost
		// Modify your url
		/*
		 * HttpPost httpPost = new HttpPost(Constants.SERVER_URL
		 * +"/controllername");
		 * 
		 * Log.d("Call to servlet", "Call servlet");
		 * 
		 * // Building post parameters, key and value pair List<NameValuePair>
		 * nameValuePair = new ArrayList<NameValuePair>(2);
		 * nameValuePair.add(new BasicNameValuePair("jsondata", request));
		 * 
		 * Log.d("cac", "NameValuePair"+nameValuePair); // Url Encoding the POST
		 * parameters try { httpPost.setEntity(new
		 * UrlEncodedFormEntity(nameValuePair)); } catch
		 * (UnsupportedEncodingException e) { // writing error to Log
		 * e.printStackTrace(); } try {
		 * 
		 * System.out.println("Executing..."); response =
		 * httpClient.execute(httpPost);
		 * 
		 * HttpEntity entity = response.getEntity(); jsonResponseString =
		 * EntityUtils.toString(entity);
		 * Log.d("Http Response:",jsonResponseString);
		 * 
		 * }catch (ClientProtocolException e) { // writing exception to log
		 * e.printStackTrace();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return jsonResponseString;
	}

}
