package com.mobile.pytournaments.repository

import com.mobile.pytournaments.domain.Location
import com.mobile.pytournaments.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    // variavel temporaria
    private val tournamentRepository: TournamentRepository
){

    fun searchForLoggedUserData() : User{
        //temporário
        val user =User(1, "Joshnson", "Zeca samba",
            "johnson@gmail.com", "")
        val t = tournamentRepository.searchForSubscribedTournament()
        user.tournamentsHistory.addAll(t)
        user.tournamentsSubscribed.addAll(t)

        return user
    }
}