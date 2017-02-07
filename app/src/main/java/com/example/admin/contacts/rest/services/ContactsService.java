package com.example.admin.contacts.rest.services;

import com.example.admin.contacts.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 1/7/2017.
 */

public interface ContactsService {
    @GET("technical-challenge/Contacts.json")
    Call<List<Contact>> getContacts();

}
