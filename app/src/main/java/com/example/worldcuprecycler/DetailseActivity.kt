package com.example.worldcuprecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcuprecycler.data.Match
import com.example.worldcuprecycler.databinding.ActivityDetailseBinding
import com.example.worldcuprecycler.utill.Constant

class DetailseActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailseBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
   setUp()
    }
        fun setUp(){
            val match :Match? =intent.getSerializableExtra(Constant.Key.MATCH) as Match
            match?.let {
                bindMatch(it)
            }
        }

    fun bindMatch(match: Match) {
        binding.apply {
            text1.text = match.homeTeamName
            text2.text = match.homeTeamGoels
            text4.text = match.awayTeamGoels
            text5.text = match.awayTeamName
            text6.text = match.year
        }
    }

}