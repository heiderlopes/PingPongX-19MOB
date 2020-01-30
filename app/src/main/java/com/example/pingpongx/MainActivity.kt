package com.example.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPlayers()
    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }
}
