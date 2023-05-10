package com.example.nav_bar.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nav_bar.R;
import com.example.nav_bar.hospitals_view;

public class Hospital extends Fragment {

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
        addCoor = (Button) view.findViewById(R.id.addCoordinator);
        addDoc = (Button) view.findViewById(R.id.addDoctor);
        view2 = (Button) view.findViewById(R.id.view2);
        edit = (Button) view.findViewById(R.id.edit);
        del = (Button) view.findViewById(R.id.delete);

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.create_hospital);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        addHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        //Add Coordinator
        addCoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_coordinator();
            }
        });
        addDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_doctor();
            }
        });
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_hospital();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_hospital();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_hospital();
            }
        });

        return view;
    }


    private void add_coordinator() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_addcoordinator);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        // Add a "Submit" button to the dialog layout
        Button submitButton = dialog.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save contents to the database
                dialog.dismiss();
            }
        });
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

    private void add_doctor() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_doctor);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        // Add a "Submit" button to the dialog layout
        Button submitButton = dialog.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
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

    public void view_hospital() {
        Intent intent = new Intent(getActivity(), hospitals_view.class);
        startActivity(intent);
    }

    private void edit_hospital() {

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.edit_hospital);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

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
    private void delete_hospital() {

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_delete);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        // Add a "Submit" button to the dialog layout
        Button submitButton = dialog.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
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
}