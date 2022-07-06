package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    Button btnFirstPage;
    Button submit;
    EditText emailInput;
    EditText passwordFirst;
    EditText passwordRepeat;

//    private static final Pattern PASSWORD_PATTERN =
//            Pattern.compile("^" +
//                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
//                    "(?=\\S+$)" +            // no white spaces
//                    ".{8,}" +                // at least 4 characters
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "$");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        btnFirstPage = findViewById(R.id.back_btn);
        submit = findViewById(R.id.create_btn);
        emailInput = findViewById(R.id.email_input);
        passwordFirst = findViewById(R.id.password_input);
        passwordRepeat = findViewById(R.id.rep_password_input);


        btnFirstPage.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

//        submit.setOnClickListener( view -> {
//            Intent intent = new Intent(this, Success.class);
//            startActivity(intent);
//        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailValidator();
                validatePassword();
//                passwordMatch();
                if (emailValidator()  && validatePassword()){
                    submit.setEnabled(true);
                    Intent intent2 = new Intent(v.getContext(), Success.class);
                    startActivity(intent2);
                }

//            Intent intent2 = new Intent(v.getContext(), Success.class);
//            startActivity(intent2);


            }
//            Intent intent2 = new Intent(this, Success.class);
//
//            startActivity(intent2);
        });

    }

    public boolean emailValidator() {

        // extract the entered data from the EditText
        String emailToText = this.emailInput.getText().toString();

        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            emailInput.setError(null);
            return true;



//            submit.setOnClickListener( view -> {
//                Intent intent2 = new Intent(this, Success.class);
//
//                startActivity(intent2);
//            });

        } else {

            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
            return false;

        }
    }

//    public boolean passwordMatch (){
//        String first = this.passwordFirst.getText().toString();
//        String second = this.passwordRepeat.getText().toString();
//
//        if (first.equals(second)){
//            passwordRepeat.setError(null);
//            return true;
//        }
//        else{
//            Toast.makeText(this, "Password Does Not Match!", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }
//    private void validatePassword(EditText passwordFirst) {
//        String passwordInput = passwordFirst.getText().toString().trim();
//        // if password field is empty
//        // it will display error message "Field can not be empty"
//        if (passwordInput.isEmpty()) {
//            Toast.makeText(this, "Password cant be empty", Toast.LENGTH_SHORT).show();
//
//        }
//
//        // if password does not matches to the pattern
//        // it will display an error message "Password is too weak"
//        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
//            Toast.makeText(this, "Password does not meet requirement!", Toast.LENGTH_SHORT).show();
//
//        } else {
//            passwordFirst.setError(null);
//            submit.setEnabled(true);
//
//        }
//    }


        public boolean validatePassword(){
            Pattern pattern;
            Matcher matcher;
            String passwordInput = passwordFirst.getText().toString().trim();
            final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

            pattern = Pattern.compile(PASSWORD_PATTERN);
            matcher = pattern.matcher(passwordInput);

            if (passwordInput.isEmpty()) {
            Toast.makeText(this, "Password can't be empty", Toast.LENGTH_SHORT).show();
            return false;


        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!matcher.matches()) {
            Toast.makeText(this, "Password does not meet requirement!", Toast.LENGTH_SHORT).show();
            return false;


        } else {
            passwordFirst.setError(null);
            String first = this.passwordFirst.getText().toString();
            String second = this.passwordRepeat.getText().toString();

            if (first.equals(second)){
                passwordRepeat.setError(null);

            }
            else{
            Toast.makeText(this, "Password Does Not Match!", Toast.LENGTH_SHORT).show();
            return false;
            }

            return true;


//        }

        }




//    public void confirmSubmit(){
//        if (validatePassword() && emailValidator()){
//            submit.setEnabled(true);
//            submit.setOnClickListener( view -> {
//                Intent intent2 = new Intent(this, Success.class);
//
//                startActivity(intent2);
//            });
//
//        }
//        else{
//            submit.setEnabled(false);
//        }
//
//    }



}}
