package com.lucasbandeira.projetogit.ui.main

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.lucasbandeira.projetogit.databinding.UsersBinding
import com.lucasbandeira.projetogit.ui.service.models.Users

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val list = ArrayList<Users>()

    fun setList(users: ArrayList<Users>){
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: UsersBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: Users) {
            binding.apply {
                Glide.with(itemView)
                    .load(user.avatar_url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(avatarUser)
                tvUsername.text = user.login
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder((view))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}