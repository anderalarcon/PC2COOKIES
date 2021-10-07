package pe.edu.ulima.pm.cookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.fragments.RecetasFragment
import pe.edu.ulima.pm.cookies.models.Receta

class MainActivity : AppCompatActivity() , RecetasFragment.OnRecetasSelectedListener{
    private val fragments = mutableListOf<Fragment>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_recetas)
        //recibimos la data
        val username=intent.getBundleExtra("data")?.getString("nombre")
        findViewById<TextView>(R.id.tviUser).text=username


        //Recibimos las recetas en duro
        fragments.add(RecetasFragment())

        //Renderizamos por primera vez el fragment en la posicion 0 osea recetas
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.contenedorRecetas,fragments[0])

        ft.commit()
    }

    override fun onSelect(receta: Receta) {
        val listIngredientes: ArrayList<String> = ArrayList()
        println("xd: " + receta.ingredientes.toString())
        println("nombre: " + receta.nombre)
        println("usuario: " + receta.usuario)
        for (i in receta.ingredientes){
            listIngredientes.add(i.nombre)
        }
        for (i in listIngredientes){
            println("ingrediente lista:" + i)
        }

        val bundle:Bundle= Bundle()//Almacenamos data
        bundle.putString("id",receta.id.toString())
        bundle.putString("nombre",receta.nombre.toString())
        bundle.putString("usuario",receta.usuario.toString())
        bundle.putStringArrayList("ingredientes",listIngredientes)

        intent.setClass(this, VerRecetaActivity::class.java) //pasamos next activity
        intent.putExtra("data",bundle)//le ponemos al intent que es el que pasa
        startActivity(intent)
    }
}