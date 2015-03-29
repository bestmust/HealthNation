package com.example.patient;

import com.example.adapters.GridViewCustomAdapter;
import com.example.asyncTask.SearchTask;
import com.example.dataModel.SearchModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

public class SearchResult extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	GridView gridView;
	GridViewCustomAdapter grisViewCustomeAdapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_serach_doctor_result);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		SearchModel objSearchModel = new SearchModel();

		//----Which specialist is selected pass id by comma sepearated-----------
		objSearchModel.setSearchIds("1");

		new SearchTask(SearchResult.this).execute(objSearchModel);

	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
            case android.R.id.home:

            	Intent homepage = new Intent(SearchResult.this,HomePage.class);
            	startActivity(homepage);
            	
            }
            return true;
    }



}
