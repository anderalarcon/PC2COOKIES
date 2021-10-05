package pe.edu.ulima.pm.cookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View

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


        fragments.add(RecetasFragment())
        //1.No vas a poder dar click en el view si lo haces en duro o saldrá con problemas
        //2.Trata de no usar constraint layout
        //3.ITEM RECETA HACERLO CON CUSTOM VIEW
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent,fragments[0])

        ft.commit()
    }

    //override fun OnClick(it)
}