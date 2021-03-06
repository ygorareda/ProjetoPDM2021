package com.mobile.pytournaments.di

import com.google.android.gms.maps.model.LatLng
import com.mobile.pytournaments.domain.TournamentOnCreate
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.text.ParseException
import java.text.SimpleDateFormat

@Module
@InstallIn(SingletonComponent::class)
class PyTournamentsModule {

    @Throws(ParseException::class)
    fun createTournament(name: String?, description: String?,
                         date: String?, time: String?,
                         lat: Double?, lng:Double?, game: String,owner : String, user:String?
            ) : TournamentOnCreate {
        val date = SimpleDateFormat("dd/MM/yyyy HH:mm")
            .parse("$date $time")

        return TournamentOnCreate(name!!, description!!, date.toString(), LatLng(lat!!, lng!!), owner, game, user)
    }
}