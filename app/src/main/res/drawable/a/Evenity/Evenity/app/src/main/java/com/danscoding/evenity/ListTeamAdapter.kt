package com.danscoding.evenity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ListTeamAdapter(private val listTeamList : List<ListTeam>) : RecyclerView.Adapter<ListTeamAdapter.ListTeamViewHolder>() {
    class ListTeamViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val listTeamImageProfile : CircleImageView = itemView.findViewById(R.id.circleProfileImageView)
        val listNameTeam : TextView = itemView.findViewById(R.id.textViewListNameTeam)
        val listCategoryTeam : TextView = itemView.findViewById(R.id.textViewListCategoriesTeam)
        val listImageTeam : ImageView = itemView.findViewById(R.id.imageViewListTeam)
        val listPriceTeam : TextView = itemView.findViewById(R.id.priceListTeam)
        val listRatingTeam : TextView = itemView.findViewById(R.id.textViewListRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_list_team, parent, false)
        return ListTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListTeamViewHolder, position: Int) {
        val listteam = listTeamList[position]
        holder.listTeamImageProfile.setImageResource(listteam.listProfileImage)
        holder.listNameTeam.text = listteam.listNameTeam
        holder.listCategoryTeam.text = listteam.listCategoriesTeam
        holder.listImageTeam.setImageResource(listteam.imageListTeam)
        holder.listPriceTeam.text = listteam.listPriceTeam
        holder.listRatingTeam.text = listteam.listRatingTeam
    }

    override fun getItemCount(): Int {
        return listTeamList.size
    }

}