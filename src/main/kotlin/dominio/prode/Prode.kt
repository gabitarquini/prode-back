package dominio.prode

class Prode () {
    var puntos : Int = 0
    val partidos = mutableListOf<Partido>()

    fun chequearPuntos(resultadosVerdaderos : MutableList<Partido>){
        resultadosVerdaderos.forEach { partidoReal -> evaluar(
            partidos.find{ it.id == partidoReal.id}!!,
            partidoReal)}
    }

    fun evaluar (partidoReal : Partido, partidoPronosticado : Partido) {
        puntos = 0
        val puntosPartido = (0 + evaluarPorResultado(partidoReal, partidoPronosticado) + evaluarPorGoles(partidoReal, partidoPronosticado)) * bonificacionCapitan(partidoPronosticado)
        puntos += puntosPartido
    }

    fun evaluarPorResultado (partidoReal : Partido, partidoPronosticado : Partido) =
        if (partidoReal.resultado == partidoPronosticado.resultado) 1 else 0

    fun evaluarPorGoles (partidoReal : Partido, partidoPronosticado : Partido) =
        if (partidoReal.goles == partidoPronosticado.goles) 2 else 0

    fun bonificacionCapitan(partidoPronosticado : Partido) =
        if (partidoPronosticado.esCapitan) 2 else 1

}

data class Equipo (
    val nombre : String,
    val fotoEscudo : String
){}

enum class Resultado{
    LOCAL,
    VISITA,
    EMPATE
}



class Torneo (val resultadosVerdaderos : MutableList<Partido>) { //Los resultados verdaderos los obtiene de la API
    val usuarios = mutableListOf<Usuario>()

    fun parcialesFecha () {
        usuarios.forEach { usuario ->
            usuario.prode.chequearPuntos(resultadosVerdaderos)
        }
    }

    fun finalizarFecha (nuevoProde : Prode) {
        usuarios.forEach { usuario ->
            usuario.prode.chequearPuntos(resultadosVerdaderos)
            usuario.cierreDeFecha(nuevoProde)
        }
    }

}