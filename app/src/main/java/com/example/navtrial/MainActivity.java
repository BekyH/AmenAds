package com.example.navtrial;

//import android.support.annotation.NonNull;
//import android.support.design.widget.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.FragmentTransaction;
//import androidx.core.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    public FirebaseAuth mauth;
    private FirebaseAuth.AuthStateListener matuhListener;
    int backbuttoncount;
    Toolbar mytoolbar;
    Toolbar myprofiletoolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backbuttoncount = 0;
        FirebaseApp.initializeApp(this);
        mytoolbar = findViewById(R.id.my_toolbar);
        mytoolbar.setTitleTextColor(getResources().getColor(R.color.login_color));
        registerFragment register = new registerFragment();
        FragmentTransaction fragmentTransactioninital = getSupportFragmentManager().beginTransaction();
        fragmentTransactioninital.replace(R.id.containers, register)
                .addToBackStack(null)
        .commit();
        mytoolbar.setVisibility(View.INVISIBLE);


    }
    public void Navigation(){

        if (mytoolbar != null) {
            setSupportActionBar(mytoolbar);
        }
        drawerLayout = findViewById(R.id.mydrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,mytoolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //Toast.makeText(MainActivity.this,"Closed",Toast.LENGTH_SHORT).show();
            }
        };


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.login_color));
        navigationView = findViewById(R.id.myNavigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.Ads:
                        ads1Fragment eventFragment = new ads1Fragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containers,eventFragment)
                                .addToBackStack(null)
                                .commit();


                        break;

                    case R.id.church:
                        churchFragment cf = new churchFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.containers,cf)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.profile:
                        profileFragment pf  = new profileFragment();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.containers,pf)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.setting:
                        settingFragment sf = new settingFragment();
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.containers,sf)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.about:
                        aboutFragment af = new aboutFragment();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.containers,af)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {

        if(backbuttoncount>=1){
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"press again to exit",Toast.LENGTH_SHORT).show();
            backbuttoncount++;

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                LoginFragment lf = new LoginFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers,lf)
                        .addToBackStack(null)
                        .commit();
                hideNavigation();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void hideNavigation(){
         navigationView.setVisibility(View.INVISIBLE);
         mytoolbar.setVisibility(View.INVISIBLE);
    }
}


