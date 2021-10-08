package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager

class RecetasFragment : Fragment() {

    interface onRecetaSelectedListener {
        fun onSelect(receta: Receta)
        fun onClick()
    }

    private var listener: onRecetaSelectedListener? =
        null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? onRecetaSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recetas, container, false)

    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val butAgregar = view.findViewById<Button>(R.id.butAgregar)

        butAgregar.setOnClickListener {
            listener?.onClick()
        }

        val rviProducts =
            view.findViewById<RecyclerView>(R.id.rviRecetas)
        rviProducts.adapter = RecetaListAdapter(
            RecetasManager().getInstance().getRecetas(),
            this
        ) { receta: Receta ->
            Log.i("RecetaFragment", receta.nombre)
            listener?.onSelect(receta)
        }


    }
}

