package com.example.dh.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.erxproject.erx.model.Doctor;
import com.erxproject.erx.model.Patient;
import com.erxproject.erx.model.Prescription;
import com.erxproject.erx.model.prescription.Disease;
import com.erxproject.erx.model.prescription.Parameter;
import com.erxproject.erx.model.prescription.PrescriptionMedicine;
import com.erxproject.erx.model.prescription.Symptom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.pdf.PrintedPdfDocument;

@TargetApi(19)
public class PrintAdapter extends PrintDocumentAdapter {

	Context context;
	PrintedPdfDocument mPdfDocument;
	private int totalPages;

	// private ArrayList<Page> writtenPagesArray;

	public PrintAdapter(Context context) {
		super();
		this.context = context.getApplicationContext();
		//totalPages = compute
	}

	@Override
	public void onLayout(PrintAttributes oldAttributes,
			PrintAttributes newAttributes,
			CancellationSignal cancellationSignal,
			LayoutResultCallback callback, Bundle metadata) {
		// Create a new PdfDocument with the requested page attributes
		mPdfDocument = new PrintedPdfDocument(context, newAttributes);

		// Respond to cancellation request
		if (cancellationSignal.isCanceled()) {
			callback.onLayoutCancelled();
			return;
		}

		// Compute the expected number of printed pages
		// int pages = computePageCount(newAttributes);
		int pages = 1;

		if (pages > 0) {
			// Return print information to print framework

			PrintDocumentInfo info = new PrintDocumentInfo.Builder(
					"print_output.pdf")
					.setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
					.setPageCount(pages).build();

			// Content layout reflow is complete
			callback.onLayoutFinished(info, true);
		} else {
			// Otherwise report an error to the print framework
			callback.onLayoutFailed("Page count calculation failed.");
		}
	}

	private int computePageCount(PrintAttributes printAttributes) {
		int itemsPerPage = 4; // default item count for portrait mode

		MediaSize pageSize = printAttributes.getMediaSize();
		if (!pageSize.isPortrait()) {
			// Six items per page in landscape orientation
			itemsPerPage = 6;
		}

		// Determine number of print items
		// int printItemCount = getPrintItemCount();
		int printItemCount = 4;

		return (int) Math.ceil(printItemCount / itemsPerPage);
	}

	@Override
	public void onWrite(final PageRange[] pageRanges,
			final ParcelFileDescriptor destination,
			final CancellationSignal cancellationSignal,
			final WriteResultCallback callback) {
		// Iterate over each page of the document,
		// check if it's in the output range.
		//for (int i = 0; i < totalPages; i++) {
		for (int i = 0; i < 1; i++) {
			// Check to see if this page is in the output range.
			if (containsPage(pageRanges, i)) {
				// If so, add it to writtenPagesArray. writtenPagesArray.size()
				// is used to compute the next output page index.
				// writtenPagesArray.append(writtenPagesArray.size(), i);
				PdfDocument.Page page = mPdfDocument.startPage(i);

				// check for cancellation
				if (cancellationSignal.isCanceled()) {
					callback.onWriteCancelled();
					mPdfDocument.close();
					mPdfDocument = null;
					return;
				}

				// Draw page content for printing
				drawPage(page);

				// Rendering is complete, so page can be finalized.
				mPdfDocument.finishPage(page);
			}
		}
		
		// Write PDF document to file
		try {
			//File file = new File(Environment.getExternalStoragePublicDirectory(null), "DemoFile.jpg");
			mPdfDocument.writeTo(new FileOutputStream(destination
					.getFileDescriptor()));
		} catch (IOException e) {
			callback.onWriteFailed(e.toString());
			return;
		} finally {
			mPdfDocument.close();
			mPdfDocument = null;
		}
		PageRange[] writtenPages = computeWrittenPages();
		// Signal the print framework the document is complete
		callback.onWriteFinished(writtenPages);

	}

	private PageRange[] computeWrittenPages() {

		PageRange[] pageRanges = new PageRange[1];

		pageRanges[0] = new PageRange(0, 1);

		// TODO Auto-generated method stub
		return pageRanges;
	}

	private boolean containsPage(PageRange[] pageRanges, int i) {
		// int length = pageRanges.length;

		if (pageRanges[0].getStart() <= i && pageRanges[0].getEnd() >= i)
			return true;
		else
			return false;
	}

	private void drawPage(PdfDocument.Page page) {
		Canvas canvas = page.getCanvas();

		// units are in points (1/72 of an inch)
		int titleBaseLine = 72;
		int leftMargin = 54;

		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(30);
		Doctor doctor = Doctor.get(context);
		canvas.drawText( "Doctor: " + doctor.getName(), leftMargin, titleBaseLine+=30, paint);
		Patient patient = Patient.get(context);
		canvas.drawText( "Patient: " + patient.getName(), leftMargin, titleBaseLine+=30, paint);
		canvas.drawText("Prescription", leftMargin, titleBaseLine+=30, paint);
				
		Prescription prescription = Prescription.get(context);
		
		ArrayList<PrescriptionMedicine> medicines = prescription.getMedicine();
		paint.setTextSize(13);
		canvas.drawText("Medicines", leftMargin, titleBaseLine+=30, paint);
		
		
		Iterator<PrescriptionMedicine> medicineIterator = medicines.iterator();
		PrescriptionMedicine medicine;
		paint.setTextSize(11);
		int j=1;
		String morning = "", afternoon = "", evening= "", night = "";
		Boolean isFirst = true;
		while(medicineIterator.hasNext())
		{
			medicine = medicineIterator.next();
			
			if(medicine.isMorning())
			{
				morning = "Morning";
				isFirst = false;
			}
			if(medicine.isAfternoon()&&isFirst)
			{
				afternoon = "Afternoon";
				isFirst = false;
			}
			else if(medicine.isAfternoon()) 
			{
				afternoon = ", Afternoon";
			}
			if(medicine.isEvening()&&isFirst)
			{
				evening = "Evening";
				isFirst = false;
			}
			else if(medicine.isEvening())
			{
				evening = ", Evening";
			}
			if(medicine.isNight()&&isFirst)
			{
				night = "Night";
				isFirst = false;
			}
			else if (medicine.isNight())
			{
				night = ", Night";
			}
			
			String medicineDetails  = String.format(j+ ". %s: %s%s%s%s", medicine.getMedicineName(),morning,afternoon,evening,night);
			canvas.drawText(medicineDetails, leftMargin, titleBaseLine +=22, paint);
			j++;
		}
		
		ArrayList<Symptom> symptoms = prescription.getSymptoms();
		paint.setTextSize(13);
		canvas.drawText("Symptoms", leftMargin, titleBaseLine+=30, paint);
		paint.setTextSize(11);
		Iterator<Symptom> symptomIterator = symptoms.iterator();
		j=1;
		Symptom symptom;
		while(symptomIterator.hasNext())
		{
			symptom = symptomIterator.next();
			canvas.drawText(j + ". " + symptom.getName() + "\nDetails: " + symptom.getDetails(),leftMargin, titleBaseLine+=22, paint);
			j++;
		}
		
		ArrayList<Parameter> paramters = prescription.getParameters();
		paint.setTextSize(13);
		canvas.drawText("Parameters", leftMargin, titleBaseLine+=30, paint);
		paint.setTextSize(11);
		Iterator<Parameter> parameterIterator = paramters.iterator();
		j=1;
		Parameter parameter;
		while(parameterIterator.hasNext())
		{
			parameter = parameterIterator.next();
			canvas.drawText(j + ". " + parameter.getmParameterType() + ": " + parameter.getmParameterValue(),leftMargin, titleBaseLine+=22, paint);
			j++;
		}
		
		ArrayList<Disease> diseases = prescription.getDisease();
		paint.setTextSize(13);
		canvas.drawText("Disease Diagnosed", leftMargin, titleBaseLine+=30, paint);
		paint.setTextSize(11);
		Iterator<Disease> diseaseIterator = diseases.iterator();
		j=1;
		Disease disease;
		while(diseaseIterator.hasNext())
		{
			disease = diseaseIterator.next();
			canvas.drawText(j + ". " + disease.getDisease(),leftMargin, titleBaseLine+=22, paint);
			j++;
		}
				
	}	
}
