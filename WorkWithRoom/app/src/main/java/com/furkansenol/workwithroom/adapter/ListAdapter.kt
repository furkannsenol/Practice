package com.furkansenol.workwithroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.furkansenol.workwithroom.R
import com.furkansenol.workwithroom.model.User
import com.furkansenol.workwithroom.ui.fragment.ListFragmentDirections
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ListVH>() {

    private var userList = emptyList<User>()

    class ListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return ListVH(view)
    }

    override fun onBindViewHolder(holder: ListVH, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.firstName
        holder.itemView.lastName_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}