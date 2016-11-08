package ylse_matinez.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ActivityDetalleContacto extends AppCompatActivity {

    private TextView tvDatoNombre;
    private TextView tvDatoTelefono;
    private TextView tvDatoEmail;
    private TextView tvDatoDescripcion;
    private TextView tvDatoFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String fecha = parametros.getString(getResources().getString(R.string.pfechaNac));
        Button btnEditar = (Button) findViewById(R.id.btnEditar);

         tvDatoNombre = (TextView) findViewById(R.id.tvDatoNombre);
         tvDatoEmail = (TextView) findViewById(R.id.tvDatoEmail);
         tvDatoTelefono = (TextView) findViewById(R.id.tvDatoTelefono);
         tvDatoDescripcion = (TextView) findViewById(R.id.tvDatoDescripcion);
         tvDatoFecha = (TextView) findViewById(R.id.tvDatoFechaNac);

          tvDatoNombre.setText(nombre);
          tvDatoEmail.setText(email);
          tvDatoTelefono.setText(telefono);
          tvDatoDescripcion.setText(descripcion);
          tvDatoFecha.setText(fecha);

         btnEditar.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(ActivityDetalleContacto.this,MainActivity.class);
                 //startActivity(intent);
                 onRestart();
                 finish();
             }
         }
         );
    }





    //btnSiguiente.setOnClickListener(new OnClickListener)

    /*    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent =  new Intent(ActivityDetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }*/


}
