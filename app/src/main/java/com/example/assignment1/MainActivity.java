package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button btnMoveToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveToSecond =findViewById(R.id.btn_next);

        btnMoveToSecond.setOnClickListener( view ->{{

            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        });

    }

}