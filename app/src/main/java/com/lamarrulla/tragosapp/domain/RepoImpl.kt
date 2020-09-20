package com.lamarrulla.tragosapp.domain

import com.lamarrulla.tragosapp.data.model.DataSource
import com.lamarrulla.tragosapp.data.model.Drink
import com.lamarrulla.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
    override fun getTragosList(): Resource<List<Drink>> {
        return dataSource.generateTragosList
    }
}