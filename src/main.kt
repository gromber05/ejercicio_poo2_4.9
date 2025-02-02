import kotlin.system.exitProcess

fun main() {

    var lista = ListaTareas()
    val terminado = false
    var opcion = 0

    while (!terminado) {
        limpiarPantalla()
        println("Menú de tareas.")
        println("1. - Añadir una tarea")
        println("2. - Eliminar una tarea")
        println("3. - Cambiar estado de una tarea")
        println("4. - Salir")

        try {
            opcion = readln().toInt()

            if (opcion !in 1..4) {
                throw NumberFormatException()
            }

        }
        catch (n: NumberFormatException) {
            println("La opción no es válida, por favor, introduzca una opción valida")
        }

        limpiarPantalla()
        when (opcion) {
            1 -> {
                val tarea = aniadirTarea()
                lista.aniadirTarea(tarea)
            }
            2 -> {
                lista = eliminarTarea(lista)
            }
            3 -> {
                lista = cambiarEstado(lista)
            }
            4 -> salir()

        }
    }

   /* val lista = ListaTareas()

    val tarea1 = Tarea(1, "Limpiar la casa", false)
    val tarea2 = Tarea("Lavar los platos", true)

    lista.aniadirTarea(tarea1)
    lista.aniadirTarea(tarea2)
    */
}

fun limpiarPantalla() {
    repeat(50) {
        println("")
    }
}

fun aniadirTarea(): Tarea {

    println("Introduzca la ID de la tarea")
    val id = readln().toInt()

    println("Introduzca la descripción de la tarea")
    val descripcion = readln()

    println("Introduzca el estado de la tarea (Terminada »» s / Completa »» n)")
    val estado = readln()

    val estadoTarea: Boolean = if (estado == "s") {
        true
    } else if (estado == "n") {
        false
    } else {
        println("Estado no válido")
        false
    }

    val tarea = Tarea(id, descripcion, estadoTarea)
    return tarea
}

fun eliminarTarea (listaTareas: ListaTareas): ListaTareas {

    println("Introduce la ID de la tarea que quieras borrar »» ")
    val opcion = readln().toInt()

    listaTareas.eliminarTarea(opcion)

    return listaTareas
}

fun cambiarEstado(listaTareas: ListaTareas): ListaTareas {
    println("Introduce la ID de la tarea que quieras cambiar el estado »» ")
    val opcion = readln().toInt()

    listaTareas.completarTarea(opcion)

    return listaTareas
}

fun salir() {
    println("¿Estás seguro de que quieres salir? (s/n)")
    val respuesta = readln().lowercase()
    if (respuesta == "s") {
        println("Saliendo del programa...")
        exitProcess(0)
    } else {
        println("Continuando en la aplicación...")
    }
}