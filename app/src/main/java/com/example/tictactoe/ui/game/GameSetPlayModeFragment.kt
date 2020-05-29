package com.example.tictactoe.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.tictactoe.R
import com.example.tictactoe.SessionStorage


class GameSetPlayModeFragment : Fragment() {
    private lateinit var btnPvP: Button
    private lateinit var btnPvC: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game_mode, container, false)
        val sessionStorage = activity?.let { SessionStorage(it) }

        btnPvP = view.findViewById<Button>(R.id.btn_pvp)
        btnPvP.setOnClickListener {
            sessionStorage!!.setStorage(getString(R.string.game_mode), EGameMode.PvP.toString())
            btnPvP.text = sessionStorage.getStorage(getString(R.string.game_mode))
            Navigation.findNavController(view).navigate(R.id.gameSetNamesFragment);
        }

        btnPvC = view.findViewById<Button>(R.id.btn_pvc)
        btnPvC.setOnClickListener {
            sessionStorage!!.setStorage(getString(R.string.game_mode), EGameMode.PvC.toString())
            btnPvC.text = sessionStorage.getStorage(getString(R.string.game_mode))
            Navigation.findNavController(view).navigate(R.id.gameSetNamesFragment);
        }

        return view
    }

}