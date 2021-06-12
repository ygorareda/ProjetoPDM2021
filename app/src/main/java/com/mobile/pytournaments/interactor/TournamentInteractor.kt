package com.mobile.pytournaments.interactor

import android.content.Context
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

    private val loggedUser = User(2, "LoggedUser", "Usuario", "", "")

    fun loadSubscribedTournamentsData() = repository.searchForSubscribedTournament()

    fun registerTournament(name: String?, description: String?,
                           date: String?, time: String?,
                           lat: Double?, lng:Double?, checkboxValue: Boolean): Result{
        val result = validateTournamentData(name, description, date, time, lat, lng)

        if(!result.success){
            return result
        }

        return try{
            val newTournament =
                PyTournamentsModule().createTournament(name, description, date,
                time, lat, lng,loggedUser, Game(1, "", "","")
            )
            if (checkboxValue){
                newTournament.participants.add(loggedUser)
            }

            repository.registerNewTournament(newTournament)
        }catch(e: ParseException){
            Result(false, context.getString(R.string.datetime_error), null)
        }
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