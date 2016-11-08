package ylse_matinez.formulariocontactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppCompatEditText nombre = (AppCompatEditText) findViewById(R.id.tetNombre) ;
        final AppCompatEditText telefono = (AppCompatEditText) findViewById(R.id.tetTelefono) ;
        final AppCompatEditText email = (AppCompatEditText) findViewById(R.id.tetEmail);
        final AppCompatEditText descripcion = (AppCompatEditText) findViewById(R.id.tetDescripcionContacto) ;
        final AppCompatEditText fechaNacimiento = (AppCompatEditText) findViewById(R.id.tetFechaNac) ;
        Button btnSiguiente = (Button) findViewById(R.id.btSiguiente);
        Button btnCalendario = (Button) findViewById(R.id.btnCalendario);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreCompleto = nombre.getText().toString();
                String emailContacto = email.getText().toString();
                String telefonoContacto = telefono.getText().toString();
                String descripcionContac = descripcion.getText().toString();
                String fechaNac = fechaNacimiento.getText().toString();

                Intent intent = new Intent(MainActivity.this, ActivityDetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), nombreCompleto);
                intent.putExtra(getResources().getString(R.string.pemail),emailContacto);
                intent.putExtra(getResources().getString(R.string.ptelefono),telefonoContacto);
                intent.putExtra(getResources().getString(R.string.pdescripcion),descripcionContac);
                intent.putExtra(getResources().getString(R.string.pfechaNac),fechaNac);
                startActivity(intent);
            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            Log.w("DatePicker", day + "/" + (month++) + '/' + year);
           // fechaNacimiento = (TextView) findViewById(R.id.tvDatoFechaNac);
            ((TextView) getActivity().findViewById(R.id.tetFechaNac)).setText((day + "/" + (month++) + '/' + year));

        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



}
