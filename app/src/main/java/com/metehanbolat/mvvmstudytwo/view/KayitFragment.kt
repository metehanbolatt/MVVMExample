package com.metehanbolat.mvvmstudytwo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.metehanbolat.mvvmstudytwo.databinding.FragmentKayitBinding
import com.metehanbolat.mvvmstudytwo.model.Kayitlar
import com.metehanbolat.mvvmstudytwo.viewmodel.KayitFragmentViewModel

class KayitFragment : Fragment() {

    private lateinit var binding : FragmentKayitBinding
    private val viewModel : KayitFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKayitBinding.inflate(inflater, container, false)
        binding.fragmentKayitNesnesi = this

        viewModel.kayitlar.observe(viewLifecycleOwner, {

        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun buttonKaydet(view : View, isim : String, soyIsim : String){
        viewModel.kayitEkle(isim, soyIsim)
        binding.kayitIsim.setText("")
        binding.kayitSoyad.setText("")
        Snackbar.make(view,"$isim $soyIsim kullanıcısı eklendi.",Snackbar.LENGTH_SHORT).show()
    }

    fun buttonIleri(view: View, title : String){
        viewModel.kayitlar.value?.let {
            val liste = Kayitlar(it)
            val action = KayitFragmentDirections.actionKayitFragmentToRecyclerViewFragment(liste, title)
            Navigation.findNavController(view).navigate(action)
        }
    }
}