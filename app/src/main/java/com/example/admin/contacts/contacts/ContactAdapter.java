package com.example.admin.contacts.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.contacts.R;
import com.example.admin.contacts.contactdetail.view.DetailActivity;
import com.example.admin.contacts.model.Contact;

import java.util.List;

/**
 * Created by admin on 2/6/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    public static final String CONTACT_KEY = "CONTACT_KEY";
    private List<Contact> contacts;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contact = contact;
        holder.textViewName.setText(contact.getName());
        holder.textViewWorkPhn.setText(contact.getPhone().getWork());
        Glide.with(holder.context).load(contact.getSmallImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewWorkPhn;
        public TextView textViewHomePhn;
        public TextView textViewMobilePhn;
        public Context context;
        public Contact contact;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.idImageContact);
            textViewName = (TextView) itemView.findViewById(R.id.idTextViewName);
            textViewWorkPhn = (TextView) itemView.findViewById(R.id.idTextViewWorkPhn);
            textViewHomePhn = (TextView) itemView.findViewById(R.id.idTextViewHomePhn);
            textViewMobilePhn = (TextView) itemView.findViewById(R.id.idTextViewMobilePhn);
            context = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra(CONTACT_KEY, contact);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
