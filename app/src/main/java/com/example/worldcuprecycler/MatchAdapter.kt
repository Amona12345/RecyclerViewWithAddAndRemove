package com.example.worldcuprecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcuprecycler.data.Match
import com.example.worldcuprecycler.databinding.MatchBinding

class MatchAdapter(  private var list: List<Match>,private val listener:MatchInteractionListener) :RecyclerView.Adapter <MatchAdapter.MatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.match,parent,false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int {
  return list.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
     val currentMatch=list[position]
        holder.apply {
           binding.back.text=currentMatch.homeTeamName
          binding.next.text=currentMatch.awayTeamName
           binding.fristnum.text=currentMatch.homeTeamGoels
            binding.seconednum.text=currentMatch.awayTeamGoels
            binding.yaer.text=currentMatch.year
         binding.back.setOnClickListener {  listener.onClickTeamNme(currentMatch.homeTeamName)}
           binding.root.setOnClickListener { listener.onClick(currentMatch) }
            binding.delete.setOnClickListener { listener.deleteItem(position) }
             if(currentMatch.homeTeamGoels>currentMatch.awayTeamGoels){
                 binding.fristnum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                 binding.seconednum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))

             }
            else if (currentMatch.homeTeamGoels<currentMatch.awayTeamGoels){
                binding.seconednum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.green))
                binding.fristnum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.red))
            }
            else
            {
                binding.seconednum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
                binding.fristnum.setTextColor(ContextCompat.getColor(holder.binding.root.context,R.color.white))
            }
        }

    }
    class MatchViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val binding= MatchBinding.bind(itemView)
    }
    fun setData(newLAist:List<Match>){
        list=newLAist
        notifyDataSetChanged()
    }
}