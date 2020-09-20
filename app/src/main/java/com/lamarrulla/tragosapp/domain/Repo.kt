package com.lamarrulla.tragosapp.domain

import com.lamarrulla.tragosapp.data.model.Drink
import com.lamarrulla.tragosapp.vo.Resource

interface Repo {
    fun getTragosList():Resource<List<Drink>>
}