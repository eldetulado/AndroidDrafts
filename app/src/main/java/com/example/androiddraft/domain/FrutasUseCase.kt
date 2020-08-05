package com.example.androiddraft.domain

import com.example.androiddraft.data.FrutasDataSet
import com.example.androiddraft.ui.modelo.Frutas

class FrutasUseCase {

    private val frutasDataSet = FrutasDataSet()

    fun obtenerListaDeFrutas(): List<Frutas> {
        return frutasDataSet.crearListaDeFrutas()
    }
}