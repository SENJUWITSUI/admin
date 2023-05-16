package com.example.nav_bar.Fragment_admin;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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
import com.example.nav_bar.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Users extends Fragment {
    private static String BASE_URL = "http://10.20.102.46:8080/api/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        TableLayout table_user = view.findViewById(R.id.table_user);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<UserData>> call = jsonPlaceHolderApi.getUsers();

        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {

                if (response.isSuccessful()) {
                    // Get the list of user data objects
                    List<UserData> userDataList = response.body();

//                    Update your table layout with the received data
                    for (UserData userData : userDataList) {
                        String username = userData.getUsername();
                        String f_name = userData.getFirst_name();
                        String l_name = userData.getLast_name();
                        String m_name = userData.getMiddle_name();
                        String email = userData.getEmail();
                        String specialization = userData.getSpecialization();
                        String types = userData.getTypes();
                        String number = userData.getContactNumber();
                        String fullName = f_name + " " + m_name + " " + l_name;

                        Context context = requireContext().getApplicationContext();

                        // Create a new table row and populate it with the data
                        TableRow row = new TableRow(context);

                        // Create TextViews for the id and service name
                        TextView usernameView = new TextView(context);
                        TableRow.LayoutParams userNameLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        userNameLayoutParams.setMargins(10, 10, 10, 10);
                        usernameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        usernameView.setLayoutParams(userNameLayoutParams);
                        usernameView.setText(username);

                        TextView nameView = new TextView(context);
                        TableRow.LayoutParams NameLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        NameLayoutParams.setMargins(10, 10, 10, 10);
                        nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        nameView.setLayoutParams(NameLayoutParams);
                        nameView.setText(fullName);

                        TextView emailView = new TextView(context);
                        TableRow.LayoutParams emailLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        emailLayoutParams.setMargins(10, 10, 10, 10);
                        emailView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        emailView.setLayoutParams(emailLayoutParams);
                        emailView.setText(email);

                        TextView specializationView = new TextView(context);
                        TableRow.LayoutParams specialLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        specialLayoutParams.setMargins(10, 10, 10, 10);
                        specializationView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        specializationView.setLayoutParams(specialLayoutParams);
                        specializationView.setText(specialization);

                        TextView typesView = new TextView(context);
                        TableRow.LayoutParams typesLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        typesLayoutParams.setMargins(10, 10, 10, 10);
                        typesView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        typesView.setLayoutParams(typesLayoutParams);
                        typesView.setText(types);

                        TextView contactNumberView = new TextView(context);
                        TableRow.LayoutParams contactLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0f);
                        contactLayoutParams.setMargins(10, 10, 10, 10);
                        contactNumberView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // Set text size to 16sp
                        contactNumberView.setLayoutParams(contactLayoutParams);
                        contactNumberView.setText(number);

//                        Button actionButton = new Button(getApplicationContext());
//                        actionButton.setText("Action");
//                        row.addView(actionButton);

                        // Add a divider View between the columns
                        View divider = new View(context);
                        divider.setLayoutParams(new TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT));
                        divider.setBackground(getResources().getDrawable(R.drawable.table_column_divider));


                        // Add margins and paddings to the text views to separate the columns
                        usernameView.setPadding(16, 0, 16, 0);
                        nameView.setPadding(16, 0, 16, 0);
                        emailView.setPadding(16, 0, 16, 0);
                        specializationView.setPadding(16, 0, 16, 0);
                        typesView.setPadding(16, 0, 16, 0);
                        contactNumberView.setPadding(16, 0, 16, 0);



                        // Set the custom drawable as the background for the row
                        row.setBackground(getResources().getDrawable(R.drawable.shape));

                        // Add the TextViews to the table row
                        row.addView(usernameView);
                        row.addView(nameView);
                        row.addView(emailView);
                        row.addView(specializationView);
                        row.addView(typesView);
                        row.addView(contactNumberView);
//                        row.addView(contactNumberView);

                        table_user.addView(row);
                    }
                }else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Log.e("TAG", "Response: " + t.getMessage());
            }

    });
        return view;
    }

}