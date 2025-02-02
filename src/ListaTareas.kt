import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ListaTareas() {

    private val lista: MutableList<Tarea> = mutableListOf()

    fun aniadirTarea(tarea: Tarea) {
        lista.add(tarea)
    }

    fun eliminarTarea(id: Int): Boolean {
        for (tarea in lista) {
            lista.removeIf { it.id == id }
            println("La tarea con ID $id se ha eliminado correctamente")
            return true
        }

        println("No se ha encontrado la tarea con el identificador especificado")
        return false
    }

    fun completarTarea(id: Int) {
        for (tarea in lista) {
            if (tarea.id == id) {
                if (tarea.estado) {
                    tarea.estado = false
                    tarea.fecha = null
                }
                else if (!tarea.estado) {
                    tarea.estado = true
                    tarea.fecha = establecerFecha()
                }
            }
        }
    }

    private fun establecerFecha(): String {
        val fechaHoraActual: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val fechaFormateada: String = fechaHoraActual.format(formatter)

        return fechaFormateada
    }

}