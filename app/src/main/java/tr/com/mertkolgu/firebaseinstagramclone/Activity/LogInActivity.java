package tr.com.mertkolgu.firebaseinstagramclone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tr.com.mertkolgu.firebaseinstagramclone.R;

public class LogInActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText mailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        mailText = findViewById(R.id.editTextMail);
        passwordText = findViewById(R.id.editTextPassword);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signInClicked(View view) {
        String mail = mailText.getText().toString();
        String password = passwordText.getText().toString();

        if (mail.matches("") && password.matches("")) {
            Toast.makeText(LogInActivity.this, "Mail adresi ve parola boş olamaz!", Toast.LENGTH_LONG).show();
        } else if (mail.matches("") || password.matches("")) {
            Toast.makeText(LogInActivity.this, "Mail adresi veya parola boş olamaz!", Toast.LENGTH_LONG).show();
        } else {
            firebaseAuth.signInWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LogInActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void signUpClicked(View view) {
        String mail = mailText.getText().toString();
        String password = passwordText.getText().toString();

        if (mail.matches("") && password.matches("")) {
            Toast.makeText(LogInActivity.this, "Mail adresi ve parola boş olamaz!", Toast.LENGTH_LONG).show();
        } else if (mail.matches("") || password.matches("")) {
            Toast.makeText(LogInActivity.this, "Mail adresi veya parola boş olamaz!", Toast.LENGTH_LONG).show();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(LogInActivity.this, "User created!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LogInActivity.this, FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LogInActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
