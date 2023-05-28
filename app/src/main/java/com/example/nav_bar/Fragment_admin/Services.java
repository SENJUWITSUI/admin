package com.example.nav_bar.Fragment_admin;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.nav_bar.R;
import com.example.nav_bar.RetrofitAPI;
import com.example.nav_bar.RetrofitClient;
import com.example.nav_bar.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        EditText searchEditText = view.findViewById(R.id.servicesearch);
        TableLayout table_service = view.findViewById(R.id.table_services);


        Call<List<service>> call = RetrofitClient
                .getInstance()
                .getRetrofitApi().getServices();

            //SEARCH BAR
//        searchEditText.addTextChangedListener(new TextWatcher() {
//            private Call<List<service>> apiCall;
//
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String searchText = editable.toString().trim().toLowerCase();
//
//                // Cancel the previous API call if it's still ongoing
//                if (apiCall != null && !apiCall.isCanceled()) {
//                    apiCall.cancel();
//                }

//                // Make the API call with the search query
//                apiCall = RetrofitAPI.getData(searchText);
//                // Replace 'apiService' with your actual API service instance

                call.enqueue(new Callback<List<service>>() {

                    @Override
                    public void onResponse(Call<List<service>> call, Response<List<service>> response) {
                        List<service> posts = response.body();
                        if (response.isSuccessful()) {
                            List<service> services = response.body();
//                     Toast.makeText(requireContext(),"Login Successful", Toast.LENGTH_LONG).show();

//                      Update your table layout with the received data
                            for (service servicess : services) {
                                int id = servicess.getId();
                                String serviceName = servicess.getServiceName();
                                Context context = requireContext().getApplicationContext();

                                // Create a new table row and populate it with the data
                                TableRow row = new TableRow(context);


                                // Create TextViews for the id and service name
                                TextView idTextView = new TextView(context);
//                        TableRow.LayoutParams idLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
//                        idLayoutParams.setMargins(10, 10, 10, 10);
//                        idTextView.setLayoutParams(idLayoutParams);
                                idTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                                idTextView.setText(String.valueOf(id));

                                TextView serviceNameTextView = new TextView(context);
                                TableRow.LayoutParams serviceNameLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                                serviceNameLayoutParams.setMargins(10, 10, 10, 10);
                                serviceNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                                serviceNameTextView.setLayoutParams(serviceNameLayoutParams);
                                serviceNameTextView.setText(serviceName);

                                // Add a divider View between the columns
                                View divider = new View(context);
                                divider.setLayoutParams(new TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT));
                                divider.setBackground(getResources().getDrawable(R.drawable.table_column_divider));


                                // Add margins and paddings to the text views to separate the columns
                                idTextView.setPadding(16, 0, 16, 0);
                                serviceNameTextView.setPadding(16, 0, 16, 0);

                                // Set the custom drawable as the background for the row
                                row.setBackground(getResources().getDrawable(R.drawable.shape));


                                // Add the TextViews to the table row
                                row.addView(idTextView);
                                row.addView(serviceNameTextView);

                                // Add the table row to your table layout
                                table_service.addView(row);
                            }
                        } else {
                            // Handle error
                        }
                    }

                    @Override
                    public void onFailure(Call<List<service>> call, Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());
                    }
                });

        Dialog dialog = new Dialog(getContext());
        Button servicebtn = view.findViewById(R.id.servicebtn);
        servicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.activity_addservice);

                // Add a "Submit" button to the dialog layout
                Button saveButton = dialog.findViewById(R.id.save);
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Submit contents to the database
                        dialog.dismiss();
                    }
                });

                // Add a "Close" button to the dialog layout
                Button closeButton = dialog.findViewById(R.id.close);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the dialog when the button is clicked
                        dialog.dismiss();
                    }

                });

                // Add a "Exit" button to the dialog layout
                TextView exitButton = dialog.findViewById(R.id.exit);
                exitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the dialog when the button is clicked
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        return view;
    }

}