package com.example.modul3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.modul3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val drama = arguments?.getParcelable<Drama>("drama")
        drama?.let { selectedDrama ->
            binding.drama = selectedDrama

            binding.openLinkButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(selectedDrama.link))
                startActivity(intent)
            }

            binding.backButton.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return binding.root
    }
}