package com.digitalhouse.desafioandroid.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.digitalhouse.desafioandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout tilName, tilEmail, tilPassword, tillConfirmPassword;
    Button btnRegister;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        mFirebaseAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(tilName)){
                    tilName.setError("To sign up you need to fulfill this field");
                    tilEmail.setError(null);
                    tilPassword.setError(null);
                    tilName.requestFocus();
                } else if (isEmpty(tilEmail)){
                    tilEmail.setError("To sign up you need to fulfill this field");
                    tilName.setError(null);
                    tilPassword.setError(null);
                    tilEmail.requestFocus();
                } else if (isEmpty(tilPassword)){
                    tilPassword.setError("To sign up you need to fulfill this field");
                    tilEmail.setError(null);
                    tilName.setError(null);
                    tilName.requestFocus();
                } else if (!isEquals(tillConfirmPassword, tilPassword)){
                    tillConfirmPassword.setError("Password and confirm password need to be equals to sign up");
                    tilPassword.setError(null);
                    tilEmail.setError(null);
                    tilName.setError(null);
                    tilName.requestFocus();
                } else if (!isEmpty(tilName) && !isEmpty(tilEmail)
                        && !isEmpty(tilPassword) && !isEmpty(tillConfirmPassword) && isEquals(tillConfirmPassword,tilPassword)){
                    mFirebaseAuth.createUserWithEmailAndPassword(getString(tilEmail),
                            getString(tilPassword)).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,
                                        "SingUp unsucessfull, please try again", Toast.LENGTH_LONG).show();
                            } else {
                                startActivity( new Intent(RegisterActivity.this, MainActivity.class));
                            }
                        }
                    });
                }
            }
        });

        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private void initViews(){
        tilName = findViewById(R.id.textInputLayoutNameProfile);
        tilEmail = findViewById(R.id.textInputLayoutEmailProfile);
        tilPassword = findViewById(R.id.textInputLayoutPasswordProfile);
        tillConfirmPassword = findViewById(R.id.textInputLayoutConfirmPasswordProfile);
        btnRegister = findViewById(R.id.buttonSave);
    }

    private boolean isEmpty (TextInputLayout viewName){
        String view = getString(viewName);
        return view.isEmpty();
    }

    private String getString(TextInputLayout viewName) {
        return viewName.getEditText().getText().toString();
    }

    private boolean isEquals(TextInputLayout viewName_1, TextInputLayout viewName_2){
        String view= getString(viewName_1);
        String view_1 = getString(viewName_2);
        return view.equals(view_1);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, LoginActivity.class));
        finishAffinity();
        return;
    }

}
