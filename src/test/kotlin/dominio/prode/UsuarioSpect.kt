package dominio.prode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class UsuarioSpect : DescribeSpec( {
    isolationMode = IsolationMode.InstancePerTest

    val usuario = Usuario("gabi", "foto", "gabi@gmail.com").apply {
        iniciar(prodeMock)
    }

    describe("Dado un usuario") {
        it("Setea el primer partido 1-0 y el resultado es LOCAL") {
            usuario.armarProde(1,1,0, capitan = false)
            val primerPartido = usuario.prode.partidos.find { it.id == 1 }
            primerPartido?.resultado.shouldBe(Resultado.LOCAL)
            primerPartido?.goles.shouldBe(mutableListOf(1,0))
        }
        it("Carga casi todos los resultados y el prode esta incompelto") {
            usuario.armarProde(1,1,0, capitan = true)
            usuario.armarProde(2,1,0, capitan = false)
            usuario.armarProde(3,1,0, capitan = false)
            usuario.armarProde(4,1,0, capitan = false)
            usuario.prode.estaCompleto().shouldBeFalse()
        }
        it("Si se carga el ultimo resultado queda completo") {
            usuario.armarProde(5,1,0, capitan = false)
            usuario.prode.estaCompleto().shouldBeTrue()
        }
        /*it("Si un torneo calcula puntos puedo preguntarle los puntos acumulados") {
            val torneo = Torneo(resultadosPrimeraFechaMock).apply {
                agregarParticipante(usuario)
                parcialesFecha()
            }
            usuario.puntosAcumulados().shouldBe(18)
        }*/
    }
})