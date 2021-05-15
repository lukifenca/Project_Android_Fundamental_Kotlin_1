package com.lukitor.projectandroidpemulakotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardViewUserAdapter(private val listHeroes: ArrayList<User>) : RecyclerView.Adapter<CardViewUserAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private lateinit var onItemClickCallbackk: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {this.onItemClickCallback = onItemClickCallback}
    fun setOnItemClickCallbackk(onItemClickCallback: OnItemClickCallback) {this.onItemClickCallbackk = onItemClickCallback }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHeroes[position]
        holder.photo.setImageResource(hero.foto)
        holder.judul.text = hero.nama
        holder.harga.text = hero.username
        if (hero.love == "0") holder.love.setImageResource(R.drawable.heartwhite)
        else holder.love.setImageResource(R.drawable.heartblack)
        holder.love.setOnClickListener {onItemClickCallbackk.onItemClicked(listHeroes[holder.adapterPosition])}
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition]) }
    }
    override fun getItemCount(): Int {return listHeroes.size}

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.gambarcard)
        var love: ImageView = itemView.findViewById(R.id.imglove)
        var judul: TextView = itemView.findViewById(R.id.txtnamacard)
        var harga: TextView = itemView.findViewById(R.id.txthargacard)
    }
    interface OnItemClickCallback {fun onItemClicked(data: User)}
}