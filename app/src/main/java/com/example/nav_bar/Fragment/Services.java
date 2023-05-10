package com.example.nav_bar.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nav_bar.MainActivity;
import com.example.nav_bar.R;

public class Services extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        Dialog myDialog = new Dialog(getContext());
        Button servicebtn = view.findViewById(R.id.servicebtn);
        servicebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.activity_addservice);
                Button myDialogButton = myDialog.findViewById(R.id.closebtn);
                Button myDialog1Button = myDialog.findViewById(R.id.savebtn);

                myDialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);


                    }
                });

                myDialog.show();


            }
        });

        return view;
    }
}