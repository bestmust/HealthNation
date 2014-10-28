package com.example.dh;

import java.util.ArrayList;

import com.erxproject.erx.model.Prescription;
import com.erxproject.erx.model.prescription.Test;
import com.example.customadapter.CustomListAddSymptoms;
import com.example.customadapter.CustomListAddTests;
import com.example.datamodels.ListDataSymptoms;
import com.example.datamodels.ListDataTests;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Tests extends Fragment implements OnClickListener {

	Prescription p;
	String addedTest;
	ListView TestList;
	// Defined Array values to show in ListView
	String[] values ;
	ArrayList<String> arrayListTest ;
	Button addMore;
	ArrayList<ListDataTests> myList = new ArrayList<ListDataTests>();
	CustomListAddTests adapter;
	ListDataTests objDataTests;
	int counter=0;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.activity_patients_tests, null);
		TestList = (ListView)v.findViewById(R.id.listViewTests);
		arrayListTest = new ArrayList<String>();


		addMore = (Button)v.findViewById(R.id.buttonAddMoreTests);

		init();
		addMore.setOnClickListener(this);

		adapter = new CustomListAddTests(getActivity().getBaseContext(), myList);
		TestList.setAdapter(adapter);


		return v;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.buttonAddMoreTests:

			getDataList();
			break;
		}
	}
	private void init() {
		// TODO Auto-generated method stub

		p = Prescription.get(getActivity());
		
		ArrayList<Test> tests = p.getTests();
		myList.clear();
		counter = 0;
		for( Test t: tests) {
			objDataTests =new ListDataTests();
			objDataTests.setTitle("" + (counter+1));
			objDataTests.setTestName(t.getName());
			myList.add(objDataTests);
			counter++;
		}
		
		if(myList.size() == 0) {
			getDataList();
		}
		
	}
	private void getDataList() {
		// TODO Auto-generated method stub
		if(counter!=0)
		{		
			objDataTests =new ListDataTests();
			
			objDataTests.setTitle(""+(counter+1));
			myList.add(counter, objDataTests);
			counter++;
		}
		if(myList.size() > 2) {
			adapter.notifyDataSetChanged();
		}
	}




}