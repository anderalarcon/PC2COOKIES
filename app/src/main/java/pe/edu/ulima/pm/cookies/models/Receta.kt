package pe.edu.ulima.pm.cookies.models

data class Receta(
    val id : Int,
    val nombre : String,
    val usuario : String,
    val ingredientes : List<Ingrediente> = arrayListOf(),
    val imagen:String
)