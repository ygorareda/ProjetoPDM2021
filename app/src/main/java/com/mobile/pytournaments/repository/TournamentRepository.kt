package com.mobile.pytournaments.repository

import android.util.Log
import com.mobile.pytournaments.domain.*
import com.mobile.pytournaments.domain.enum.TournamentStatus
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*
import javax.inject.Inject

class TournamentRepository @Inject constructor(
) {
    private val mockUser = User(2, "LoggedUser", "Usuario", "", "")
    private val mockBd = mutableListOf<TournamentOnCreate>()

    fun searchForSubscribedTournament() = tournamentMockData()

    suspend fun registerNewTournament(tournamentCreated: TournamentOnCreate): String{
        //mockBd.add(new)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        Log.d("teste", tournamentCreated.name)
        Log.d("teste", tournamentCreated.description)
        Log.d("teste", tournamentCreated.date)
        Log.d("teste", tournamentCreated.owner)
        Log.d("teste", tournamentCreated.location.toString())
        tournamentCreated.user?.let { Log.d("teste", it) }


        val request = retrofit.create(TournamentEndPoint::class.java)
        val consulta = request.createTournament(tournamentCreated)

        return consulta
    }

    fun tournamentMockData(): MutableList<Tournament>{
        val g1 = Game( 1, "Ganeric game", "FPS", "SUPER GAME")

        return mutableListOf(Tournament(1, "Gerenic tournament",
        "Generic tournament", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.834963163926998, -47.91285006006427),
            g1),
        Tournament(2, "Gerenic tournament 2",
            "Generic tournament about some game", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.809310883073378, -48.09375488760715),
            g1),
        Tournament(3, "Gerenic tournament 3",
            "Generic tournament about game 3", Calendar.getInstance().time,
            TournamentStatus.WILL_START, "", mockUser, Location(-15.833580832071275, -47.95532588760664),
            g1)
        )
    }
}
interface TournamentEndPoint{
//@Headers("Content-type: application/json")

    //@FormUrlEncoded
    @Headers("Content-type: application/json")
    @POST("tournaments/cadastra")
    suspend fun createTournament(@Body tournament: TournamentOnCreate): String


}