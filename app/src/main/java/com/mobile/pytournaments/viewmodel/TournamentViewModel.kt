package com.mobile.pytournaments.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobile.pytournaments.domain.Tournament
import com.mobile.pytournaments.interactor.TournamentInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TournamentViewModel @Inject constructor(
    app: Application,
    private val interactor: TournamentInteractor
): AndroidViewModel(app) {
//   muitas variaveis que guardam o msm tipo de dado
//   talvez não haja necessidade de utilizar mais de uma variável
//   que recebe de funções diferentes.
//   Corgitar a idéia de fragmentar o TournamentViewModel em um
//   ViewModel para cada tela.

    val subscribedTournaments = MutableLiveData< List<Tournament> >()
    val suggestedTournaments = MutableLiveData< List<Tournament> >()
    val searchedOnlineTournaments = MutableLiveData< List<Tournament> >()
    val searchedLocalTournaments = MutableLiveData< List<Tournament> >()

    fun loadSubscribedTournaments () {
        //inserir viewmodels.launch depois que colocar o retrofit
        subscribedTournaments.value = interactor.loadSubscribedTournamentsData()
    }

    fun loadSuggestedTournaments() {
        suggestedTournaments.value = interactor.loadSubscribedTournamentsData()
    }

    fun loadSearchedTournaments(){
        searchedOnlineTournaments.value = interactor.loadSubscribedTournamentsData()
        searchedLocalTournaments.value = interactor.loadSubscribedTournamentsData()
    }
}