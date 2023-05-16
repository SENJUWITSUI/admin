package com.example.nav_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.nav_bar.Fragment_admin.Dashboard;
import com.example.nav_bar.Fragment_admin.Hospital;
import com.example.nav_bar.Fragment_admin.Services;
import com.example.nav_bar.Fragment_admin.Users;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView menuIcon = findViewById(R.id.imageView);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuIcon);
                popupMenu.getMenuInflater().inflate(R.menu.logoutmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.changepass:
                                // Handle option 1 click
                                return true;
                            case R.id.logout:
                                // Handle option 2 click
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
//                                        startActivity(new Intent(MainActivity.this,Login.class));
                                        finish();
                                    }
                                },700);
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

            if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Dashboard()).commit();
        navigationView.setCheckedItem(R.id.dashboard);
    }


}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Dashboard()).commit();
                break;
            case R.id.hospitals:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Hospital()).commit();
                break;
            case R.id.services:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Services()).commit();
                break;
            case R.id.users:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Users()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void showMenu(View view) {
        drawerLayout.open();
    }

    public void closeMenu(View view) {
        drawerLayout.close();
    }


}
