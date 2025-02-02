
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val id: Int, val descripcion: String, var estado: Boolean, var fecha: String? = null) {

    companion object {
        var nuevaId = 1
    }

    constructor(descripcion: String, estado: Boolean): this(nuevaId, descripcion, estado, fecha = null)

    init {
        nuevaId++
        require(descripcion.isNotEmpty())

        if (estado) {
            val fechaHoraActual: LocalDateTime = LocalDateTime.now()
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val fechaFormateada: String = fechaHoraActual.format(formatter)

            fecha = fechaFormateada
        }
    }

}