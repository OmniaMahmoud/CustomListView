package com.example.nh.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView contactsListView;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsListView = findViewById(R.id.contacts_list);
        Contact c1 = new Contact("omnia", "hello", R.drawable.ic_launcher_foreground);
        Contact c2 = new Contact("omar", "how are you", R.drawable.ic_launcher_background);
        Contact c3 = new Contact("mahmoud", "hi", R.mipmap.ic_launcher);
        Contact c4 = new Contact("nada", "what about android course?", R.mipmap.ic_launcher_round);
        Contact c5 = new Contact("ahmed", "hello", R.drawable.ic_launcher_background);

        contacts = new ArrayList<>();
        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(c5);

        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        contactsListView.setAdapter(adapter);
        contactsListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView name = view.findViewById(R.id.name);
        Toast.makeText(this, name.getText().toString(), Toast.LENGTH_LONG).show();

        Contact contact = contacts.get(position);
        Intent intent = new Intent(this,ContactDetailsActivity.class);
        intent.putExtra("contact_details",contact);
        startActivity(intent);
    }
}
