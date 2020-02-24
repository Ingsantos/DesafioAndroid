package com.digitalhouse.desafioandroid.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.digitalhouse.desafioandroid.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private Button btnSignIn;
    private TextView tvOptionOr;
    private Button btnRegister;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        initViews();

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

            if (mFirebaseUser != null){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Toast.makeText(LoginActivity.this, "You're logged in", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(LoginActivity.this, "Please log in", Toast.LENGTH_LONG).show();
            }
        };

        btnSignIn.setOnClickListener(v -> {
            if (isEmpty(tilEmail)){
                tilEmail.setError("To sign in you need to fulfill this field");
                tilPassword.setError(null);
                tilEmail.requestFocus();
            } else if (isEmpty(tilPassword)){
                tilPassword.setError("To sign in you need to fulfill this field");
                tilEmail.setError(null);
                tilPassword.requestFocus();
            } else if (!isEmpty(tilEmail) && !isEmpty(tilPassword)){
                tilEmail.setError(null);
                tilPassword.setError(null);

                mFirebaseAuth.signInWithEmailAndPassword(getString(tilEmail), getString(tilPassword)).addOnCompleteListener(LoginActivity.this, task -> {
                    if (!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Login error, email/password is not valid", Toast.LENGTH_LONG).show();
                    } else {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                });
            } else {
                Toast.makeText(LoginActivity.this, "Error occurred!", Toast.LENGTH_LONG).show();
            }
        });

        btnRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    private boolean isEmpty (TextInputLayout viewName){
        String view = getString(viewName);
        return view.isEmpty();
    }

    private String getString(TextInputLayout viewName) {
        return viewName.getEditText().getText().toString();
    }

    private void initViews(){
        tilEmail = findViewById(R.id.textInputLayoutEmail);
        tilPassword = findViewById(R.id.textInputLayoutPassword);
        btnSignIn = findViewById(R.id.buttonSignIn);
        tvOptionOr = findViewById(R.id.textViewOr);
        btnRegister = findViewById(R.id.buttonRegister);
    }


}
