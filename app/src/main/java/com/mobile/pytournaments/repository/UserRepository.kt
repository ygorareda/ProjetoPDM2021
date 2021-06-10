package com.mobile.pytournaments.repository

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mobile.pytournaments.domain.UserCadastraApi
import com.mobile.pytournaments.domain.UserModelo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import javax.inject.Inject

class UserRepository @Inject constructor(
    // variavel temporaria
){
    val user = Firebase.auth.currentUser

    suspend fun loadAllFriends(): List<UserCadastraApi> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val request = retrofit.create(UserEndPoint::class.java)
        val consulta = request.loadAllFriends(user.uid)

        return consulta
    }

    suspend fun signUpUsersBd(name: String, username : String): String {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cadastrauser = UserCadastraApi(user.uid, name, username)

       // Log.d("teste",user.name)
        //Log.d("teste",user.username)
        //Log.d("teste", user.toString())

        val request = retrofit.create(UserEndPoint::class.java)
        val consulta = request.signUpUsersBd(cadastrauser)
        return consulta
    }


    suspend fun loadUniqueUser() : UserCadastraApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("teste", user.uid)


        val request = retrofit.create(UserEndPoint::class.java)
        val consulta = request.loadUniqueUser(user.uid)
        Log.d("teste", consulta.toString())

        return consulta
    }




}

interface UserEndPoint{
//@Headers("Content-type: application/json")

    @GET("users/busca/amigos")
    suspend fun loadAllFriends(@Query("id") userToken: String) : List<UserCadastraApi>

    //@FormUrlEncoded
    @Headers("Content-type: application/json")
    @POST("users/cadastra")
    suspend fun signUpUsersBd(@Body userApi: UserCadastraApi): String
    //suspend fun signUpUsersBd(@Field("name") name: String,@Field("username") username: String): Call<String>

    //@Headers("Content-type: application/json")
    @POST("users/user")
    suspend fun loadUniqueUser(@Query("id") userToken: String) : UserCadastraApi


}