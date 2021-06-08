package com.mobile.pytournaments.repository

import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.domain.UserApiRetorno
import com.mobile.pytournaments.domain.UserModelo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Inject

class UserRepository @Inject constructor(
    // variavel temporaria
    private val tournamentRepository: TournamentRepository
){


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

    @POST("users/cadastra")
    @Headers("Content-type: application/json")
    suspend fun signUpUsersBd(email: String?, password: String?): String
}