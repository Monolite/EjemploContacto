package com.monolite.ejemplocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.monolite.ejemplocontacto.dm.Contacto;

import java.util.Date;
import java.util.GregorianCalendar;

public class EditContactActivity extends AppCompatActivity {

    private Contacto contacto;

    private EditText etName;
    private EditText etPhone;
    private EditText etMail;
    private EditText etDescription;
    private DatePicker dpBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        if(getIntent() != null){
            contacto = (Contacto)getIntent().getSerializableExtra(getString(R.string.act_edit_contact));
        }

        if(contacto == null)
            contacto = new Contacto();

        etName = (EditText)findViewById(R.id.name);
        etPhone = (EditText)findViewById(R.id.phone);
        etMail = (EditText)findViewById(R.id.mail);
        etDescription = (EditText)findViewById(R.id.description);
        dpBirthdate = (DatePicker)findViewById(R.id.birthdate);

        if(contacto.getNombre() != null)
            etName.setText(contacto.getNombre());

        if(contacto.getTelefono() != null)
            etPhone.setText(contacto.getTelefono());

        if(contacto.getCorreo() != null)
            etMail.setText(contacto.getCorreo());

        if(contacto.getDescripcion() != null)
            etDescription.setText(contacto.getDescripcion());

        if(contacto.getFechaNacimiento() != null){
            GregorianCalendar d = contacto.getFechaNacimiento();

            dpBirthdate.updateDate(d.get(GregorianCalendar.YEAR),
                    d.get(GregorianCalendar.MONTH),
                    d.get(GregorianCalendar.DAY_OF_MONTH));
        }

    }

    protected void siguienteClick(View view){

        setContacto();

        Intent intent = new Intent(this, DisplayContactActivity.class);

        intent.putExtra(getString(R.string.act_submited_contact), contacto);

        startActivity(intent);
        finish();
    }

    protected void setContacto(){
        contacto.setNombre(etName.getText().toString());
        contacto.setTelefono(etPhone.getText().toString());
        contacto.setCorreo(etMail.getText().toString());
        contacto.setDescripcion(etDescription.getText().toString());

        GregorianCalendar fechaNacimiento = (GregorianCalendar) GregorianCalendar.getInstance();

        fechaNacimiento.set(dpBirthdate.getYear(), dpBirthdate.getMonth(), dpBirthdate.getDayOfMonth());

        contacto.setFechaNacimiento(fechaNacimiento);

    }
}
