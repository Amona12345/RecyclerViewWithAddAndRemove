package com.example.worldcuprecycler.utill

import com.example.worldcuprecycler.data.Match

class CsvParser {

    fun parse(line: String): Match {
        val tokens = line.split(",")
        return Match(
            year = tokens[Constant.Column.YEAR],
            staduim = tokens[Constant.Column.STADIUM],
            city = tokens[Constant.Column.CITY],
            homeTeamName = tokens[Constant.Column.HOME_TEAM_NAME],
            awayTeamGoels = tokens[Constant.Column.AWAY_TEAM_GOALS],
            awayTeamName = tokens[Constant.Column.AWAY_TEAM_NAME],
            homeTeamGoels = tokens[Constant.Column.HOME_TEAM_GOALS]
        )
    }
}