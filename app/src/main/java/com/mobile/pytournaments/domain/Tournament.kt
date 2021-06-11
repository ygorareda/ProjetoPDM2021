package com.mobile.pytournaments.domain

import com.google.android.gms.maps.model.LatLng
import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.lang.StringBuilder
import java.text.SimpleDateFormat
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

        fun getStringDate() = SimpleDateFormat("dd/MM/yyyy HH:mm").format(date)

        override fun compareTo(other: Tournament) = this.name.compareTo(other.name)
}

data class TournamentOnCreate(
        var name: String,
        var description: String,
        var date: Date,
        var img: String,
        var location: LatLng,
        var owner: User,
        var game: Game
)
