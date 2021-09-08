package com.metehanbolat.mvvmstudytwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.mvvmstudytwo.model.Kayit

class KayitFragmentViewModel : ViewModel() {

    var kayitList = mutableListOf<Kayit>()
    val kayitlar = MutableLiveData<List<Kayit>>()

    init {
        kayitlar.value = kayitList
    }

    fun kayitEkle(isim : String, soyIsim : String){
        kayitList.add(Kayit(isim,soyIsim))
        kayitlar.value = kayitList
    }

}