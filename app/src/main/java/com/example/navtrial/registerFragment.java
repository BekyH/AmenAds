package com.example.navtrial;

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


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class registerFragment extends Fragment {
    TextView clickhere_textview;
    EditText name;
    EditText phone;
    EditText email;
    EditText password;
    Button reg_btn;
    private FirebaseAuth Fauth;
//    private ProgressDialog pdialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);
//        FirebaseApp.initializeApp(getContext());
//        Fauth = FirebaseAuth.getInstance();

        clickhere_textview = view.findViewById(R.id.register_click_here);
        name = view.findViewById(R.id.register_username_edit_text);
        phone = view.findViewById(R.id.register_phone_no_edit_text);
        email = view.findViewById(R.id.register_email_edit_text);
        password = view.findViewById(R.id.register_password_edit_text);
        reg_btn = view.findViewById(R.id.register_btn);
       clickhere_textview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               LoginFragment lf = new LoginFragment();
               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.containers,lf)
                       .addToBackStack(null)
                       .commit();
           }
       });

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = name.getText().toString().trim();
                String uemail = email.getText().toString().trim();
                String uphone = phone.getText().toString().trim();
                String upassword = password.getText().toString().trim();
                if (uname.isEmpty() || uemail.isEmpty() || uphone.isEmpty() || upassword.isEmpty()) {
                    Toast.makeText(getContext(), "all fields are required", Toast.LENGTH_SHORT).show();
                } else {
//                    Fauth.createUserWithEmailAndPassword(uemail, upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // pdialog.dismiss();
//                                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
//
//                            } else {
//                                Toast.makeText(getContext(), "not success", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//
//
//                    });
                }
            }});
        return view;
    }
    public void login(View view){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
