package net.robotdisco.whereareyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by gaelan on 2014-09-22.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // redirect to main page
        }

        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnSignUp:
                signUp();
                break;
        }
    }


    private void login() {
        ParseUser.logInInBackground(etEmail.getText().toString(), etPassword.getText().toString(),
                new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                        } else {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signUp() {
        ParseUser user = new ParseUser();
        user.setUsername(etEmail.getText().toString());
        user.setPassword(etPassword.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
