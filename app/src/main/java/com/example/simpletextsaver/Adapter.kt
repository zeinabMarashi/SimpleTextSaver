
package com.example.simpletextsaver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletextsaver.databinding.ItemNewTextBinding

class Adapter(val data: ArrayList<DataText> , private val textEvent: TextEvent) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    lateinit var binding: ItemNewTextBinding

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindViews(position: Int){
            binding.txtShowText.text = data[position].text


            view.setOnClickListener{
                textEvent.onClickText(data[adapterPosition] , adapterPosition)


            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemNewTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(position)

    }
    fun addNewText(text: DataText){
        data.add(0 , text)
        notifyItemInserted(0)
    }

    fun deleteText(text: Int){
        data.removeAt(text)
        notifyDataSetChanged()
    }

    fun updateText (text: DataText , position: Int){

        data.set(position , text)
        notifyItemChanged(position)



    }

    interface TextEvent{

        fun onClickText(text: DataText , position: Int)
    }




}



