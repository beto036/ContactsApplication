package com.example.admin.contacts.contactdetail.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.contacts.R;
import com.example.admin.contacts.contacts.ContactAdapter;
import com.example.admin.contacts.model.Contact;

public class DetailActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewCompany;
    private TextView textViewPhoneHome;
    private TextView textViewPhoneWork;
    private TextView textViewPhoneMobile;
    private TextView textViewAddress1;
    private TextView textViewAddress2;
    private TextView textViewEmail;
    private ImageView imageView;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        contact = getIntent().getParcelableExtra(ContactAdapter.CONTACT_KEY);
        String address = contact.getAddress().getCity() + ", " + contact.getAddress().getState() + " " + contact.getAddress().getZip();
        textViewName = (TextView) findViewById(R.id.detailTextViewName);
        textViewCompany = (TextView) findViewById(R.id.detailTextViewCompany);
        textViewPhoneHome = (TextView) findViewById(R.id.detailTextViewPhoneHome);
        textViewPhoneWork = (TextView) findViewById(R.id.detailTextViewPhoneWork);
        textViewPhoneMobile = (TextView) findViewById(R.id.detailTextViewPhoneMobile);
        textViewAddress1 = (TextView) findViewById(R.id.detailTextViewAddress1);
        textViewAddress2 = (TextView) findViewById(R.id.detailTextViewAddress2);
        textViewEmail = (TextView) findViewById(R.id.detailTextViewEmail);
        imageView = (ImageView) findViewById(R.id.detailImageView);

        textViewName.setText(contact.getName());
        textViewCompany.setText(contact.getCompany());
        textViewPhoneHome.setText(contact.getPhone().getHome());
        textViewPhoneWork.setText(contact.getPhone().getWork());
        textViewPhoneMobile.setText(contact.getPhone().getMobile());
        textViewAddress1.setText(contact.getAddress().getStreet());
        textViewAddress2.setText(address);
        textViewEmail.setText(contact.getEmail());
        Glide.with(this).load(contact.getLargeImageURL()).into(imageView);
    }
}
