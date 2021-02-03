package com.lamarrulla.tragosapp.domain

import com.lamarrulla.tragosapp.data.model.DataSource
import com.lamarrulla.tragosapp.data.model.Drink
import com.lamarrulla.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
    override suspend fun getTragosList(tragoName:String): Resource<List<Drink>> {
        return dataSource.getTragoByName(tragoName)
    }
}