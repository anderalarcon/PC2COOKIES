package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta

class RegistrarRecetaFragment(val ingreds: ArrayList<Ingrediente>) : Fragment() {
    interface interfRegistrarReceta {
        fun onClickbtnGuardar()
        fun agregarReceta()
        fun onClickBtnIngredientes()

    }

    val listAux: ArrayList<String> = ArrayList()

    private var listener: interfRegistrarReceta? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? interfRegistrarReceta

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        for (i in ingreds) {//al principio es una lista vacia y luego al selecionar se va cambiando por eso cambia a todos ya que en el main utilizamos el mismo
            listAux.add(i.nombre)
        }

        val v = inflater.inflate(R.layout.fragment_registrar_receta, container, false)
        val lay1 = v.findViewById<ListView>(R.id.lviIngredientesAgregar)

        val adaptador: ArrayAdapter<String> =
            ArrayAdapter(requireContext(), R.layout.row , listAux)

        lay1.setAdapter(adaptador)

        return v

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val butGuardar = view.findViewById<Button>(R.id.butGuardarReceta)
        val btnIngrediente = view.findViewById<Button>(R.id.butAgregarIngrediente)

        val input = view.findViewById<EditText>(R.id.EdtNombreReceta)
        btnIngrediente.setOnClickListener {
            listener?.onClickBtnIngredientes()
        }
        butGuardar.setOnClickListener {
            if (input.text.toString() != "") {
                listener?.agregarReceta()
                listener?.onClickbtnGuardar()
            } else {
                Toast.makeText(context, "Ingresa el nombre de la receta", Toast.LENGTH_SHORT).show()
            }

        }
    }
}