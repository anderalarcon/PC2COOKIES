package pe.edu.ulima.pm.cookies.models

import kotlin.random.Random


class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()
    private val imagenes = arrayListOf<String>()

    init {//Inicializamos valores iniciales
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))

        imagenes.add("https://cdn7.kiwilimon.com/recetaimagen/3329/640x426/th5-640x426-38990.jpg.webp")
        imagenes.add("https://www.recetasderechupete.com/wp-content/uploads/2020/04/Galletas-crujientes-chocolate-768x530.jpg")
        imagenes.add("https://d1kxxrc2vqy8oa.cloudfront.net/wp-content/uploads/2020/06/11193105/RFB-1305-3-galletasdemantequilla-annarecetasfacilescom.jpg")
        imagenes.add("https://t2.rg.ltmcdn.com/es/images/7/6/2/galletas_faciles_y_rapidas_32267_600.jpg")
        imagenes.add("https://www.bettycrocker.lat/wp-content/uploads/2020/12/BClatam-recipe-galletas-arcoirirs.png")

    }

    companion object {
        //reemplzao de static | Patron Singleton
        private var instance: RecetasManager? = null
    }

    fun getInstance(): RecetasManager {//Inicializamos
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas(): List<Receta> {
        return mRecetas
    }

    fun addReceta(receta: Receta) {
        mRecetas.add(receta)
    }

    fun getReceta(id: Int): Receta? {
        // Debe implementarlo !!!
        return null
    }

    fun getIngredientes(): List<Ingrediente> {
        return mIngredientes
    }

    fun getImagenes():List<String>{
        return imagenes
    }

    fun deleteIngrediente(ingrediente:Ingrediente){
        mIngredientes.remove(ingrediente)

    }

    fun mostrarIngredientes(){
        for (i in mIngredientes){
            println(i.nombre)
        }
    }

    fun getRandom(): String {
        var imgs=getImagenes()

        var nro = Random.nextInt(imgs.size)

        return imgs[nro]

    }

    fun vaciarIngredientes(){
        mIngredientes.clear()

    }

    fun llenarIngredientes(){
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
    }


}