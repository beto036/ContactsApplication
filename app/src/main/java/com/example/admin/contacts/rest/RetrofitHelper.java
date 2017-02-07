package com.example.admin.contacts.rest;

import com.example.admin.contacts.model.Contact;
import com.example.admin.contacts.rest.services.ContactsService;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 11/6/16.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://s3.amazonaws.com/";

    public static class Factory {
        private static final String TAG = "RetrofitHelperTAG_";
        private static final TypeAdapter<Boolean> booleanAsIntAdapter = new TypeAdapter<Boolean>() {
            @Override public void write(JsonWriter out, Boolean value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    out.value(value);
                }
            }
            @Override public Boolean read(JsonReader in) throws IOException {
                JsonToken peek = in.peek();
                switch (peek) {
                    case BOOLEAN:
                        return in.nextBoolean();
                    case NULL:
                        in.nextNull();
                        return null;
                    case NUMBER:
                        return in.nextInt() != 0;
                    case STRING:
                        return Boolean.parseBoolean(in.nextString());
                    default:
                        throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + peek);
                }
            }
        };

        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapter(Boolean.class, booleanAsIntAdapter).create()))
                    .client(new OkHttpClient.Builder().build())
                    .build();
        }

        public Call<List<Contact>> getContacts () {
            Retrofit retrofit = create();
            ContactsService contactsService = retrofit.create(ContactsService.class);
            return contactsService.getContacts();
        }
    }

}
