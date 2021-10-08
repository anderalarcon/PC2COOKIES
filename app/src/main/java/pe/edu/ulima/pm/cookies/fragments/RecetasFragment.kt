package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.Adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta
import pe.edu.ulima.pm.cookies.models.RecetasManager

class RecetasFragment : Fragment() {

    interface onRecetaSelectedListener {
        fun onSelect(receta: Receta)
    }

    private var listener: onRecetaSelectedListener? =null // este listener va tener el evlaor de la interfacxe q va reaccioanr cuando alguien le da clikc

    override fun onAttach(context: Context) {// se va ejecutar apenas adjuntes un fragment con un activity 0000000
        super.onAttach(context)
        listener = context as? onRecetaSelectedListener


    }


    override fun onCreateView(//111111111111111111111111111111111111111111
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //INFLAMOS LA LISTA

        return inflater.inflate(R.layout.fragment_recetas, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//222222222222222222222222222222222222222222222 setear listener o agarrar referencias
        super.onViewCreated(view, savedInstanceState)
        var Manager=RecetasManager()
        Manager.getInstance()//Solo 1 instancia
        var lista = arrayListOf<Ingrediente>()
        lista.add(Ingrediente("qwe"))
        Manager.addReceta(Receta(1,"test","ander",lista))

        val rviProducts = view.findViewById<RecyclerView>(R.id.rviRecetas)//metodo que se llama luego de crearse totalmente el fragmnet
        var ascasc=rviProducts
        ascasc.adapter = RecetaListAdapter(Manager.getRecetas(),this,{ //Esta clase permite mostrar la lista de productos en el recicler view
                receta:Receta ->
            Log.i("ProductFragment",receta.nombre)
            Log.i("ProductFragment",receta.usuario)
           /* listener?.onSelect(receta)*/
        })

        view.findViewById<Button>(R.id.butAgregar).setOnClickListener{
            Manager.addReceta(Receta(2,"test2","qwe",lista))
            rviProducts.adapter?.notifyDataSetChanged()
        }


//el adaptar se ecnarga de enlanzar recicelr view con nuestro modelo
    }
}

