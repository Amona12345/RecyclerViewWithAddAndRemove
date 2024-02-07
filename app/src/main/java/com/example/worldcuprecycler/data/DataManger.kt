package com.example.worldcuprecycler.data

object DataManger {

    val machList= mutableListOf<Match>()
    private var matchIndex=0
    val matches:List<Match>
        get() = machList
    fun addMatch (match:Match){
        machList.add(match)
    }
    fun addMatchIndeax(match: Match,index:Int){
        machList.add(index,match)
    }
    fun getCurrntMatch():Match= machList[matchIndex]
    fun getNextMatch():Match{
        matchIndex++
        if( matchIndex== machList.size){
            matchIndex=1
        }
        return machList[matchIndex]
    }
    fun getPeriviousMatch():Match{
        matchIndex--
        if(matchIndex==-1){
            matchIndex= machList.size-1
        }
        return machList[matchIndex]
    }
    fun dealeMatch(index:Int){
        machList.removeAt(index)
    }

}