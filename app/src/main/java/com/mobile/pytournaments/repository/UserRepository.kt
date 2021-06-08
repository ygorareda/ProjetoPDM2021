package com.mobile.pytournaments.repository

import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.domain.UserApiRetorno
import com.mobile.pytournaments.domain.UserModelo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
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

    suspend fun loadAllUsers(): List<UserModelo> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val request = retrofit.create(UserEndPoint::class.java)
        val consulta = request.loadAllUsers()

        return consulta
    }


}

interface UserEndPoint{
//@Headers("Content-type: application/json")

    @GET("users/busca/geral")
    suspend fun loadAllUsers() : List<UserModelo>
}