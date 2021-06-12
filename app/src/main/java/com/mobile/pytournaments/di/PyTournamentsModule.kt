package com.mobile.pytournaments.di

import com.google.android.gms.maps.model.LatLng
import com.mobile.pytournaments.domain.Game
import com.mobile.pytournaments.domain.TournamentOnCreate
import com.mobile.pytournaments.domain.User
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@Module
@InstallIn(SingletonComponent::class)
class PyTournamentsModule {

    @Throws(ParseException::class)
    fun createTournament(name: String?, description: String?,
                         date: String?, time: String?,
                         lat: Double?, lng:Double?,
                         owner: User, game: Game
            ) : TournamentOnCreate {
        val date = SimpleDateFormat("dd/MM/yyyy HH:mm")
            .parse("$date $time")

        return TournamentOnCreate(name!!, description!!, date, "",
            LatLng(lat!!, lng!!), owner, game)
    }
}