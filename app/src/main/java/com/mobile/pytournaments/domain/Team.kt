package com.mobile.pytournaments.domain

data class Team (
    private var id: Int,
    private var name: String,
    private var description: String,
    private var game: Game
        ){

    private var participantsList = mutableListOf<User>()
}