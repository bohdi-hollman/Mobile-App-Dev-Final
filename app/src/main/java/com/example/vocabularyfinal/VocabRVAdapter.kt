package com.example.vocabularyfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VocabRVAdapter(private val context: Context, private val listener: IVocabRVAdapter): RecyclerView.Adapter<VocabRVAdapter.VocabViewHolder>() {

   val allVocab = ArrayList<Vocab>()

    inner class VocabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabViewHolder {
        val viewHolder = VocabViewHolder(LayoutInflater.from(context).inflate(R.layout.item_vocab, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allVocab[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allVocab.size
    }

    override fun onBindViewHolder(holder: VocabViewHolder, position: Int) {
        val currentVocab = allVocab[position]
        holder.textView.text = currentVocab.text
    }

    fun updateList(newList: List<Vocab>) {
        allVocab.clear()
        allVocab.addAll(newList)

        notifyDataSetChanged()
    }
}

interface IVocabRVAdapter {
    fun onItemClicked(vocab: Vocab)
}