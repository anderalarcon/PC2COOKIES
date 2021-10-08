package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager

class RecetasFragment : Fragment() {

    interface onRecetaSelectedListener {
        fun onSelect(receta: Receta)
    }

    private var listener: onRecetaSelectedListener? =null // este listener va tener el evlaor de la interfacxe q va reaccioanr cuando alguien le da clikc

    override fun onAttach(context: Context) {// se va ejecutar apenas adjuntes un fragment con un activity
        super.onAttach(context)
        listener = context as? onRecetaSelectedListener

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
        val rviProducts = view.findViewById<RecyclerView>(R.id.rviRecetas)//metodo que se llama luego de crearse totalmente el fragmnet
        rviProducts.adapter = RecetaListAdapter(RecetasManager().getRecetas(),this,{ //Esta clase permite mostrar la lista de productos en el recicler view
                receta:Receta ->
            Log.i("ProductFragment",receta.nombre)
            Log.i("ProductFragment",receta.usuario)
            listener?.onSelect(receta)
        })

//el adaptar se ecnarga de enlanzar recicelr view con nuestro modelo
    }
}

