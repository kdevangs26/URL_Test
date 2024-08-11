package com.example.url2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        url = findViewById(R.id.url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlText = url.getText().toString().trim();
                if (!urlText.isEmpty()) {
                    Uri webpage = Uri.parse(urlText);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(MainActivity.this.getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "No application available to handle this URL", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "URL cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Apply system window insets to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private Context getActivity() {
        return null;
    }
}