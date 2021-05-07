package com.mobile.pytournaments.domain

/*Alterar as classes que utilizam uma lista de User para
* a classe a ser criada ItemUser*/
data class User(
    private var id: Int,
    private var name: String,
    private var username: String,
    private var email: String,
    private var img: String,
) {
    private var preferences = mutableListOf<Game>()
    private var tournamentsSubscribed = mutableListOf<Tournament>()
    private var tournamentsHistory =  mutableListOf<Tournament>()
    private var friendsList =  mutableListOf<User>()
}