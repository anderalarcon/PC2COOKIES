package pe.edu.ulima.pm.cookies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.RecetasManager

class RecetasFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //activity.metodoCualquiera()
        return inflater.inflate(R.layout.fragment_recetas,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviProducts = view.findViewById<RecyclerView>(R.id.rviRecetas)
        rviProducts.adapter = RecetaListAdapter(RecetasManager().getRecetas())
    }
}