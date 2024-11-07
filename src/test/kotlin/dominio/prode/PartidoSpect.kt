package dominio.prode

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PartidoSpec : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Un partido que tiene seteado 1-0...") {
        it("devuelve como resultado LOCAL") {
            //arrange
            val partido = Partido(1)
            //act
            partido.setearResultado(1,0)
            //assert
            partido.resultado.shouldBe(Resultado.LOCAL)
        }
    }
})