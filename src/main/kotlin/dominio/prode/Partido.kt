package dominio.prode

//Los partidos reales no son capitan hace falta dividir? idem con el batacazo
class Partido (val id : Int, val equipoLocal : Equipo, val equipoVisita:Equipo) {
    lateinit var resultado : Resultado
    var goles = mutableListOf(0,0)
    var estaCargado = false
    var esCapitan : Boolean = false

    fun setearResultado(golLocal : Int, golVisita : Int, capitan: Boolean) {
        goles.clear()
        goles.add(golLocal)
        goles.add(golVisita)
        esCapitan = capitan
        resultado = evaluarResultado(golLocal, golVisita)
        estaCargado = true
    }

    private fun evaluarResultado(golLocal : Int, golVisita : Int) : Resultado {
        return if (golLocal == golVisita) {
            Resultado.EMPATE
        } else if (golLocal > golVisita) {
            Resultado.LOCAL
        } else Resultado.VISITA
    }
}