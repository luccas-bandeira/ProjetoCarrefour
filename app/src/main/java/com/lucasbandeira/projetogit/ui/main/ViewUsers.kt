package com.lucasbandeira.projetogit.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasbandeira.projetogit.ui.service.models.Users
import com.lucasbandeira.projetogit.ui.service.models.UsersResponse
import com.lucasbandeira.projetogit.ui.service.models.api.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewUsers : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<Users>>()

    fun setSearchUsers(query: String){
        Client.apiInstace
            .getSearchUser(query)
            .enqueue(object : Callback<UsersResponse>{
                override fun onResponse(
                    call: Call<UsersResponse>,
                    response: Response<UsersResponse>
                ) {
                    if (response.isSuccessful) {
                        listUsers.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                    t.message?.let { Log.d("Falha ao carregar usuários!", it) }
                }
            })
    }

    fun getSearchUsers(): LiveData<ArrayList<Users>>{
        return listUsers
    }
}