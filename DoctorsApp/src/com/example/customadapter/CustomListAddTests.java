package com.example.customadapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.erxproject.erx.controller.PrescriptionController;
import com.erxproject.erx.model.Prescription;
import com.erxproject.erx.model.prescription.Test;
import com.example.datamodels.ListDataTests;
import com.example.dh.R;

public class CustomListAddTests extends BaseAdapter {

	private Context activity;
	private LayoutInflater inflater;
	private List<ListDataTests> movieItems;
	ArrayList<String> arrayListMedicines;
	PrescriptionController pc;
	Prescription p;

	public CustomListAddTests(Context context, ArrayList<ListDataTests> myList) {
		inflater = LayoutInflater.from(context);
		this.activity = context;
		this.movieItems = myList;
	}

	@Override
	public int getCount() {
		return movieItems.size();
	}

	@Override
	public Object getItem(int location) {
		return movieItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public class ViewHolderMainHome {

		TextView textViewCounter;
		ToggleButton buttonDone;
		EditText editTextTestname;

	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		// TODO Auto-generated method stub

		final ViewHolderMainHome holderMain;
		arrayListMedicines = new ArrayList<String>();
		final ListDataTests objListDataTests = movieItems.get(position);
		if (convertView == null) {
			holderMain = new ViewHolderMainHome();
			convertView = inflater.inflate(R.layout.add_tests_value, null);

			holderMain.textViewCounter = (TextView) convertView
					.findViewById(R.id.textViewTestsCounter);

			holderMain.editTextTestname = (EditText) convertView
					.findViewById(R.id.editTextAddTests);
			holderMain.buttonDone = (ToggleButton) convertView
					.findViewById(R.id.buttonDoneTest);

			convertView.setTag(holderMain);

		} else {
			holderMain = (ViewHolderMainHome) convertView.getTag();
		}

		holderMain.editTextTestname.setTag(position);

		holderMain.editTextTestname.setId(position);

		ListDataTests m = movieItems.get(position);

		holderMain.textViewCounter.setText(m.getTitle());
		holderMain.editTextTestname.setText(m.getTestName());

		holderMain.buttonDone.setTag(position);
		holderMain.buttonDone
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						int position = ((Integer) buttonView.getTag())
								.intValue();

						if (isChecked) {
							// myItems.put(position,
							// Caption.getText().toString());
							Log.d("da", "incak");

							if (holderMain.editTextTestname.getText()
									.toString().equalsIgnoreCase("")) {

								Toast.makeText(activity,
										"Please Enter Test Name",
										Toast.LENGTH_SHORT).show();
								holderMain.buttonDone.setTextOn("Done");
								holderMain.buttonDone.toggle();
							} else {
								holderMain.buttonDone.setTextOn("Edit");

								Log.d("test name values", ""
										+ holderMain.editTextTestname.getText()
												.toString());

								objListDataTests
										.setTestName(holderMain.editTextTestname
												.getText().toString());

								pc = new PrescriptionController(activity);
								p = Prescription.get(activity);
								int testId = pc.saveTest(p.getHistoryId(),
										objListDataTests.getTestName());
								Test t = pc.getTest(testId);
								p.getTests().add(t);

								disableFields();
							}
						} else {
							// holderMain.autoTextView.setEnabled(true);
							enableFields();
						}
					}

					private void enableFields() {
						// TODO Auto-generated method stub
						holderMain.editTextTestname.setEnabled(true);

					}

					private void disableFields() {
						// TODO Auto-generated method stub
						holderMain.editTextTestname.setEnabled(false);

					}

				});
		return convertView;
	}

}