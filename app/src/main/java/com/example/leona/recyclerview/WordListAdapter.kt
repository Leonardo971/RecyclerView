package com.example.leona.recyclerview

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.*
import kotlinx.android.synthetic.main.wordlist_item.view.*
import java.text.FieldPosition
import java.util.*

class WordListAdapter(context: Context,private val wordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

private val inflater:LayoutInflater= LayoutInflater.from(context)


 override fun onCreateViewHolder(parent: ViewGroup,viewType:Int):WordViewHolder{
     val itemView= inflater.inflate(R.layout.wordlist_item,parent,false)
     return WordViewHolder(itemView)
 }

 override fun onBindViewHolder(holder:WordViewHolder,position: Int){
     val mCurrent=wordList[position]
     holder.wordItemView.text=mCurrent

 }

 override fun  getItemCount():Int{
    return wordList.size
 }
 inner class WordViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
     val wordItemView=itemView.word

     init {
         itemView.setOnClickListener(this)
     }

     override fun onClick(v: View) {
        wordItemView.text="Cliked!"+wordItemView.text
     }
 }
}
