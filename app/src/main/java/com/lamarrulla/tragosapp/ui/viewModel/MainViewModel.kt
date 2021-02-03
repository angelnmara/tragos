package com.lamarrulla.tragosapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lamarrulla.tragosapp.domain.Repo
import com.lamarrulla.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo):ViewModel() {
    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try{
            emit(repo.getTragosList("margarita"))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}