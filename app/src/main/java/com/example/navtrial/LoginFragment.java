package com.example.navtrial;


import android.app.AlertDialog;
import android.app.ProgressDialog;

import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.common.SignInButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;
import java.util.Locale;

public class LoginFragment extends Fragment {
    TextView logintextview;
    Button loginbtn;
    EditText loginemail;
    EditText loginpaswd;
    FirebaseAuth fauth;
    SignInButton signInButton;
    ProgressDialog progressDialog;
    //SignInClientImpl mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener fauthstatelistener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        fauth = FirebaseAuth.getInstance();
//        signInButton = view.findViewById(R.id.sign_in_button);
        logintextview = view.findViewById(R.id.login_click_here_textview);
        loginemail = view.findViewById(R.id.login_email_edit_text);
        loginpaswd = view.findViewById(R.id.login_password_edit_text);
        loginbtn = view.findViewById(R.id.login_btn);

        fauthstatelistener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser ffirebaseuser = fauth.getCurrentUser();

            }
        };

        logintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFragment rf = new registerFragment();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers, rf)
                        .addToBackStack(null)
                        .commit();
            }
        });

//        loginbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                ((MainActivity)getActivity()).Navigation();
//                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
//                               adsFragment eventFragment = new adsFragment();
//                               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                                fragmentTransaction.replace(R.id.containers,eventFragment).addToBackStack(null)
//                                        .commit();
//            }
//
//        });
       // loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String gmail = loginemail.getText().toString().trim();
//                String pswd = loginpaswd.getText().toString().trim();
//
//                if(gmail.isEmpty() || pswd.isEmpty()){
//                    Toast.makeText(getContext(), "fields are empty", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    pr+
//
//                    ogressDialog = new ProgressDialog(getContext());
//                    progressDialog.setMessage("Loading....");
//                    progressDialog.show();
//                    fauth.signInWithEmailAndPassword(gmail,pswd).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                progressDialog.dismiss();





                loginbtn.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {



                        String gmail = loginemail.getText().toString().trim();
                        String pswd = loginpaswd.getText().toString().trim();


                        if (gmail.isEmpty() || pswd.isEmpty()) {
                            Toast.makeText(getContext(), "fields are empty", Toast.LENGTH_SHORT).show();

                        } else {
                            progressDialog = new ProgressDialog(getContext());
                            progressDialog.setMessage("Loading....");
                            progressDialog.show();
                            fauth.signInWithEmailAndPassword(gmail, pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressDialog.dismiss();


                                        ((MainActivity) getActivity()).Navigation();
                                        ((MainActivity) getActivity()).mytoolbar.setVisibility(View.VISIBLE);
                                        adsFragment eventFragment = new adsFragment();
                                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                        fragmentTransaction.replace(R.id.containers, eventFragment)
                                                .addToBackStack(null)
                                                .commit();

//
//                               ((MainActivity)getActivity()).Navigation();
//                                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
//                                adsFragment eventFragment = new adsFragment();
//                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                                fragmentTransaction.replace(R.id.containers,eventFragment)
//                                        .addToBackStack(null)
//                                        .commit();


                                        loginemail.setText("");
                                        loginpaswd.setText("");
                                    } else {
                                        loginemail.setText("");
                                        loginpaswd.setText("");
                                        progressDialog.dismiss();
                                        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                                        alertDialog.setTitle("Login Failed");
                                        alertDialog.setMessage(" please try again!!");
                                        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                });
                                        alertDialog.show();

                                    }
                                }
                            });

                        }
                    }
                });


        return view;
//
//
//
    }


    @Override
    public void onStart() {
        super.onStart();
        fauth.addAuthStateListener(fauthstatelistener);
    }

    private void signIn() {
      //  Intent signInIntent = mGoogleSignInClient.getSignInIntent();
       // startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
