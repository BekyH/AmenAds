package com.example.navtrial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import androidx.core.app.Fragment;
//import androidx.core.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment {
    TextView logintextview;
    Button loginbtn;
    EditText loginemail;
    EditText loginpaswd;
    FirebaseAuth fauth;
    SignInButton signInButton;
    //SignInClientImpl mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener fauthstatelistener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        fauth = FirebaseAuth.getInstance();
        signInButton = view.findViewById(R.id.sign_in_button);
        logintextview = view.findViewById(R.id.login_click_here_textview);
        loginemail = view.findViewById(R.id.login_email_edit_text);
        loginpaswd = view.findViewById(R.id.login_password_edit_text);
        loginbtn = view.findViewById(R.id.login_btn);

        fauthstatelistener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser ffirebaseuser = fauth.getCurrentUser();
//                if(ffirebaseuser!=null){
//                    Toast.makeText(getContext()," logged in",Toast.LENGTH_SHORT).show();
//                    ((MainActivity)getActivity()).Navigation();
//                    ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
//                    adsFragment eventFragment = new adsFragment();
//                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.containers,eventFragment)
//                            .addToBackStack(null)
//                            .commit();
//
//                }
//                else {
//                    Toast.makeText(getContext(),"please log in",Toast.LENGTH_SHORT).show();
//                }
            }
        };
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        logintextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFragment rf = new registerFragment();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containers,rf)
                        .addToBackStack(null)
                        .commit();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gmail = loginemail.getText().toString().trim();
                String pswd = loginpaswd.getText().toString().trim();
                ((MainActivity)getActivity()).Navigation();
                                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
                                adsFragment eventFragment = new adsFragment();
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.containers,eventFragment)
                                        .addToBackStack(null)
                                        .commit();
//
//                                loginemail.setText("");
//                                loginpaswd.setText("");
//                ((MainActivity)getActivity()).Navigation();
//                                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
//                                ChurchListFragment eventFragment = new ChurchListFragment();
//                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                                fragmentTransaction.replace(R.id.containers,eventFragment)
//                                        .addToBackStack(null)
//                                        .commit();
////
//                if(gmail.isEmpty() || pswd.isEmpty()){
//                    Toast.makeText(getContext(), "fields are empty", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    fauth.signInWithEmailAndPassword(gmail,pswd).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(getContext(),"Login success",Toast.LENGTH_SHORT).show();
//                               ((MainActivity)getActivity()).Navigation();
//                                ((MainActivity)getActivity()).mytoolbar.setVisibility(View.VISIBLE);
//                                adsFragment eventFragment = new adsFragment();
//                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                                fragmentTransaction.replace(R.id.containers,eventFragment)
//                                        .addToBackStack(null)
//                                        .commit();
//
//                                loginemail.setText("");
//                                loginpaswd.setText("");
//                            }
//                            else{
//                                Toast.makeText(getContext(),"not login success",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });

               // }


            }
        });
        return view;

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
