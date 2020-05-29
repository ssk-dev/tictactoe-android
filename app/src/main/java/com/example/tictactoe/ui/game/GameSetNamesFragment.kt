package com.example.tictactoe.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.tictactoe.R
import com.example.tictactoe.SessionStorage

class GameSetNamesFragment : Fragment() {
    private lateinit var btnPlay: Button
    private lateinit var inputPlayer1: EditText
    private lateinit var inputPlayer2: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_game_set_names, container, false)
        val sessionStorage = activity?.let { SessionStorage(it) }
        val textView: TextView = view.findViewById(R.id.textView2)
        val selectedGameMode: TextView = view.findViewById(R.id.selectedGameMode)

        if (sessionStorage != null) {
            when (sessionStorage.getStorage(getString(R.string.game_mode))) {
                EGameMode.PvC.toString() -> {
                    selectedGameMode.text = "PvC is set"
                }
                EGameMode.PvP.toString() -> {
                    selectedGameMode.text = "PvP is set"
                }
            }
        }

        btnPlay = view.findViewById(R.id.btn_play)
        // btnPlay.visibility = View.INVISIBLE;
        btnPlay.setOnClickListener {
            inputPlayer1 = view.findViewById(R.id.input_player_name_1)
            inputPlayer2 = view.findViewById(R.id.input_player_name_2)

            sessionStorage!!.setStorage(
                getString(R.string.playerName1), inputPlayer1.text.toString()
            )
            sessionStorage!!.setStorage(
                getString(R.string.playerName2), inputPlayer2.text.toString()
            )

            Navigation.findNavController(view).navigate(R.id.gamePlayground);
        }

        return view
    }

}