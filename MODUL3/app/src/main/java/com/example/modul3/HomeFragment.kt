package com.example.modul3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul3.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var dramaAdapter: ListDramaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val dramas = listOf(
            Drama(
                "Mysterious Lotus Casebook",
                "2023",
                "Mystery, Wuxia",
                "40 Episodes",
                "https://i.mydramalist.com/kAozjj_4c.jpg?v=1",
                "https://www.iq.com/album/mysterious-lotus-casebook-2023-hg4cefqzed?lang=en_us"
            ),
            Drama(
                "Love Game In Eastern Fantasy",
                "2024",
                "Romance, Wuxia, Fantasy",
                "32 Episodes",
                "https://i.mydramalist.com/VXOLzy_4c.jpg?v=1",
                "https://wetv.vip/en/play/227hqhmxvabwggz/d4100tnphtz"
            ),
            Drama(
                "Melody of Golden Age",
                "2024",
                "Historical, Mystery, Romance, Drama",
                "40 Episodes",
                "https://i.mydramalist.com/d0Q62d_4c.jpg?v=1",
                "https://www.iq.com/album/melody-of-golden-age-2025-vobwm47vvd?lang=en_us"
            ),
            Drama(
                "One And Only",
                "2021",
                "Military, Historical, Romance, Political",
                "24 Episodes",
                "https://i.mydramalist.com/BLrkR_4c.jpg?v=1",
                "https://www.iq.com/album/one-and-only-2021-24mppdujjp9?lang=en_us"
            ),
            Drama(
                "Go Ahead",
                "2020",
                "Comedy, Romance, Drama, Melodrama",
                "46 Episodes",
                "https://i.mydramalist.com/exXvQ_4c.jpg?v=1",
                "https://www.iq.com/album/go-ahead-2020-1bm24k36pk9?lang=en_us"
            )
        )

        dramaAdapter = ListDramaAdapter(dramas) { selectedDrama ->
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable("drama", selectedDrama)
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dramaAdapter
        }
        return binding.root
    }
}