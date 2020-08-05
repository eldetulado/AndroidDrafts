package com.example.androiddraft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddraft.domain.FrutasUseCase
import com.example.androiddraft.ui.modelo.Frutas

class MyViewModel : ViewModel() {

    val frutasUseCase = FrutasUseCase()
    private val listData = MutableLiveData<List<Frutas>>()

    init {
        getListaFrutas()
    }

    fun setListData(listaFrutas: List<Frutas>) {
        listData.value = listaFrutas
    }

    // Podemos usar corutinas para pedir informacion que sea asyncrona
    fun getListaFrutas() {
        setListData(frutasUseCase.obtenerListaDeFrutas())
    }

    fun getListFrutasLiveData(): LiveData<List<Frutas>> {
        return listData
    }
}