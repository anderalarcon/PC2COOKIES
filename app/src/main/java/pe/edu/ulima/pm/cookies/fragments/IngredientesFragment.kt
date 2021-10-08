package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.IngredientesListAdapter
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager
import javax.net.ssl.ManagerFactoryParameters

class IngredientesFragment : Fragment() {

    interface onIngredienteSelectedListener {
        fun onSelect(ingrediente: Ingrediente)

    }

    private var listener: onIngredienteSelectedListener? =
        null // este listener va tener el evlaor de la interfacxe q va reaccioanr cuando alguien le da clikc

    override fun onAttach(context: Context) {// se va ejecutar apenas adjuntes un fragment con un activity 0000000
        super.onAttach(context)
        listener = context as? onIngredienteSelectedListener


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_ingrediente, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val rviProducts =
            view.findViewById<RecyclerView>(R.id.rviIngredientes)//metodo que se llama luego de crearse totalmente el fragmnet
        var ascasc = rviProducts
        ascasc.adapter = IngredientesListAdapter(
            RecetasManager().getInstance().getIngredientes(),
            this,
            { //Esta clase permite mostrar la lista de productos en el recicler view
                    ingrediente: Ingrediente ->
                Log.i("ProductFragment", ingrediente.nombre)
                listener?.onSelect(ingrediente) // PARA PASAR A OTRO ACTIVITY
            })

    }


}