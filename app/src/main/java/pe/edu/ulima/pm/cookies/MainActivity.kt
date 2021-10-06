package pe.edu.ulima.pm.cookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.fragments.RecetasFragment

class MainActivity : AppCompatActivity() {
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
}