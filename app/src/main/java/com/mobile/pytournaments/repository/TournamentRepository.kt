package com.mobile.pytournaments.repository

import com.mobile.pytournaments.domain.*
import com.mobile.pytournaments.domain.enum.TournamentStatus
import java.util.*
import javax.inject.Inject

class TournamentRepository @Inject constructor(
) {
    private val mockUser = User(2, "LoggedUser", "Usuario", "", "")
    private val mockBd = mutableListOf<TournamentOnCreate>()

    fun searchForSubscribedTournament() = tournamentMockData()

    fun registerNewTournament(new: TournamentOnCreate): Result{
        mockBd.add(new)
        return Result(true, "Criado com sucesso", null)
    }

    fun tournamentMockData(): MutableList<Tournament>{
        val g1 = Game( 1, "Ganeric game", "FPS", "SUPER GAME")

        return mutableListOf(Tournament(1, "Gerenic tournament",
        "Generic tournament", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.834963163926998, -47.91285006006427),
            g1),
        Tournament(2, "Gerenic tournament 2",
            "Generic tournament about some game", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.809310883073378, -48.09375488760715),
            g1),
        Tournament(3, "Gerenic tournament 3",
            "Generic tournament about game 3", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.833580832071275, -47.95532588760664),
            g1)
        )
    }
}