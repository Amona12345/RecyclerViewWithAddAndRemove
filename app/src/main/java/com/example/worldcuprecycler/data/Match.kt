package com.example.worldcuprecycler.data

import java.io.Serializable

data class Match (
     val year:String,
     val staduim:String,
     val city:String,
     val homeTeamName:String,
     val awayTeamName:String,
     val homeTeamGoels:String,
     val awayTeamGoels:String
 ):Serializable
