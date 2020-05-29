package com.example.tictactoe.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tictactoe.R
import com.example.tictactoe.SessionStorage

class GamePlaygroundFragment : Fragment() {

    private var currentPlayer: String = EPlayer.First.sign
    private lateinit var message: TextView
    private lateinit var field1: TextView
    private lateinit var field2: TextView
    private lateinit var field3: TextView
    private lateinit var field4: TextView
    private lateinit var field5: TextView
    private lateinit var field6: TextView
    private lateinit var field7: TextView
    private lateinit var field8: TextView
    private lateinit var field9: TextView

    private var gameEnd: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view: View = inflater.inflate(R.layout.fragment_game_playground, container, false)
        val sessionStorage = activity?.let { SessionStorage(it) }
        sessionStorage!!.getStorage(getString(R.string.playerName1))
        sessionStorage.getStorage(getString(R.string.playerName2))



        message = view.findViewById(R.id.message)
        message.text = "${currentPlayer} starts.."

        initFields(view);
        val matrix = arrayOf<TextView>(
            field1,
            field2,
            field3,
            field4,
            field5,
            field6,
            field7,
            field8,
            field9
        )
        setClickListenerForFields(matrix)


        return view
    }

    private fun initFields(view: View) {
        field1 = view.findViewById<TextView>(R.id.field1)
        field2 = view.findViewById<TextView>(R.id.field2)
        field3 = view.findViewById<TextView>(R.id.field3)
        field4 = view.findViewById<TextView>(R.id.field4)
        field5 = view.findViewById<TextView>(R.id.field5)
        field6 = view.findViewById<TextView>(R.id.field6)
        field7 = view.findViewById<TextView>(R.id.field7)
        field8 = view.findViewById<TextView>(R.id.field8)
        field9 = view.findViewById<TextView>(R.id.field9)
    }

    private fun setClickListenerForFields(matrix: Array<TextView>) {
        for (field in matrix) {
            field.setOnClickListener {
                onFieldClick(it as TextView, matrix)
            }
        }
    }

    private fun onFieldClick(field: TextView, matrix: Array<TextView>) {
        message.setTextColor(getResources().getColor(R.color.light))

        when (field.text.isEmpty()) {
            true -> {
                field.text = currentPlayer
                if (currentPlayer == EPlayer.First.sign) {
                    field.setTextColor(getResources().getColor(R.color.purple))
                    if (won()) {
                        message.text = "${currentPlayer} wins"
                    } else {
                        currentPlayer = EPlayer.Second.sign
                        message.text = "next ${currentPlayer}"
                    }
                } else {
                    field.setTextColor(getResources().getColor(R.color.cyan))

                    if (won()) {
                        message.text = "${currentPlayer} wins"
                    } else {
                        currentPlayer = EPlayer.First.sign
                        message.text = "next ${currentPlayer} ${won()}"
                    }
                }

            }

            false -> {
                message.setTextColor(getResources().getColor(R.color.error))
                message.text = "Field is already Set"
            }
        }
    }

    private fun isFieldNotSet(field: TextView): Boolean = field.text.isEmpty()

    private fun won(): Boolean =
        field1.text == field2.text && field2.text == field3 && field1.text.isNotEmpty() ||
        field4.text == field5.text && field5.text == field6 && field4.text.isNotEmpty() ||
        field7.text == field8.text && field8.text == field9 && field7.text.isNotEmpty() ||
        field1.text == field4.text && field4.text == field7 && field1.text.isNotEmpty() ||
        field2.text == field5.text && field5.text == field8 && field2.text.isNotEmpty() ||
        field3.text == field6.text && field6.text == field9 && field3.text.isNotEmpty() ||
        field1.text == field5.text && field5.text == field9 && field1.text.isNotEmpty() ||
        field3.text == field5.text && field5.text == field7 && field3.text.isNotEmpty()
}
