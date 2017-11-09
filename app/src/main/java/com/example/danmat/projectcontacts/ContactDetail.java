package com.example.danmat.projectcontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Bundle params = getIntent().getExtras();
        String fullName = params.getString(getResources().getString(R.string.intent_fullName));
        String birthDate = params.getString(getResources().getString(R.string.intent_birthDate));
        String phone = params.getString(getResources().getString(R.string.intent_phone));
        String email = params.getString(getResources().getString(R.string.intent_email));
        String details = params.getString(getResources().getString(R.string.intent_details));

        TextView textViewFullName = (TextView) findViewById(R.id.contactName);
        TextView textViewBirthDate = (TextView) findViewById(R.id.contactBdate);
        TextView textViewPhone = (TextView) findViewById(R.id.contactPhone);
        TextView textViewEmail = (TextView) findViewById(R.id.contactEmail);
        TextView textViewDetails = (TextView) findViewById(R.id.contactDescription);

        textViewFullName.setText(fullName);
        textViewBirthDate.setText(birthDate);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
        textViewDetails.setText(details);

        Button editButton = (Button) findViewById(R.id.button_editForm);
        editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ContactDto newContact;

                TextView contactFullName = (TextView) findViewById(R.id.contactName);
                TextView contactBirthDate = (TextView) findViewById(R.id.contactBdate);
                TextView contactPhone = (TextView) findViewById(R.id.contactPhone);
                TextView contactEmail = (TextView) findViewById(R.id.contactEmail);
                TextView contactDetails = (TextView) findViewById(R.id.contactDescription);

                newContact = new ContactDto(
                        contactFullName.getText().toString(),
                        contactBirthDate.getText().toString(),
                        contactPhone.getText().toString(),
                        contactEmail.getText().toString()
                );
                newContact.setDetails(contactDetails.getText().toString());

                Intent intent = new Intent(ContactDetail.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.intent_fullName), newContact.getFullName());
                intent.putExtra(getResources().getString(R.string.intent_birthDate), newContact.getBirthdate());
                intent.putExtra(getResources().getString(R.string.intent_phone), newContact.getPhone());
                intent.putExtra(getResources().getString(R.string.intent_email), newContact.getEmail());
                intent.putExtra(getResources().getString(R.string.intent_details), newContact.getDetails());
                startActivity(intent);
            }
        });
    }
}
