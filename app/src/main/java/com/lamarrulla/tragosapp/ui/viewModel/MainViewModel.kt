package com.lamarrulla.tragosapp.ui.viewModel

import androidx.lifecycle.*
import com.lamarrulla.tragosapp.domain.Repo
import com.lamarrulla.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo):ViewModel() {

    private val tragosData = MutableLiveData<String>()

    fun setTrago(tragoName:String){
        tragosData.value = tragoName
    }

    /*init {
        setTrago("margarita")
    }*/

    val fetchTragosList = tragosData.distinctUntilChanged().switchMap {nombreTrago ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try{
                emit(repo.getTragosList(nombreTrago))
            }catch (e:Exception){
                emit(Resource.Failure(e))
            }
        }
    }
}