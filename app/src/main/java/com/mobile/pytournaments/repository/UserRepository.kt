package com.mobile.pytournaments.repository

import android.util.Log
import android.widget.Toast
import com.mobile.pytournaments.domain.UserCadastraApi
import com.mobile.pytournaments.domain.UserModelo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
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

    suspend fun signUpUsersBd(name: String, username: String): Call<String> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("teste",name)
        Log.d("teste",username)

        val request = retrofit.create(UserEndPoint::class.java)
        val consulta = request.signUpUsersBd(name,username)
        return consulta
    }


}

interface UserEndPoint{
//@Headers("Content-type: application/json")

    @GET("users/busca/geral")
    suspend fun loadAllUsers() : List<UserModelo>

    @FormUrlEncoded
    @Headers("Content-type: application/json")
    @POST("users/cadastra")
    suspend fun signUpUsersBd(@Field("name") name: String,@Field("username") username: String): Call<String>
    //suspend fun signUpUsersBd(@Body userApi: UserCadastraApi): Call<String>

}