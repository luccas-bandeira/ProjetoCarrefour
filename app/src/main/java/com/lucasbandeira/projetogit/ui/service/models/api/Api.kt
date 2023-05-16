package com.lucasbandeira.projetogit.ui.service.models.api

import com.lucasbandeira.projetogit.ui.service.models.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<UsersResponse>
}