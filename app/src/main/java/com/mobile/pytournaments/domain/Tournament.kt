package com.mobile.pytournaments.domain

import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.time.Instant

/* Repensar na utilizacao de herança para
*  existir classes torneio antes de acontecer,
*  acontecendo e depois de terminar para separar
*  as variaveis */
data class Tournament (
        private var id: Int,
        private var name: String,
        private var description: String,
        private var date: Instant,
        private var status: TournamentStatus,
        private var img: String,
        private var location: Location,
        private var game: Game
        ){

        /* Pensar a respeito sobre onde essa lista vai ficar*/

        private var participants = mutableListOf<User>()
        private var winnerOrder = sortedSetOf(participants)
}