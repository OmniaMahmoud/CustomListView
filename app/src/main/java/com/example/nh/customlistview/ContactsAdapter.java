package com.example.nh.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ContactsAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private ArrayList<Contact> contacts;

    public ContactsAdapter(@NonNull Context context, @NonNull ArrayList<Contact> contacts) {
        super(context, R.layout.contact_row, contacts);
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.contact_row,parent,false);
        TextView name = view.findViewById(R.id.name);
        TextView lastMessage = view.findViewById(R.id.last_message);
        ImageView image = view.findViewById(R.id.image);

        name.setText(contacts.get(position).getName());
        lastMessage.setText(contacts.get(position).getLastMessage());
        image.setImageResource(contacts.get(position).getImage());

        return view;
    }
}
