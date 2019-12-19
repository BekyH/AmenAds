package com.example.navtrial;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerFragment extends Fragment {
    TextView clickhere_textview;
    EditText name;
    EditText phone;
    EditText email;
    EditText password;
    Button reg_btn;
    private FirebaseAuth Fauth;
    private FirebaseApp firebaseApp;
    private DatabaseReference dbReference;
    ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);

        Fauth = FirebaseAuth.getInstance();
        dbReference = FirebaseDatabase.getInstance().getReference("useraccounts");
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
                final String uname = name.getText().toString().trim();
                final String uemail = email.getText().toString().trim();
                final String uphone = phone.getText().toString().trim();
                final String upassword = password.getText().toString().trim();
                if (uname.isEmpty() || uemail.isEmpty() || uphone.isEmpty() || upassword.isEmpty()) {
                    Toast.makeText(getContext(), "all fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog = new ProgressDialog(getContext());
                    progressDialog.setMessage("Loading....");
                    progressDialog.show();
                    Fauth.createUserWithEmailAndPassword(uemail, upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // pdialog.dismiss();

                                User user = new User(uname,uemail,uphone,upassword);
                                FirebaseUser fuser = Fauth.getCurrentUser();
                                dbReference.child(fuser.getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            progressDialog.dismiss();
                                            Toast.makeText(getContext(), "Register success", Toast.LENGTH_SHORT).show();
                                            LoginFragment lf = new LoginFragment();
                                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                            fragmentTransaction.replace(R.id.containers,lf)
                                                    .addToBackStack(null)
                                                    .commit();
                                        }
                                        else{
                                            Toast.makeText(getContext(), "Register not success", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                name.setText("");
                                email.setText("");
                                phone.setText("");
                                password.setText("");

                            } else {
                                progressDialog.dismiss();
                                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                                alertDialog.setTitle("Registeration Failed");
                                alertDialog.setMessage(" check your connection and  try again!!");
                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();;
                                name.setText("");
                                email.setText("");
                                phone.setText("");
                                password.setText("");
                            }

                        }
//
//
                    });
                }
            }});
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = Fauth.getCurrentUser();

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getContext());
    }
}
