package dominio.prode

class Usuario (
    var username : String,
    var fotoPerfil : String,
    var email : String
) {
    val prodes = mutableListOf<Prode>()
    lateinit var prode : Prode

    fun iniciar (primerProde : Prode) {
        prode = primerProde
        archivarProde()
    }

    fun puntosAcumulados (): Int =
        prodes.sumOf { it.puntos }


    fun armarProde(idPartido : Int, golLocal : Int, golVisita : Int) {
        prode.partidos.find { it.id == idPartido }?.setearResultado(golLocal, golVisita)
    }

    fun cierreDeFecha (plantillaProde : Prode) {
        archivarProde()
        cargarProdeNuevaFecha(plantillaProde)
    }

    fun archivarProde() =
        prodes.add(prode)

    fun cargarProdeNuevaFecha(plantillaProde: Prode) {
        prode = plantillaProde
    }
}