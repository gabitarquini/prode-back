package dominio.prode

class Prode (val partidos : MutableList<Partido>) {
    var puntos : Int = 0

    fun chequearPuntos(resultadosVerdaderos : MutableList<Partido>){
        puntos = 0
        resultadosVerdaderos.forEach { partidoReal -> evaluar(
            partidoReal,
            partidos.find{ it.id == partidoReal.id}!!)
        }
    }

    fun evaluar (partidoReal : Partido, partidoPronosticado : Partido) {
        val puntosPartido = (0 + evaluarPorResultado(partidoReal, partidoPronosticado) + evaluarPorGoles(partidoReal, partidoPronosticado)) * bonificacionCapitan(partidoPronosticado)
        puntos += puntosPartido
    }

    fun evaluarPorResultado (partidoReal : Partido, partidoPronosticado : Partido) =
        if (partidoReal.resultado == partidoPronosticado.resultado) 1 else 0

    fun evaluarPorGoles (partidoReal : Partido, partidoPronosticado : Partido) =
        if (partidoReal.goles == partidoPronosticado.goles) 2 else 0

    fun bonificacionCapitan(partidoPronosticado : Partido) =
        if (partidoPronosticado.esCapitan) 2 else 1

    fun estaCompleto () = partidos.all { it.estaCargado }

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



