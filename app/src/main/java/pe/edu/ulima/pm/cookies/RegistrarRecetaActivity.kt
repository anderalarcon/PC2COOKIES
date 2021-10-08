package pe.edu.ulima.pm.cookies

import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegistrarRecetaActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //desactivamos title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_registrar_receta)


        //recibimos la data
        val username = intent.getBundleExtra("data")?.getString("nombre")
        findViewById<TextView>(R.id.tviUser3).text = username
    }
}