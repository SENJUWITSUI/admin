package com.example.nav_bar.Fragment_admin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.nav_bar.JsonPlaceHolderApi;
import com.example.nav_bar.Post;
import com.example.nav_bar.R;
import com.example.nav_bar.hospitals_view;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Hospital extends Fragment {

    private static String BASE_URL = "http://10.20.102.46:8080/api/";
    private Button addHospital;
    private Button addCoor;
    private Button addDoc;
    private Button view2;
    private Button edit;
    private Button del;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        addHospital = (Button) view.findViewById(R.id.addHospital);
        //Action Buttons
//        addCoor = (Button) view.findViewById(R.id.addCoordinator);
//        addDoc = (Button) view.findViewById(R.id.addDoctor);
//        view2 = (Button) view.findViewById(R.id.view2);
//        edit = (Button) view.findViewById(R.id.edit);
//        del = (Button) view.findViewById(R.id.delete);

//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.create_hospital);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;


        TableLayout tableLayout = view.findViewById(R.id.table_hospital);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.listRepos2();

        call.enqueue(new Callback<List<Post>>(){

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();

                    for (Post post : posts) {
                        String h_name = post.getHospitalName();

                        Context context = requireContext().getApplicationContext();

                        // Create a new table row and populate it with the data
                        TableRow row = new TableRow(context);

                        // Create TextViews for the id and service name
                        TextView hospitalview = new TextView(context);
                        TableRow.LayoutParams hospitalLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        hospitalLayoutParams.setMargins(10, 10, 10, 10);
                        hospitalview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        hospitalview.setLayoutParams(hospitalLayoutParams);
                        hospitalview.setText(h_name);

                        // Add a divider View between the columns
                        View divider = new View(context);
                        divider.setLayoutParams(new TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT));
                        divider.setBackground(getResources().getDrawable(R.drawable.table_column_divider));

                        // Add margins and paddings to the text views to separate the columns
                        hospitalview.setPadding(16, 0, 16, 0);

                        // Set the custom drawable as the background for the row
                        row.setBackground(getResources().getDrawable(R.drawable.shape));

                        // Add the TextViews to the table row
                        row.addView(hospitalview);

                        tableLayout.addView(row);
                    }

                }else{
                    // Handle error
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

//        addHospital.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // Add a "Submit" button to the dialog layout
//                Button saveButton = dialog.findViewById(R.id.save);
//                saveButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Submit contents to the database
//                        dialog.dismiss();
//                    }
//                });
//
//                    // Add a "Close" button to the dialog layout
//                Button closeButton = dialog.findViewById(R.id.close);
//                closeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Dismiss the dialog when the button is clicked
//                        dialog.dismiss();
//                    }
//                });
//
//                // Add a "Exit" button to the dialog layout
//                TextView exitButton = dialog.findViewById(R.id.exit);
//                exitButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // Dismiss the dialog when the button is clicked
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });
//
//        //Add Coordinator
//        addCoor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                add_coordinator();
//            }
//        });
//        addDoc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                add_doctor();
//            }
//        });
//        view2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                view_hospital();
//            }
//        });
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                edit_hospital();
//            }
//        });
//        del.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                delete_hospital();
//            }
//        });

        return view;
    }


//    private void add_coordinator() {
//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.dialog_addcoordinator);
//
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        // Add a "Submit" button to the dialog layout
//        Button submitButton = dialog.findViewById(R.id.submit);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Save contents to the database
//                dialog.dismiss();
//            }
//        });
//        Button closeButton = dialog.findViewById(R.id.close);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Exit" button to the dialog layout
//        TextView exitButton = dialog.findViewById(R.id.exit);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//
//    private void add_doctor() {
//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.dialog_doctor);
//
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        // Add a "Submit" button to the dialog layout
//        Button submitButton = dialog.findViewById(R.id.submit);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Submit contents to the database
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Close" button to the dialog layout
//        Button closeButton = dialog.findViewById(R.id.close);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Exit" button to the dialog layout
//        TextView exitButton = dialog.findViewById(R.id.exit);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//
//    public void view_hospital() {
//        Intent intent = new Intent(getActivity(), hospitals_view.class);
//        startActivity(intent);
//    }
//
//    private void edit_hospital() {
//
//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.edit_hospital);
//
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        // Add a "Submit" button to the dialog layout
//        Button saveButton = dialog.findViewById(R.id.save);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Submit contents to the database
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Close" button to the dialog layout
//        Button closeButton = dialog.findViewById(R.id.close);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Exit" button to the dialog layout
//        TextView exitButton = dialog.findViewById(R.id.exit);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }
//    private void delete_hospital() {
//
//        dialog = new Dialog(getContext());
//        dialog.setContentView(R.layout.dialog_delete);
//
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.setCancelable(false);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        // Add a "Submit" button to the dialog layout
//        Button submitButton = dialog.findViewById(R.id.submit);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Submit contents to the database
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Close" button to the dialog layout
//        Button closeButton = dialog.findViewById(R.id.close);
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//
//        // Add a "Exit" button to the dialog layout
//        TextView exitButton = dialog.findViewById(R.id.exit);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Dismiss the dialog when the button is clicked
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
    }
