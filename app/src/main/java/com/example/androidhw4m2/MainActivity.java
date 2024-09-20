package com.example.androidhw4m2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText firstEditText = findViewById(R.id.firstEditText);
        EditText secondEditText = findViewById(R.id.secondEditText);
        Button signInButton = findViewById(R.id.signInButton);

        signInButton.setOnClickListener(view -> {
            if (firstEditText.getText().toString().equals("admin") && secondEditText.getText().toString().equals("admin")) {
                Snackbar.make(signInButton, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();
                findViewById(R.id.enterTextView).setVisibility(View.INVISIBLE);
                findViewById(R.id.signInTextView).setVisibility(View.INVISIBLE);
                findViewById(R.id.firstEditText).setVisibility(View.INVISIBLE);
                findViewById(R.id.secondEditText).setVisibility(View.INVISIBLE);
                findViewById(R.id.signInButton).setVisibility(View.INVISIBLE);
                findViewById(R.id.forgotPasswordTextView).setVisibility(View.INVISIBLE);
            } else {
                Snackbar.make(signInButton, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });

        firstEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    signInButton.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.bg_btn));
                } else {
                    signInButton.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.bg_btn_orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}