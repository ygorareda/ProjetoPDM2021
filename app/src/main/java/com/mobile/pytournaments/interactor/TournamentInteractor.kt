package com.mobile.pytournaments.interactor

import android.content.Context
import android.util.Log
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mobile.pytournaments.R
import com.mobile.pytournaments.di.PyTournamentsModule
import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.Result
import com.mobile.pytournaments.domain.TournamentOnCreate
import com.mobile.pytournaments.domain.User
import com.mobile.pytournaments.repository.TournamentRepository
import com.mobile.pytournaments.viewmodel.LoggedUserViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.ParseException
import javax.inject.Inject

class TournamentInteractor @Inject constructor(
    private val repository: TournamentRepository,
    @ApplicationContext val context: Context

) {
    val user = Firebase.auth.currentUser
    private val loggedUser = User(2, "LoggedUser", "Usuario", "", "")

    fun loadSubscribedTournamentsData() = repository.searchForSubscribedTournament()

    suspend fun registerTournament(name: String?, description: String?,
                                   date: String?, time: String?,
                                   lat: Double?, lng:Double?, checkboxValue: Boolean): String {
        /*Result{
        val result = validateTournamentData(name, description, date, time, lat, lng)

        if(!result.success){
            return result
        }
*/
        if (name != null) {
            Log.d("teste", name)
        }
        if (description != null) {
            Log.d("teste", description)
        }
        if (date != null) {
            Log.d("teste", date)
        }
        if (time != null) {
            Log.d("teste", time)
        }
        Log.d("teste", lat.toString())
        Log.d("teste", lng.toString())


        val newTournament =
            PyTournamentsModule().createTournament(
                name, description, date,
                time, lat, lng,user.uid ,"valorant",user.uid )
        return repository.registerNewTournament(newTournament)
        /*return try {



            if (checkboxValue) {
                newTournament.participants.add(loggedUser)
            }


        } catch (e: ParseException) {
            //Result(false, context.getString(R.string.datetime_error), null)
            Log.d("teste","Deu ruim")

        }.toString()*/

    }

    private fun validateTournamentData(name:String?, description: String?,
                                       date: String?, time: String?,
                                       lat: Double?, lng:Double?): Result{
        if(name.isNullOrBlank()){
            return Result(false, context.getString(R.string.blank_name), null)
        }

        if(description.isNullOrBlank()){
            return Result(false, context.getString(R.string.blank_description), null)
        }

        if(date.isNullOrBlank()){
            return Result(false, context.getString(R.string.blank_date), null)
        }

        if(time.isNullOrBlank()){
            return Result(false, context.getString(R.string.blank_time), null)
        }

        if(lat == null || lng == null){
            return Result(false, context.getString(R.string.null_location), null)
        }

        return Result(true, "", null)
    }
}