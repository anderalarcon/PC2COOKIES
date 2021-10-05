package pe.edu.ulima.pm.cookies

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_login)

        etNombre = findViewById(R.id.tviUsuario)

        val intent: Intent = Intent()

        val butLogin: Button = findViewById(R.id.butIngresar)


        butLogin.setOnClickListener { _: View ->
            if(etNombre.text.toString()!=""){
                val bundle:Bundle= Bundle()//Almacenamos data
                bundle.putString("nombre",etNombre.text.toString())

                intent.setClass(this, MainActivity::class.java) //pasamos next activity
                intent.putExtra("data",bundle)//le ponemos al intent que es el que pasa
                startActivity(intent)
            }else{
                Toast.makeText(this,"Ingresa tu nombre",Toast.LENGTH_SHORT).show()
            }



        }


    }
}