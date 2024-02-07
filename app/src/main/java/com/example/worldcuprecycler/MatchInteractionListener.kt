package com.example.worldcuprecycler

import com.example.worldcuprecycler.data.Match

interface MatchInteractionListener {
    fun onClick(match:Match)
    fun onClickTeamNme(name:String)
    fun deleteItem(index:Int)
}