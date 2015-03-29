package com.example.patient;

import java.util.concurrent.ExecutionException;

import com.erxproject.erx.model.Doctor;
import com.example.asyctask.RegistrationTask;
import com.example.asyncTask.ForgotPasswordTask;
import com.example.asyncTask.LoginTask;
import com.example.asyncTask.RegisterTask;
import com.example.dataModel.RegisterModel;
import com.example.datamodels.LoginModel;
import com.example.datamodels.serialized.LoginResponse;
import com.example.datamodels.serialized.RegistrationResponse;
import com.google.gson.Gson;
import com.example.patient.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends Activity implements OnClickListener {

	EditText mUsername, mPassword,mFirstName,mLastName,mEmailId,mAddress,mContactNo,mpass,muser,mEmailForgot;
	TextView textViewCreateAccount,textViewforgot;
	Button mLogin, mRegister,mLoginRegister,mforgot;
	ImageButton buttonSearch;
	FrameLayout framelLayoutlogin,framelLayoutregister,framLayoutForgot;
	SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_activity_login);

		init();

		textViewCreateAccount.setOnClickListener(this);
		mLoginRegister.setOnClickListener(this);
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
		textViewforgot.setOnClickListener(this);
		mforgot.setOnClickListener(this);
	}

	private void init() {

		mUsername = (EditText)findViewById(R.id.editTextUsernameLogin);
		mPassword = (EditText)findViewById(R.id.editTextPasswordLogin);
		mLogin = (Button)findViewById(R.id.buttonLoginLogin);
		textViewCreateAccount = (TextView)findViewById(R.id.textViewCreate);
		framelLayoutlogin = (FrameLayout)findViewById(R.id.frameLayoutLogin);
		framelLayoutregister=(FrameLayout)findViewById(R.id.frameLayoutRegister); 
		mRegister = (Button)findViewById(R.id.buttonRegister);
		mLoginRegister = (Button)findViewById(R.id.buttonLogin);

		mFirstName = (EditText)findViewById(R.id.editTextFirstName);
		mLastName = (EditText)findViewById(R.id.editTextLastName);
		mEmailId = (EditText)findViewById(R.id.editTextEmailId);
		mContactNo = (EditText)findViewById(R.id.editTextContactNo);
		mAddress = (EditText)findViewById(R.id.editTextAddress);
		mpass = (EditText)findViewById(R.id.editTextPassword);
		muser = (EditText)findViewById(R.id.editTextUserName);
		textViewforgot = (TextView)findViewById(R.id.textViewforgot);
		framLayoutForgot = (FrameLayout)findViewById(R.id.frameLayoutForgot);
		mforgot = (Button)findViewById(R.id.buttonForgot);
		mEmailForgot = (EditText)findViewById(R.id.editTextEmailForgot);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.buttonLoginLogin:

			/*
			 * On Click of login button send parameters to LoginDTO model 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

				if(mUsername.getText().toString().equalsIgnoreCase("") || mPassword.getText().toString().equalsIgnoreCase("")){
					showdialog();
			}

			LoginModel loginModel = new LoginModel();
			loginModel.setPassword((mPassword.getText().toString()));
			loginModel.setUserName((mUsername.getText().toString()));

			AsyncTask<LoginModel, String, String> loginResponse = new LoginTask(Login.this).execute(loginModel);
			try {
				String result = loginResponse.get();
				Gson gson = new Gson();

				LoginResponse response = gson.fromJson(result, LoginResponse.class);

				if (response.success == 1) {
					Intent intent = new Intent(Login.this,HomePage.class);
					startActivity(intent);
					sp = PreferenceManager.getDefaultSharedPreferences(Login.this);
					Editor ed = sp.edit();
					ed.putString(Login.this.getString(R.string.sp_doctor_user_name),
							loginModel.getUserName());
					ed.putString(Login.this.getString(R.string.sp_doctor_password),
							loginModel.getPassword());
					ed.putString(Login.this.getString(R.string.sp_doctor_name),
							response.user.name);
					ed.putInt(Login.this.getString(R.string.sp_doctor_doctor_id),
							response.user.doctor_id);
					ed.apply();

					Doctor d = Doctor.get(Login.this);
					d.setName(response.user.name);
					// mLogin.overridePendingTransition(R.anim.side_down,
					// R.anim.slide_up);
				} else {
					mUsername.setError("Enter valid details");
					mPassword.setError(response.error_msg);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			break;

		case R.id.textViewCreate:

			framelLayoutlogin.setVisibility(View.GONE);
			framelLayoutregister.setVisibility(View.VISIBLE);

			break;
		case R.id.buttonLogin:

			framelLayoutregister.setVisibility(View.GONE);
			framelLayoutlogin.setVisibility(View.VISIBLE);

			break;

		case R.id.buttonRegister:
			/*
			 * On Click of Register button send parameters to RegisterModel 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

			if(mFirstName.getText().toString().equalsIgnoreCase("")){
				showdialog();
			}else if(mLastName.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mEmailId.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mpass.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mContactNo.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(mAddress.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else if(muser.getText().toString().equalsIgnoreCase("")){
				showdialog();

			}else{

				RegisterModel objRegisterModel  =new RegisterModel();
				objRegisterModel.setFirstName(mFirstName.getText().toString());
				objRegisterModel.setLastName(mLastName.getText().toString());
				objRegisterModel.setEmailId(mEmailId.getText().toString());
				objRegisterModel.setPassword(mpass.getText().toString());
				objRegisterModel.setContactNo(mContactNo.getText().toString());
				objRegisterModel.setAddress(mAddress.getText().toString());
				objRegisterModel.setUserName(muser.getText().toString());

				AsyncTask<RegisterModel, String, String> registerTask = new RegistrationTask(Login.this).execute(objRegisterModel);
				
				String result = null;
				try {
					result = registerTask.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Gson gson = new Gson();

				RegistrationResponse response = gson.fromJson(result,
						RegistrationResponse.class);
				
				if (response.success == 1) {
					Intent i = new Intent(this, HomePage.class);
					startActivity(i);
					sp = PreferenceManager.getDefaultSharedPreferences(this);
					Editor ed = sp.edit();
					ed.putString("user_name_login", objRegisterModel.getEmailId());
					ed.putString("password_login", objRegisterModel.getPassword());
					ed.apply();
				} else {
					//username.setError("Enter valid details");
					mEmailId.setError(response.error_msg);
				}
			}
			break;	

		case R.id.textViewforgot:

			framelLayoutlogin.setVisibility(View.GONE);
			framLayoutForgot.setVisibility(View.VISIBLE);
			break;

		case R.id.buttonForgot:

			/*
			 * For forgot password send useremail  to LoginModel 
			 * And send these parameters to repective webservice to do proecssing and
			 * in onPostExecute of task do what ever operation you want to do
			 */

			LoginModel objLoginModel = new LoginModel();
			objLoginModel.setUserName(mEmailForgot.getText().toString());

			new ForgotPasswordTask(Login.this).execute(objLoginModel);

			//-------------manipulate these lines when password send Successfully-----------
			framLayoutForgot.setVisibility(View.GONE);
			framelLayoutlogin.setVisibility(View.VISIBLE);

			break;
		}
	}

	private void showdialog() {

		AlertDialog alertDialog = new AlertDialog.Builder(
				Login.this).create();

		// Setting Dialog Title
		alertDialog.setTitle("Warning");

		// Setting Dialog Message
		alertDialog.setMessage("Please enter all the information");


		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to execute after dialog closed
			}
		});
		alertDialog.show();
	}

}
