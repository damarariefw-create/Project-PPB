package com.example.projectppb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    public void toast(View view) {
        Toast.makeText(this, R.string.greeting, Toast.LENGTH_LONG).show();
    }

    public void countNumber(View view) {
        Button button = findViewById(R.id.count);
        TextView number = findViewById(R.id.number);
        int currentCount = Integer.parseInt(number.getText().toString());
        currentCount++;
        number.setText(String.valueOf(currentCount));

        if (currentCount == 10) {
            number.setBackgroundColor(getResources().getColor(R.color.red));
            number.setTextColor(getResources().getColor(R.color.white));
            button.setText(R.string.reset);
            button.setBackgroundTintList(getResources().getColorStateList(R.color.red));
        } else if (currentCount == 11) {
            number.setText(R.string.number);
            number.setBackgroundColor(getResources().getColor(R.color.gray));
            number.setTextColor(getResources().getColor(R.color.blue));
            button.setText(R.string.count);
            button.setBackgroundTintList(getResources().getColorStateList(R.color.blue));
        }
    }
}
