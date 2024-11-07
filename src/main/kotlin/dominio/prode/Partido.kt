package dominio.prode

//Los partidos reales no son capitan hace falta dividir? idem con el batacazo
class Partido (val id : Int, val esCapitan : Boolean = false) {
    lateinit var resultado : Resultado
    var goles = mutableListOf(0,0)

    fun setearResultado(golLocal : Int, golVisita : Int) {
        goles.clear()
        goles.add(golLocal)
        goles.add(golVisita)
        resultado = evaluarResultado(golLocal, golVisita)
    }

    private fun evaluarResultado(golLocal : Int, golVisita : Int) : Resultado {
        return if (golLocal == golVisita) {
            Resultado.EMPATE
        } else if (golLocal > golVisita) {
            Resultado.LOCAL
        } else Resultado.VISITA
    }
}