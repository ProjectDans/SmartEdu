package com.danscoding.evenity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventOrganizerListActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var listTeamList : ArrayList<ListTeam>
    private lateinit var listTeamAdapter : ListTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_organizer_list)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.rvListTeam)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listTeamList = ArrayList()

        listTeamList.add(ListTeam(R.drawable.music, "Maman Entertainment", "Event Organizer", (R.drawable.team3),"Rp 5.500.000", "5.0"))
        listTeamList.add(ListTeam(R.drawable.music, "VECHA Entertainment", "Weeding Organizer", (R.drawable.team5),"Rp 1.500.000", "4.5"))
        listTeamList.add(ListTeam(R.drawable.music, "Ogie Entertainment", "Weeding Organizer", (R.drawable.team1),"Rp 2.500.000", "4.5"))
        listTeamList.add(ListTeam(R.drawable.music, "Century Entertainment", "Event Organizer", (R.drawable.team4),"Rp 12.500.000", "4.5"))

        listTeamAdapter = ListTeamAdapter(listTeamList)
        recyclerView.adapter = listTeamAdapter

    }
}