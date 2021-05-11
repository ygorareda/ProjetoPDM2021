package com.mobile.pytournaments.domain

/*Alterar as classes que utilizam uma lista de User para
* a classe a ser criada ItemUser*/
data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var img: String,
) {
    var preferences = mutableListOf<Game>()
    var tournamentsSubscribed = mutableListOf<Tournament>()
    var tournamentsHistory =  mutableListOf<Tournament>()
    var friendsList =  mutableListOf<User>()
}