package com.example.tictactoe.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tictactoe.GameActivity
import com.example.tictactoe.R

class HomeFragment : Fragment() {
    private lateinit var btnStartGame: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        btnStartGame = view.findViewById<Button>(R.id.btn_start_game)
        btnStartGame.setOnClickListener {
            val intent = Intent (activity, GameActivity::class.java)
            activity?.startActivity(intent)
        }

        return view
    }
}
