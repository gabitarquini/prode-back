package dominio.prode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PartidoSpec : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Dado un partido...") {
            //arrange
            val partido = Partido(1, equipoLocal = equipos[0], equipoVisita = equipos[1])
        it("seteado en 1-0 devuelve como resultado LOCAL") {
            //act
            partido.setearResultado(1,0, capitan = false)
            //assert
            partido.resultado.shouldBe(Resultado.LOCAL)
        }
        it("seteado en 1-1 devuelve como resultado EMPATE") {
            //act
            partido.setearResultado(1,1, capitan = false)
            //assert
            partido.resultado.shouldBe(Resultado.EMPATE)
        }
        it("seteado en 0-1 devuelve como resultado VISITA") {
            //act
            partido.setearResultado(0,1, capitan = false)
            //assert
            partido.resultado.shouldBe(Resultado.VISITA)
        }
    }
})