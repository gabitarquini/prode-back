package dominio.prode

class Torneo (val resultadosVerdaderos : MutableList<Partido>) { //Los resultados verdaderos los obtiene de la API
    val usuarios = mutableListOf<Usuario>()

    fun agregarParticipante (usuario: Usuario) =
        usuarios.add(usuario)

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