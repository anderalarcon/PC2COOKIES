package pe.edu.ulima.pm.cookies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.R

class RecetasFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //activity.metodoCualquiera()
        return inflater.inflate(R.layout.fragment_recetas,container,false)
    }
}