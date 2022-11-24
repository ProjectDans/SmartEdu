package com.danscoding.smartedu.fragment

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.danscoding.smartedu.*
import com.danscoding.smartedu.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>

    //recycler view
    private lateinit var artikelRecyclerview : RecyclerView
    private lateinit var artikelArrayList: ArrayList<Artikel>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        list.add(
            ImageData(
                "https://images.unsplash.com/photo-1541872703-74c5e44368f9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2006&q=80"
            )
        )

        list.add(
            ImageData(
                "https://images.unsplash.com/photo-1541726260-e6b6a6a08b27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=859&q=80"
            )
        )

        list.add(
            ImageData(
                "https://images.unsplash.com/photo-1557081998-05f784dcdd41?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })

        //RECYCLER VIEW
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
        )

        heading = arrayOf(
            "Wabah menari yang membuat pengidapnya tak berhenti menari. Anak tiktok minggir dulu!",
            "Babayaga membalas komentar anda!",
            "Inilah yang dirasakan pengidap corona",
            "Tenarnya pementasan Blackface di abad ke-19. Rasis banget!"
        )

        artikelRecyclerview = binding.recyclerView
        artikelRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        artikelRecyclerview.setHasFixedSize(true)

        artikelArrayList = arrayListOf<Artikel>()
        getUserData()

//        binding.displayName.text = intent.getStringExtra(EXTRA_NAME)
//        binding.btnLogout.setOnClickListener {
//            Firebase.auth.signOut()
//
//            val intent = Intent(applicationContext, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }



        return view
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val artikel = Artikel(imageId[i], heading[i])
            artikelArrayList.add(artikel)
        }
        artikelRecyclerview.adapter = MyAdapter(artikelArrayList)
    }

    private fun setIndicator() {
        for (i in 0 until list.size){
            dots.add(TextView(requireContext()))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    private fun selectedDot(position: Int) {
        for (i in 0 until list.size){
            if (1 == position)
                dots[i].setTextColor(ContextCompat.getColor(requireContext(), com.google.android.material.R.color.design_default_color_primary))
            else
                dots[i].setTextColor(ContextCompat.getColor(requireContext(), com.google.android.material.R.color.design_default_color_secondary))
        }
    }


}