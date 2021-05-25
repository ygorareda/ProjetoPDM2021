package com.mobile.pytournaments.repository

import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.Location
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject

class TournamentRepository @Inject constructor(
) {

    fun searchForSubscribedTournament() = tournamentMockData()

    fun tournamentMockData(): MutableList<Tournament>{
        val g1 = Game( 1, "Ganeric game", "FPS", "SUPER GAME")

        return mutableListOf(Tournament(1, "Gerenic tournament",
        "Generic tournament", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", Location(1.0,-1.0),
            g1),
        Tournament(2, "Gerenic tournament 2",
            "Generic tournament", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", Location(1.0,-1.0),
            g1),
        Tournament(3, "Gerenic tournament 3",
            "Generic tournament", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", Location(1.0,-1.0),
            g1)
        )
    }
}