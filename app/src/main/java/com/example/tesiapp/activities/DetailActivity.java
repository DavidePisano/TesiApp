package com.example.tesiapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tesiapp.R;

public class DetailActivity extends AppCompatActivity {

    TextView productDescription;
    ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        productDescription = (TextView) findViewById(R.id.txtDescription);
        productImage = (ImageView) findViewById(R.id.ivImage2);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle!=null) {

            productDescription.setText(mBundle.getString("Description"));
            productImage.setImageResource(mBundle.getInt("Image"));
        }
    }
}