package pe.edu.ulima.pm.cookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.Adapter.IngredientesListAdapter
import pe.edu.ulima.pm.cookies.fragments.IngredientesFragment
import pe.edu.ulima.pm.cookies.fragments.RecetasFragment
import pe.edu.ulima.pm.cookies.fragments.RegistrarRecetaFragment
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager

class MainActivity : AppCompatActivity(), RecetasFragment.onRecetaSelectedListener,
    IngredientesFragment.onIngredienteSelectedListener,
    RegistrarRecetaFragment.interfRegistrarReceta {
    var fragmentActual: String = "Main"
    val fragments = mutableListOf<Fragment>()
    lateinit var etNombre: TextView
    var usuario: String? = null
    var recetasManager: RecetasManager? = null
    var Ingredientes = ArrayList<Ingrediente>()
    var NuevaRecetaNombre: String? = null
    var IngredientesAux = ArrayList<Ingrediente>()


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
        //fragments.add(RegistrarRecetaFragment())
        fragments.add(IngredientesFragment())

        recetasManager = RecetasManager().getInstance()


        //Renderizamos por primera vez el fragment en la posicion 0 osea recetas
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.main, fragments[0])

        ft.commit()
        // añadiendo recetas de ejemplo
        if (RecetasManager().getInstance().getRecetas().size == 0) {
            var r1: Receta = Receta(
                1,
                "Receta 1",
                "Ander",
                listOf(
                    RecetasManager().getInstance().getIngredientes().get(0),
                    RecetasManager().getInstance().getIngredientes().get(1)
                ),
                "https://recetinas.com/wp-content/uploads/2017/09/cookiess-de-chocolate.jpg"
            )
            var r2: Receta = Receta(
                2,
                "Receta 2",
                "Rolonio Jr",
                listOf(
                    RecetasManager().getInstance().getIngredientes().get(0),
                    RecetasManager().getInstance().getIngredientes().get(1)
                ),
                "https://www.altavoz.net/altavoz/site/artic/20200217/imag/xfoto_0000000220200217101506.jpg.pagespeed.ic.nuXkFIntqC.webp"
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

    private fun changeSelectIngredienteFragment() {
        println("SelectIngredienteFragment")
        //val fragment = AccountFragment(this)
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        //remplazar un nuevo fragment
        ft.replace(R.id.main, fragment)
        ft.commit()
    }

    private fun changetoRegistrarReceta() {

        val fragment = RegistrarRecetaFragment(IngredientesAux)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main, fragment /*fragments[1]*/)
        ft.commit()
        fragmentActual = "nueva receta"

    }

    override fun onSelect(receta: Receta) {
        print("selecciono receta")
        val listIngredientes: ArrayList<String> = ArrayList()
        for (i in receta.ingredientes) {
            listIngredientes.add(i.nombre)
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
        var random = recetasManager?.getRandom()
        val list = arrayListOf<Ingrediente>()
        val input = findViewById<EditText>(R.id.EdtNombreReceta)
        val newRecipe = Receta(1, input.text.toString(), usuario!!, IngredientesAux, random!!)
        recetasManager?.addReceta(newRecipe)
        println(recetasManager?.getRecetas()?.size)
        input.setText("")
        recetasManager?.vaciarIngredientes()
        recetasManager?.llenarIngredientes()
    }

    override fun onSelect(ingrediente: Ingrediente) {
        //ingredientexd = ingrediente.nombre
        IngredientesAux.add(ingrediente)
        recetasManager?.deleteIngrediente(ingrediente)

        changetoRegistrarReceta()
        Toast.makeText(this, "Seleccionó: " + ingrediente.nombre, Toast.LENGTH_SHORT).show()
    }

    override fun onClickBtnIngredientes() {
        changeSelectIngredienteFragment()
    }


}