package pe.edu.ulima.pm.cookies.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente
import pe.edu.ulima.pm.cookies.models.Receta

class RegistrarRecetaFragment:Fragment() {
    interface interfRegistrarReceta{
        fun onClickbtnGuardar()
        fun agregarReceta()

    }

    private var listener:interfRegistrarReceta?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener=context as? interfRegistrarReceta

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registrar_receta,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val butGuardar=view.findViewById<Button>(R.id.butGuardarReceta)

  /*      val input=view.findViewById<EditText>(R.id.EdtNombreReceta)
        val list= arrayListOf<Ingrediente>()
        list.add(Ingrediente("qwe"))
        val newRecipe=Receta(1,input.text.toString(),"probando",list,"test")*/
        butGuardar.setOnClickListener{
            listener?.agregarReceta()
            listener?.onClickbtnGuardar()
        }
    }
}