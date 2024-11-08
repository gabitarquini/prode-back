package dominio.prode

// Lista de equipos
val equipos = listOf(
    Equipo("Boca Juniors", "https://example.com/boca_escudo.png"),
    Equipo("River Plate", "https://example.com/river_escudo.png"),
    Equipo("Independiente", "https://example.com/independiente_escudo.png"),
    Equipo("Racing Club", "https://example.com/racing_escudo.png"),
    Equipo("San Lorenzo", "https://example.com/sanlorenzo_escudo.png"),
    Equipo("Vélez Sarsfield", "https://example.com/velez_escudo.png"),
    Equipo("Estudiantes de La Plata", "https://example.com/estudiantes_escudo.png"),
    Equipo("Huracán", "https://example.com/huracan_escudo.png"),
    Equipo("Lanús", "https://example.com/lanus_escudo.png"),
    Equipo("Argentinos Juniors", "https://example.com/argentinos_escudo.png")
)

// Función para generar las fechas (partidos) de un torneo "todos contra todos"
fun generarFechas(equipos: List<Equipo>): List<List<Partido>> {
    val partidos = mutableListOf<Partido>()
    var idPartido = 1

    // Generar todos los partidos posibles (combinaciones sin repetición)
    for (i in equipos.indices) {
        for (j in i + 1 until equipos.size) {
            partidos.add(
                Partido(
                    id = idPartido++,
                    equipoLocal = equipos[i],
                    equipoVisita = equipos[j]
                )
            )
        }
    }

    // Dividir los partidos en "fechas", aquí cada fecha tiene 5 partidos (5 juegos)
    return partidos.chunked(5) // Ajustar 5 según la cantidad de partidos por fecha deseada
}

// Crear el fixture para el prode
val fechas = generarFechas(equipos)

// Ejemplo de cómo se podría cargar el fixture en el prode
val prodeMock = Prode(partidos = fechas[0].toMutableList())

val resultadosPrimeraFechaMock = prodeMock.partidos.map { partido ->
    Partido(
        id = partido.id,
        equipoLocal = partido.equipoLocal,
        equipoVisita = partido.equipoVisita
    ).apply {
        // Establecemos el resultado con puntajes aleatorios entre 0 y 3
        setearResultado(1, 0, capitan = false)
    }
}.toMutableList()


