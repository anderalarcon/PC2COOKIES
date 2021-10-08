package pe.edu.ulima.pm.cookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.fragments.RecetasFragment
import pe.edu.ulima.pm.cookies.fragments.RegistrarRecetaFragment
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager

class MainActivity : AppCompatActivity(), RecetasFragment.onRecetaSelectedListener,
    RegistrarRecetaFragment.interfRegistrarReceta {
    var fragmentActual: String = "Main"
    val fragments = mutableListOf<Fragment>()
    lateinit var etNombre: TextView
    var usuario: String? = null
    var recetasManager: RecetasManager? = null
    var Ingredientes = ArrayList<Ingrediente>()
    var NuevaRecetaNombre: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        usuario = intent.getBundleExtra("data")?.getString("nombre")
        super.onCreate(savedInstanceState)

        //desactivamos title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()

        //mostramos frontend
        setContentView(R.layout.activity_recetas)

        println(usuario)

        if (fragments.size == 0) {
            fragments.add(RecetasFragment())
        }
        fragments.add(RegistrarRecetaFragment())

        recetasManager = RecetasManager().getInstance()


        //Renderizamos por primera vez el fragment en la posicion 0 osea recetas
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.main, fragments[0])

        ft.commit()
        // añadiendo recetas de ejemplo
        if (RecetasManager().getInstance().getRecetas().size == 0) {
            var r1: Receta = Receta(
                1,
                "Recetita 1",
                "Ejemplo",
                listOf(
                    RecetasManager().getInstance().getIngredientes().get(0),
                    RecetasManager().getInstance().getIngredientes().get(1)
                ),
                "test"
            )
            var r2: Receta = Receta(
                2,
                "Recetita 2",
                "Ejemplo",
                listOf(
                    RecetasManager().getInstance().getIngredientes().get(0),
                    RecetasManager().getInstance().getIngredientes().get(1)
                ),
                "test2"
            )
            recetasManager?.addReceta(r1)
            recetasManager?.addReceta(r2)
        }

    }

    private fun changeRecetasMain() {
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main, fragment)
        ft.commit()
        Ingredientes.clear()
        fragmentActual = "Main"

    }

    private fun changetoRegistrarReceta() {

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main, fragments[1])
        ft.commit()
        fragmentActual = "nueva receta"

    }

    override fun onSelect(receta: Receta) {
        print("selecciono receta")
        val listIngredientes: ArrayList<String> = ArrayList()
        println("xd: " + receta.ingredientes.toString())
        println("nombre: " + receta.nombre)
        println("usuario: " + receta.usuario)
        for (i in receta.ingredientes) {
            listIngredientes.add(i.nombre)
        }
        for (i in listIngredientes) {
            println("ingrediente lista:" + i)
        }

        val bundle: Bundle = Bundle()//Almacenamos data
        bundle.putString("id", receta.id.toString())
        bundle.putString("nombre", receta.nombre.toString())
        bundle.putString("usuario", receta.usuario.toString())
        bundle.putStringArrayList("ingredientes", listIngredientes)

        intent.setClass(this, VerRecetaActivity::class.java) //pasamos next activity
        intent.putExtra("data", bundle)//le ponemos al intent que es el que pasa
        startActivity(intent)
    }

    override fun onClick() {
        changetoRegistrarReceta()
    }

    override fun onClickbtnGuardar() {
        changeRecetasMain()
    }

    override fun agregarReceta() {
        val list = arrayListOf<Ingrediente>()
        val input = findViewById<EditText>(R.id.EdtNombreReceta)
        val newRecipe = Receta(1, input.text.toString(), "ander", list, "qwe")

        recetasManager?.addReceta(newRecipe)

        println(recetasManager?.getRecetas()?.size)
    }


}