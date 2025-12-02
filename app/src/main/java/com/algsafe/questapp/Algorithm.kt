package com.algsafe.questapp

fun evaluarViolencia(matrizRespuestas: Array<IntArray>): IntArray {

    //Puntos de control para cada nivel de violencia.
    val nivelBajoMin = 26
    val nivelBajoMax = 52
    val nivelMedioMax = 78
    val nivelAltoMax = 104
    val puntuaciones = IntArray(4)

    //Variables para contar puntos por seccion y retornar datos
    var elementosValidos: Int
    var contadorS1 = 0
    var contadorS2 = 0
    var contadorS3 = 0
    var total: Int
    var nivel: Int

    for (vectorSeccion in matrizRespuestas) {
        elementosValidos = 0
        while (elementosValidos < 7) {
            val valorActual = vectorSeccion[elementosValidos]
            if (valorActual >= 1 && valorActual <= 5) {
                elementosValidos++
            } else {
                vectorSeccion[elementosValidos] = 1
            }
        }
    }

    //Suma de puntajes y puntuacion total
    for (i in 0..6) {
        contadorS1 += matrizRespuestas[0][i]
        contadorS2 += matrizRespuestas[1][i]
        contadorS3 += matrizRespuestas[2][i]
    }

    total = contadorS1 + contadorS2 + contadorS3

    //Condiciones.
    nivel = if (total in 1..nivelBajoMin) {
        1
    } else if (total in (nivelBajoMin + 1)..nivelBajoMax) {
        2
    } else if (total in (nivelBajoMax + 1)..nivelMedioMax) {
        3
    } else if (total in (nivelMedioMax + 1)..nivelAltoMax) {
        4
    } else {
        5
    }

    //Datos de Salida
    puntuaciones[0] = nivel
    puntuaciones[1] = contadorS1
    puntuaciones[2] = contadorS2
    puntuaciones[3] = contadorS3

    return puntuaciones
}