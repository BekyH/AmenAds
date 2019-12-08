package com.example.navtrial;

//import android.support.annotation.NonNull;
//import android.support.design.widget.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.FragmentTransaction;
//import androidx.core.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    private FirebaseAuth.AuthStateListener matuhListener;

    Toolbar mytoolbar;
    Toolbar myprofiletoolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        mytoolbar = findViewById(R.id.my_toolbar);
        registerFragment register = new registerFragment();
        FragmentTransaction fragmentTransactioninital = getSupportFragmentManager().beginTransaction();
        fragmentTransactioninital.replace(R.id.containers, register)
                .addToBackStack(null)
        .commit();
        mytoolbar.setVisibility(View.INVISIBLE);
        //Navigation();
//        myprofiletoolbar = findViewById(R.id.myprofiletoolbar);
//        if (myprofiletoolbar != null) {
//            setSupportActionBar(myprofiletoolbar);
////        }

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
//               Toast.makeText(MainActivity.this,"open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //Toast.makeText(MainActivity.this,"Closed",Toast.LENGTH_SHORT).show();
            }
        };


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.myNavigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.Ads:
                        adsFragment eventFragment = new adsFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.containers,eventFragment)
                                .addToBackStack(null)
                                .commit();


                        break;
                    case R.id.church:
                        churchFragment church = new churchFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.containers,church)
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

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
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


