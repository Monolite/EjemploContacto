package com.monolite.ejemplocontacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.monolite.ejemplocontacto.dm.Contacto;

import java.text.SimpleDateFormat;

public class DisplayContactActivity extends AppCompatActivity {

    private Contacto contacto;

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvMail;
    private TextView tvDescription;
    private TextView tvBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        contacto = (Contacto)getIntent().getSerializableExtra(getString(R.string.act_submited_contact));

        tvName = (TextView)findViewById(R.id.tv_name_value);
        tvPhone = (TextView)findViewById(R.id.tv_phone_value);
        tvMail = (TextView)findViewById(R.id.tv_mail_value);
        tvDescription = (TextView)findViewById(R.id.tv_description_value);
        tvBirthdate = (TextView)findViewById(R.id.tv_birthdate_value);

        if(contacto != null)
        {
            if (contacto.getNombre() != null)
                tvName.setText(contacto.getNombre());

            if (contacto.getTelefono() != null)
                tvPhone.setText(contacto.getTelefono());

            if (contacto.getCorreo() != null)
                tvMail.setText(contacto.getCorreo());

            if (contacto.getDescripcion() != null)
                tvDescription.setText(contacto.getDescripcion());

            if (contacto.getFechaNacimiento() != null) {
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                tvBirthdate.setText(dtf.format(contacto.getFechaNacimiento().getTime()));
            }
        }
    }

    protected void editClick(View view){
        Intent intent = new Intent(this, EditContactActivity.class);

        intent.putExtra(getString(R.string.act_edit_contact), contacto);

        startActivity(intent);
        finish();
    }

}
