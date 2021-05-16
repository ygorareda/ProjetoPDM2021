package com.mobile.pytournaments.interactor

import com.mobile.pytournaments.repository.TournamentRepository
import javax.inject.Inject

class TournamentInteractor @Inject constructor(
    private val repository: TournamentRepository
) {

    fun loadSubscribedTournamentsData() = repository.searchForSubscribedTournament()
}