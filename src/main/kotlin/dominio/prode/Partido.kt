package dominio.prode

//Los partidos reales no son capitan hace falta dividir? idem con el batacazo
class Partido (val id : Int, val esCapitan : Boolean = false) {
    lateinit var resultado : Resultado
    lateinit var goles : MutableList<Int>

    fun setearResultado(golLocal : Int, golVisita : Int) {
        goles.add(golLocal, golVisita)
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