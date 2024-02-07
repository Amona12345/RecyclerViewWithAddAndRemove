package com.example.worldcuprecycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.worldcuprecycler.data.DataManger
import com.example.worldcuprecycler.data.Match
import com.example.worldcuprecycler.databinding.ActivityMainBinding
import com.example.worldcuprecycler.utill.Constant
import com.example.worldcuprecycler.utill.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() ,MatchInteractionListener{
    lateinit var matchAdapter :MatchAdapter
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
 setUp()
        addItem()

    }
    private fun setUp(){
        openFile()
     matchAdapter=MatchAdapter(DataManger.matches,this)
        binding.recycler.adapter=matchAdapter
    }

    private fun openFile(){
        val inputStream= assets.open("worldcup.csv")
        val buffer= BufferedReader(InputStreamReader(inputStream))
        val csv= CsvParser()
        buffer.forEachLine {
            Log.v("Eman",it)
            val currentMatch = csv.parse(it)
            DataManger.addMatch(currentMatch)

        }
    }
    override fun onClick(match: Match) {
   val myIntent=Intent(this,DetailseActivity::class.java)
        myIntent.putExtra(Constant.Key.MATCH,match)
        startActivity(myIntent)
   }
    override fun onClickTeamNme(name: String) {
      Toast.makeText(applicationContext,name,Toast.LENGTH_SHORT).show()
    }

    override fun deleteItem(index: Int) {
       DataManger.dealeMatch(index)
        matchAdapter.setData(DataManger.matches)
    }

    fun addItem(){
        binding.flotaingbutt.setOnClickListener {
            addFinalMatch()
        }
    }
    fun addFinalMatch(){
        val finalMatch=Match(
            year = "2018"
            , staduim = "Zamalik Staduim",
            city = "mosca",
            homeTeamName = "France",
            awayTeamName = "Creatia"
            , homeTeamGoels = "2",
            awayTeamGoels = "4"
        )
        DataManger.addMatch(finalMatch)
        matchAdapter.setData(DataManger.matches)
    }
}