package com.example.tictactoe.ui.game

enum class EGameMode {
    PvP,
    PvC
}

enum class EPlayer(val sign: String) {
    First("x"),
    Second("o")
}