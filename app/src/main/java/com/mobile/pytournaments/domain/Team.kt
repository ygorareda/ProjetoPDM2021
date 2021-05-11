package com.mobile.pytournaments.domain

data class Team (
    var id: Int,
    var name: String,
    var description: String,
    var game: Game
        ){

    private var participantsList = mutableListOf<User>()
}