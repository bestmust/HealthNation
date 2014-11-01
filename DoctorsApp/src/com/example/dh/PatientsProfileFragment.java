package com.example.dh;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class PatientsProfileFragment extends Fragment {

	TextView textViewName, textViewAddress, textViewLastLogin,
			textViewContactInfo, textViewnofovisits;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.new_patients_profile, null);
		Typeface sofiaPro = Typeface.createFromAsset(getActivity().getAssets(),
				"SofiaProLight.otf");

		textViewAddress = (TextView) v.findViewById(R.id.textViewAddressUser);
		textViewContactInfo = (TextView) v
				.findViewById(R.id.textViewContactInfo);
		textViewLastLogin = (TextView) v.findViewById(R.id.textViewlastLogin);
		textViewnofovisits = (TextView) v
				.findViewById(R.id.textViewNoOfVisists);
		textViewName = (TextView) v.findViewById(R.id.textViewUserName);

		textViewAddress.setTypeface(sofiaPro);
		textViewContactInfo.setTypeface(sofiaPro);
		textViewLastLogin.setTypeface(sofiaPro);
		textViewnofovisits.setTypeface(sofiaPro);
		textViewName.setTypeface(sofiaPro);

		return v;
	}
}
