package com.example.flagship

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flagship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var flagListAdapter: FlagListAdapter
    private lateinit var flagListData: FlagListData
    var dataArrayList = ArrayList<FlagListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryNameList = arrayOf(
            "Argentina",
            "Australia",
            "Brazil",
            "Canada",
            "China",
            "France",
            "Germany",
            "India",
            "Indonesia",
            "Italy",
            "Japan",
            "Mexico",
            "Philippines",
            "Russia",
            "Saudi Arabia",
            "South Africa",
            "South Korea",
            "Turkey",
            "United Kingdom",
            "United States")

        val capitalList = arrayOf(
            "Buenos Aires",   // Argentina
            "Canberra",       // Australia
            "Brasília",       // Brazil
            "Ottawa",         // Canada
            "Beijing",        // China
            "Paris",          // France
            "Berlin",         // Germany
            "New Delhi",      // India
            "Jakarta",        // Indonesia
            "Rome",           // Italy
            "Tokyo",          // Japan
            "Mexico City",    // Mexico
            "Manila",         // Philippines
            "Moscow",         // Russia
            "Riyadh",         // Saudi Arabia
            "Pretoria",       // South Africa
            "Seoul",          // South Korea
            "Ankara",         // Turkey
            "London",         // United Kingdom
            "Washington, D.C." /* United States*/)

        val countryImageList = intArrayOf(
            R.drawable.argentina,
            R.drawable.australia,
            R.drawable.brazil,
            R.drawable.canada,
            R.drawable.china,
            R.drawable.france,
            R.drawable.germany,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.italy,
            R.drawable.japan,
            R.drawable.mexico,
            R.drawable.philippines,
            R.drawable.russia,
            R.drawable.saudi_arabia,
            R.drawable.south_africa,
            R.drawable.south_korea,
            R.drawable.turkey,
            R.drawable.united_kingdom,
            R.drawable.united_states
        )

        for (i in countryImageList.indices) {
            flagListData = FlagListData(countryNameList[i], capitalList[i], countryImageList[i])
            dataArrayList.add(flagListData)
        }
        flagListAdapter = FlagListAdapter(this@MainActivity, dataArrayList)
        binding.flaglistview.adapter = flagListAdapter

    }
}