package com.danscoding.smartedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.danscoding.smartedu.databinding.ActivityHomepageBinding
import com.danscoding.smartedu.fragment.BookFragment
import com.danscoding.smartedu.fragment.HomeFragment
import com.danscoding.smartedu.fragment.ProfileFragment
import com.danscoding.smartedu.fragment.SearchFragment

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
//    private lateinit var adapter: ImageSliderAdapter
//    private val list = ArrayList<ImageData>()
//    private lateinit var dots : ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search ->replaceFragment(SearchFragment())
                R.id.book -> replaceFragment(BookFragment())
                R.id.profile -> replaceFragment(ProfileFragment())

                else ->{

                }
            }
            true
        }

//        list.add(
//            ImageData(
//                "https://images.unsplash.com/photo-1541872703-74c5e44368f9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2006&q=80"
//            )
//        )
//
//        list.add(
//            ImageData(
//                "https://images.unsplash.com/photo-1541726260-e6b6a6a08b27?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=859&q=80"
//            )
//        )
//
//        list.add(
//            ImageData(
//                "https://images.unsplash.com/photo-1557081998-05f784dcdd41?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80"
//            )
//        )
//
//        adapter = ImageSliderAdapter(list)
//        binding.viewPager.adapter = adapter
//        dots = ArrayList()
//        setIndicator()
//
//        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                selectedDot(position)
//                super.onPageSelected(position)
//            }
//        })

//        binding.displayName.text = intent.getStringExtra(EXTRA_NAME)
//        binding.btnLogout.setOnClickListener {
//            Firebase.auth.signOut()
//
//            val intent = Intent(applicationContext, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }

//    private fun selectedDot(position: Int) {
//        for (i in 0 until list.size){
//            if (1 == position)
//                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_primary))
//            else
//                dots[i].setTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_secondary))
//        }
//    }
//
//    private fun setIndicator() {
//        for (i in 0 until list.size){
//            dots.add(TextView(this))
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
//            } else {
//                dots[i].text = Html.fromHtml("&#9679")
//            }
//            dots[i].textSize = 18f
//            binding.dotsIndicator.addView(dots[i])
//        }
//    }
}