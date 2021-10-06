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
    RecyclerView.Adapter<RecetaListAdapter.ViewHolder>()  {// clase que va representar 1 item visual , este necesita los elementos del item , implementamos los metodos que solicita
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {//FRONTEND
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_receta, parent, false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//ATRIBUTOS
        holder.tviRecetaName.text = RecetaList[position].nombre
        holder.tviNombreUsuario.text = RecetaList[position].usuario
    }

    override fun getItemCount(): Int {//CUANTOS SON
        return RecetaList.size
    }

}