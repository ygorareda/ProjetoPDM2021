package com.mobile.pytournaments.domain

import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

/* Repensar na utilizacao de herança para
*  existir classes torneio antes de acontecer,
*  acontecendo e depois de terminar para separar
*  as variaveis */
data class Tournament (
        var id: Int,
        var name: String,
        var description: String,
        var date: Date,
        var status: TournamentStatus,
        var img: String,
        var location: Location,
        var game: Game
        ){
        /* Pensar a respeito sobre onde essa lista vai ficar*/

        var participants = mutableListOf<User>()
        var winnerOrder = sortedSetOf(participants)

        fun getStringDate() : String {
                val sdf = SimpleDateFormat("dd:MM:yyyy HH:mm", Locale.US)
                return sdf.format(date)
        }
}