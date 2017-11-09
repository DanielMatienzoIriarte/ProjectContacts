package com.example.danmat.projectcontacts;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout textViewFullName = (TextInputLayout) findViewById(R.id.form_textInput_fullName);
        TextInputLayout textViewBirthDate = (TextInputLayout) findViewById(R.id.form_textInput_birthDate);
        TextInputLayout textViewPhone = (TextInputLayout) findViewById(R.id.form_textInput_phone);
        TextInputLayout textViewEmail = (TextInputLayout) findViewById(R.id.form_textInput_email);
        TextInputLayout textViewDetails = (TextInputLayout) findViewById(R.id.form_textInput_contactDesc);

        String fullName = "";
        String birthDate = "";
        String phone = "";
        String email = "";
        String details = "";
/*
        String mYear = String.valueOf(calendar.get(Calendar.YEAR));
        String mMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String mDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        datePicker = (DatePicker) findViewById(R.id.form_datePicker_birthDate);
        textViewBirthDate.getEditText().setText(mYear + '/' + mMonth + '/' + mDay);
*/
        try {
            Bundle params = getIntent().getExtras();
            fullName = params.getString(getResources().getString(R.string.intent_fullName));
            birthDate = params.getString(getResources().getString(R.string.intent_birthDate));
            phone = params.getString(getResources().getString(R.string.intent_phone));
            email = params.getString(getResources().getString(R.string.intent_email));
            details = params.getString(getResources().getString(R.string.intent_details));

        } finally {
            textViewFullName.getEditText().setText(fullName);
            textViewBirthDate.getEditText().setText(birthDate);
            textViewPhone.getEditText().setText(phone);
            textViewEmail.getEditText().setText(email);
            textViewDetails.getEditText().setText(details);
        }

        Button saveButton = (Button) findViewById(R.id.button_saveForm);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ContactDto newContact;

                TextInputLayout contactFullName = (TextInputLayout) findViewById(R.id.form_textInput_fullName);
                TextInputLayout contactBirthDate = (TextInputLayout) findViewById(R.id.form_textInput_birthDate);
                TextInputLayout contactPhone = (TextInputLayout) findViewById(R.id.form_textInput_phone);
                TextInputLayout contactEmail = (TextInputLayout) findViewById(R.id.form_textInput_email);
                TextInputLayout contactDesc = (TextInputLayout) findViewById(R.id.form_textInput_contactDesc);

                newContact = new ContactDto(
                        contactFullName.getEditText().getText().toString(),
                        contactBirthDate.getEditText().getText().toString(),
                        contactPhone.getEditText().getText().toString(),
                        contactEmail.getEditText().getText().toString()
                );
                newContact.setDetails(contactDesc.getEditText().getText().toString());

                Intent intent = new Intent(MainActivity.this, ContactDetail.class);
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
