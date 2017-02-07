package com.example.admin.contacts.contacts.view;

import com.example.admin.contacts.model.Contact;

import java.util.List;

/**
 * Created by admin on 2/6/2017.
 */

public interface ContactsView {
    void showProgress();
    void hideProgress();
    void showContacts(List<Contact> contacts);
}
