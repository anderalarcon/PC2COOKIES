package pe.edu.ulima.pm.cookies

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerRecetaActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_receta)
        val name_galleta=intent.getBundleExtra("data")?.getString("nombre")
        val list_ingredientes = intent.getBundleExtra("data")?.getStringArrayList("ingredientes")
        findViewById<TextView>(R.id.tviNombreReceta).text=name_galleta
        println("pasa 1")
        for (i in list_ingredientes!!){
            print("ingrediente lista:" + i)
        }
        println("pasa 2")
        val listAux: ArrayList<String> = ArrayList()
        listAux.add("papa1")
        listAux.add("papa2")
        listAux.add("papa3")
        listAux.add("papa4")

        val lay1 = findViewById<ListView>(R.id.lviIngredientes)
        val adaptador : ArrayAdapter<String>  =ArrayAdapter(this,android.R.layout.simple_list_item_1,list_ingredientes)

        lay1.setAdapter(adaptador)

    }
    }
