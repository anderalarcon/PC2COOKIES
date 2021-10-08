package pe.edu.ulima.pm.cookies.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Ingrediente

class IngredientesListAdapter(
    private val IngredienteList: List<Ingrediente>,
    private val fragment : Fragment,
    private val listener : (Ingrediente) -> Unit
): RecyclerView.Adapter<IngredientesListAdapter.ViewHolder>() {

    class ViewHolder(view: View, val listener : (Ingrediente) -> Unit, val IngredienteList : List<Ingrediente>):
        RecyclerView.ViewHolder(view), View.OnClickListener
    {
        val textIngrediente : TextView
        init {
            textIngrediente = view.findViewById(R.id.tviIngredienteSeleccionar)
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            listener(IngredienteList[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ingrediente, parent, false)
        val viewHolder = ViewHolder(view, listener, IngredienteList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textIngrediente.text = IngredienteList[position].nombre
    }

    override fun getItemCount(): Int {
        println("cantidad:" + IngredienteList.size)
        return IngredienteList.size
    }
}