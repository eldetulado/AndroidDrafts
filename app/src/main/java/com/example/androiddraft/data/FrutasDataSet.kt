package com.example.androiddraft.data

import com.example.androiddraft.ui.modelo.Frutas

class FrutasDataSet {
    fun crearListaDeFrutas(): List<Frutas> {
        return listOf(
            Frutas("Manzana", "Rojo", 4.5F, 250.3F),
            Frutas("Banana", "Amarillo", 5.6F, 200.0F),
            Frutas("Uvas", "Verde", 10.5F, 100.5F)
        )
    }
}