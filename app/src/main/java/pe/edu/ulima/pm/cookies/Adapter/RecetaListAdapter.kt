package pe.edu.ulima.pm.cookies.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookies.R
import pe.edu.ulima.pm.cookies.models.Receta

class RecetaListAdapter(private val RecetaList: List<Receta>) :
    RecyclerView.Adapter<RecetaListAdapter.ViewHolder>()  {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val iviRecetaImage : ImageView
        val tviRecetaName : TextView
        val tviNombreUsuario : TextView

        init {
            iviRecetaImage = view.findViewById(R.id.iviRecetaImage)
            tviRecetaName = view.findViewById(R.id.tviRecetaName)
            tviNombreUsuario = view.findViewById(R.id.tviNombreUsuario)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_receta, parent, false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviRecetaName.text = RecetaList[position].nombre
        holder.tviNombreUsuario.text = RecetaList[position].usuario
    }

    override fun getItemCount(): Int {
        return RecetaList.size
    }

}