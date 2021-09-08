package com.metehanbolat.mvvmstudytwo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metehanbolat.mvvmstudytwo.databinding.RecyclerCardViewBinding
import com.metehanbolat.mvvmstudytwo.model.Kayit

class RecyclerCardAdapter(var kayitList : ArrayList<Kayit>) : RecyclerView.Adapter<RecyclerCardAdapter.CardViewHolder>() {

    class CardViewHolder(val binding : RecyclerCardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = RecyclerCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kayit = kayitList[position]
        holder.binding.cardIsim.text = kayit.isim
        holder.binding.cardSoyad.text = kayit.soyIsim
    }

    override fun getItemCount(): Int {
        return kayitList.size
    }
}