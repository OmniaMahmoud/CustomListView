package com.example.nh.customlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailsActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name,message;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        message = findViewById(R.id.last_message);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact_details");
        image.setImageResource(contact.getImage());
        name.setText(contact.getName());
        message.setText(contact.getLastMessage());

        Log.e("omnia","omnia");
    }
}
