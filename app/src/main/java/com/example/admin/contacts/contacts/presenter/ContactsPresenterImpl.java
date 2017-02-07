package com.example.admin.contacts.contacts.presenter;

import android.util.Log;

import com.example.admin.contacts.contacts.view.ContactsView;
import com.example.admin.contacts.model.Contact;
import com.example.admin.contacts.rest.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by admin on 2/6/2017.
 */

public class ContactsPresenterImpl implements ContactsPresenter{

    private static final String TAG = "PresenterTAG_";
    private ContactsView contactsView;
    private RetrofitHelper.Factory factory;

    public ContactsPresenterImpl(ContactsView contactsView, RetrofitHelper.Factory factory) {
        this.contactsView = contactsView;
        this.factory = factory;
    }

    @Override
    public void loadContacts() {
        Log.d(TAG, "loadContacts: ");
        Call<List<Contact>> call = factory.getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> contacts = response.body();
                contactsView.showContacts(contacts);
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());

            }
        });
    }
}
