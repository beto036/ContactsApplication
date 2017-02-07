package com.example.admin.contacts.contacts.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.contacts.R;
import com.example.admin.contacts.contacts.ContactAdapter;
import com.example.admin.contacts.contacts.presenter.ContactsPresenterImpl;
import com.example.admin.contacts.model.Contact;
import com.example.admin.contacts.rest.RetrofitHelper;

import java.util.List;

public class ContactsActivity extends AppCompatActivity implements ContactsView{

    private ContactsPresenterImpl contactsPresenter;
    private ContactAdapter contactAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.idRecyclerView);
        contactsPresenter = new ContactsPresenterImpl(this, new RetrofitHelper.Factory());
        contactsPresenter.loadContacts();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showContacts(List<Contact> contacts) {
        contactAdapter = new ContactAdapter(contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(contactAdapter);
        contactAdapter.notifyDataSetChanged();
    }
}
