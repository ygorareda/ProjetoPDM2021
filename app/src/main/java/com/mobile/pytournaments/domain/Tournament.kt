package com.mobile.pytournaments.domain

import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/* Repensar na utilizacao de herança para
*  existir classes torneio antes de acontecer,
*  acontecendo e depois de terminar para separar
*  as variaveis */
data class Tournament(
        var id: Int,
        var name: String,
        var description: String,
        var date: Date,
        var status: TournamentStatus,
        var img: String,
        var location: Location,
        var game: Game
        ) : Comparable<Tournament>{
        /* Pensar a respeito sobre onde essa lista vai ficar*/

        var participants = mutableListOf<User>()
        var winnerOrder = mutableListOf(participants)

        fun getStringDate() : String {
                return DateFormat.getDateInstance(DateFormat.HOUR_OF_DAY0_FIELD).format(date).toString()
        }

        override fun compareTo(other: Tournament) = this.name.compareTo(other.name)
}