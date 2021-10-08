package pe.edu.ulima.pm.cookies

import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerRecetaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //desactivamos title bar
/*        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()*/

        super.onCreate(savedInstanceState)
        setTitle("Viendo Receta")

        setContentView(R.layout.activity_ver_receta)
        val name_galleta = intent.getBundleExtra("data")?.getString("nombre")
        val list_ingredientes = intent.getBundleExtra("data")?.getStringArrayList("ingredientes")
        findViewById<TextView>(R.id.tviNombreReceta).text = name_galleta
        println("pasa 1")
        for (i in list_ingredientes!!) {
            print("ingrediente lista:" + i)
        }
        println("pasa 2")


        val lay1 = findViewById<ListView>(R.id.lviIngredientes)
        val adaptador: ArrayAdapter<String> =
            ArrayAdapter(this, R.layout.row, list_ingredientes)

        lay1.setAdapter(adaptador)

    }
}