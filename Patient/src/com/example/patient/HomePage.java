package com.example.patient;

import java.util.ArrayList;

import com.example.adapters.PrescriptionAdapter;
import com.example.asyncTask.SearchTask;
import com.example.dataModel.PatientDescriptionDTO;
import com.example.dataModel.SearchModel;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressLint("NewApi")
public class HomePage extends Activity implements OnClickListener {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	private TabHost myTabHost;
	ImageView physician,physician1,physician2,tick,imageViewOrtho,imageViewOrtho1,tick1,imageViewSurgeon,imageViewSurgeon1,imageViewSurgeontick,imageViewDentist,imageViewDentist1,imageViewDentisttick,imageViewPedia,imageViewPedia1,imageViewPediatick,imageViewGyno,imageViewGyno1,imageViewGynotick;
	TextView textViewPhy, textViewPhy1;
	ListView listViewpatient;
	Button mSearch,mShowMap;

	String[] patientList;
	ArrayList<PatientDescriptionDTO>patientslist = new ArrayList<PatientDescriptionDTO>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);

		init();
		myTabHost = (TabHost)findViewById(R.id.TabHostBookTrip);
		myTabHost.setup();

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		TabSpec liveTrip = myTabHost.newTabSpec("Saved History");
		liveTrip.setIndicator("Saved History");
		liveTrip.setContent(R.id.savedprescription);
		myTabHost.addTab(liveTrip);

		myTabHost.addTab(myTabHost.newTabSpec("Find Doctor").setIndicator("Find Doctor").setContent(R.id.searchdocotr));

		physician.setOnClickListener(this);
		imageViewOrtho.setOnClickListener(this);
		imageViewSurgeon.setOnClickListener(this);
		imageViewDentist.setOnClickListener(this);
		imageViewPedia.setOnClickListener(this);
		imageViewGyno.setOnClickListener(this);
		mSearch.setOnClickListener(this);
		mShowMap.setOnClickListener(this);


		/*
		 * For Fetching a record for a particular login patient just pass the id of user 
		 * and pass it to history task.
		 * 		
		 */
		/*
		//----------------For Fetching records of history(jsut pass the patient id)----------

		LoginModel objLoginModel = new LoginModel();

		//------Set userID to find history-------
		objLoginModel.setmUserId("1");

		//new HistoryTask(HomePage.this).execute(objLoginModel);
		 */
	}

	private void init() {

		physician = (ImageView)findViewById(R.id.ImageviewPhysician);
		physician2 = (ImageView)findViewById(R.id.ImageviewPhysician2);
		textViewPhy = (TextView)findViewById(R.id.textViewphy);
		tick = (ImageView)findViewById(R.id.imageViewtick);

		imageViewOrtho = (ImageView)findViewById(R.id.ImageviewOrtho);
		imageViewOrtho1 =(ImageView)findViewById(R.id.ImageviewOrtho1);
		tick1 = (ImageView)findViewById(R.id.imageViewOrtho);

		imageViewSurgeon=  (ImageView)findViewById(R.id.Imageviewsurgeon);
		imageViewSurgeon1=  (ImageView)findViewById(R.id.Imageviewsurgeon1);
		imageViewSurgeontick = (ImageView)findViewById(R.id.Imageviewsurgeontick);


		imageViewDentist = (ImageView)findViewById(R.id.ImageviewDentist);
		imageViewDentist1 = (ImageView)findViewById(R.id.ImageviewDentist1);
		imageViewDentisttick = (ImageView)findViewById(R.id.ImageviewDentisttick);


		imageViewPedia = (ImageView)findViewById(R.id.ImageviewPedia);
		imageViewPedia1 = (ImageView)findViewById(R.id.ImageviewPedia1);
		imageViewPediatick = (ImageView)findViewById(R.id.ImageviewPediatick);


		imageViewGyno = (ImageView)findViewById(R.id.Imageviewgyno);
		imageViewGyno1 = (ImageView)findViewById(R.id.Imageviewgyno1);
		imageViewGynotick = (ImageView)findViewById(R.id.Imageviewgynotick);


		mShowMap  = (Button)findViewById(R.id.buttonMap);
		mSearch  =(Button)findViewById(R.id.buttonSearch);

		//------------------------Find History----------
		listViewpatient  =(ListView)findViewById(R.id.listView1);


		/*
		 * To apply a arraylist of histoy of user copy following code in onPostExecute of HistoryTask
		 * Just pass thr arralist that you got from server
		 * 
		 */
		//------------Manipulate if any histoy found in historytask onPostExecute----//
		//------------Else shows image only--------------------

		PatientDescriptionDTO objDescriptionDTO = new PatientDescriptionDTO();

		for(int i=0;i<5;i++){
			objDescriptionDTO.setMatchUserDetails(new PatientDescriptionDTO("Test User", "Kothrud,Pune", ""));
		}

		patientList = new String[PatientDescriptionDTO.prescriptionList.size()];

		for(int i =0;i<patientList.length;i++){

			patientList[i] = PatientDescriptionDTO.prescriptionList.get(i).patientName;

			PatientDescriptionDTO group = new PatientDescriptionDTO(patientList[i],patientList[i],patientList[i]);
			patientslist.add(group);

		} 

		PrescriptionAdapter tripadapter = new PrescriptionAdapter(this,patientslist);
		listViewpatient.setAdapter(tripadapter);

	}

	@Override
	public void onClick(View arg0) {

		switch(arg0.getId()){


		case R.id.ImageviewPhysician:

			if(physician.getTag() != null && physician.getTag().toString().equals("ImageviewPhysician")){
				physician.setTag("ImageviewPhysician2");
				physician2.setVisibility(View.VISIBLE);
				tick.setVisibility(View.VISIBLE);
			} else {
				physician.setTag("ImageviewPhysician");
				physician2.setVisibility(View.GONE);
				tick.setVisibility(View.GONE);
			}
			break;


		case R.id.ImageviewOrtho:

			if(imageViewOrtho.getTag() != null && imageViewOrtho.getTag().toString().equals("ImageviewOrtho")){
				imageViewOrtho.setTag("ImageviewOrtho1");
				imageViewOrtho1.setVisibility(View.VISIBLE);
				tick1.setVisibility(View.VISIBLE);
			} else {
				imageViewOrtho.setTag("ImageviewOrtho");
				imageViewOrtho1.setVisibility(View.GONE);
				tick1.setVisibility(View.GONE);
			}

			break;

		case R.id.Imageviewsurgeon:

			if(imageViewSurgeon.getTag() != null && imageViewSurgeon.getTag().toString().equals("Imageviewsurgeon")){
				imageViewSurgeon.setTag("Imageviewsurgeon1");
				imageViewSurgeon1.setVisibility(View.VISIBLE);
				imageViewSurgeontick.setVisibility(View.VISIBLE);
			} else {
				imageViewSurgeon.setTag("Imageviewsurgeon");
				imageViewSurgeon1.setVisibility(View.GONE);
				imageViewSurgeontick.setVisibility(View.GONE);
			}

			break;

		case R.id.ImageviewDentist:

			if(imageViewDentist.getTag() != null && imageViewDentist.getTag().toString().equals("ImageviewDentist")){
				Log.d("in den", "dentist");
				imageViewDentist.setTag("ImageviewDentist1");
				imageViewDentist1.setVisibility(View.VISIBLE);
				imageViewDentisttick.setVisibility(View.VISIBLE);
			} else {
				Log.d("in den", "else dentist");

				imageViewDentist.setTag("ImageviewDentist");
				imageViewDentist1.setVisibility(View.GONE);
				imageViewDentisttick.setVisibility(View.GONE);
			}

			break;
		case R.id.ImageviewPedia:

			if(imageViewPedia.getTag() != null && imageViewPedia.getTag().toString().equals("ImageviewPedia")){
				imageViewPedia.setTag("ImageviewDentist1");
				imageViewPedia1.setVisibility(View.VISIBLE);
				imageViewPediatick.setVisibility(View.VISIBLE);
			} else {

				imageViewPedia.setTag("ImageviewPedia");
				imageViewPedia1.setVisibility(View.GONE);
				imageViewPediatick.setVisibility(View.GONE);
			}

			break;

		case R.id.Imageviewgyno:

			if(imageViewGyno.getTag() != null && imageViewGyno.getTag().toString().equals("Imageviewgyno")){
				imageViewGyno.setTag("ImageviewDentist1");
				imageViewGyno1.setVisibility(View.VISIBLE);
				imageViewGynotick.setVisibility(View.VISIBLE);
			} else {

				imageViewGyno.setTag("Imageviewgyno");
				imageViewGyno1.setVisibility(View.GONE);
				imageViewGynotick.setVisibility(View.GONE);
			}

			break;


		case R.id.buttonSearch:


			/*
			 * After selecting the respective speciality,pass that ids to serarch result
			 * by creating arraylist of selectedd id's
			 */

			//--------Pass result to SearchResult-----------
			Intent objSearch = new Intent(HomePage.this,SearchResult.class);
			startActivity(objSearch);


			break;

		case R.id.buttonMap:

			/*
			 * After selecting the respective speciality,pass that ids to SearchModel
			 * by creating arraylist of selectedd id's
			 */

			SearchModel objSearchModelMap = new SearchModel();

			//----Which specialist is selected pass id by comma sepearated-----------
			objSearchModelMap.setSearchIds("1");

			new SearchTask(HomePage.this).execute(objSearchModelMap);

			//--------Pass result to ShowMap-----------
			Intent showmap = new Intent(HomePage.this,ShowMap.class);
			startActivity(showmap);
			break;
		}
	}
}
