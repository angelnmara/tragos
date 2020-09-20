package com.lamarrulla.tragosapp.data.model

import com.lamarrulla.tragosapp.vo.Resource

class DataSource {
    val generateTragosList= Resource.Success(listOf(
        Drink("https://images.absolutdrinks.com/drink-images/Raw/Absolut/c8bc404c-fc30-4ec8-a9a5-0dca3913bbbb.jpg?imwidth=500", "Margarita", "vodka"),
        Drink("https://elresaltador.com.ar/wp-content/uploads/2020/08/Dise%C3%B1o-sin-t%C3%ADtulo-13-1.jpg", "Fernet", "coca"),
        Drink("https://birrapedia.com/img/modulos/cerveza/3a2/toro-de-osborne_1461086291776_t.jpg", "Toro", "Toro con preatyy"),
        Drink("https://lh3.googleusercontent.com/proxy/Mv3tTB6y9rSPHaBoegTPArLZ0MuMN4_SCvwSEY-ZRBYxusgzHHA-QZD97WKhe4lKBUPhNEvv-CAwwom3BcTtru9d7WgwHDfbNmA", "Gancia", "Gancia con sprite")
    ))
}