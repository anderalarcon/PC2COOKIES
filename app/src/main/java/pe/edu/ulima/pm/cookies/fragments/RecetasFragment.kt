package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.RecetasManager

class RecetasFragment : Fragment() {

    interface onRecetaClick {
        fun onClick(fragmentName: String)
    }

    private var listener: onRecetaClick? =
        null // este listener va tener el evlaor de la interfacxe q va reaccioanr cuando alguien le da clikc

    override fun onAttach(context: Context) {// se va ejecutar apenas adjuntes un fragment con un activity
        super.onAttach(context)
        listener = context as? onRecetaClick

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //INFLAMOS LA LISTA
        return inflater.inflate(R.layout.fragment_recetas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receta=view.findViewById<RecyclerView>(R.id.rviRecetas)
        receta.setOnClickListener{
            println("qwe")
        }

        //CON ESTO RENDERIZAMOS CADA ITEM DE LA LISTA
        val rviProducts = view.findViewById<RecyclerView>(R.id.rviRecetas)
        rviProducts.adapter = RecetaListAdapter(RecetasManager().getRecetas())


    }
}