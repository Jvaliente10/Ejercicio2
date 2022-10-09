package com.example.joseantoniovaliente.ejercicio2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.joseantoniovaliente.ejercicio2.databinding.ElementLayoutBinding

class ElementAdapter(val elements:List<Element>,
                     val listener:(Element)->Unit):
                        RecyclerView.Adapter<ElementAdapter.ViewHolder>() {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding=ElementLayoutBinding.bind(view)
        fun bind(element: Element){

            Glide.with(binding.imageElement).load(element.image).into(binding.imageElement)
            binding.name.text=element.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.element_layout,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(elements[position])
        holder.itemView.setOnClickListener {
            listener(elements[position])
        }
    }

    override fun getItemCount()=elements.size


}