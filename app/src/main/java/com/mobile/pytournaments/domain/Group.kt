package com.mobile.pytournaments.domain

data class Group(
    var id: Int,
    var name: String,
    var description: String,
    var game: Game,
){

    var participantsList = mutableListOf<User>()

}