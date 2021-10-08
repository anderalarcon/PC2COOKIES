package pe.edu.ulima.pm.cookies.models


class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()

    init {
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
    }

    companion object {
        private var instance : RecetasManager? = null
    }

    fun getInstance() : RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas() : List<Receta> {
        mRecetas.add(Receta(1,"Galletas de mantequilla","Roger",mIngredientes))
        mRecetas.add(Receta(2,"Galletas de mantequilla2","Roger2",mIngredientes))
        return mRecetas
    }

    fun addReceta(receta : Receta) {
        mRecetas.add(receta)
    }

    fun getReceta(id : Int) : Receta? {
        // Debe implementarlo !!!
        return null
    }

    fun getIngredientes() : List<Ingrediente> {
        return mIngredientes
    }


}