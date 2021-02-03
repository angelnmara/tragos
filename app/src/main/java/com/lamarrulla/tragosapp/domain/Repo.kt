package com.lamarrulla.tragosapp.domain

import com.lamarrulla.tragosapp.data.model.Drink
import com.lamarrulla.tragosapp.vo.Resource

interface Repo {
    suspend fun getTragosList(tragoName:String):Resource<List<Drink>>
}