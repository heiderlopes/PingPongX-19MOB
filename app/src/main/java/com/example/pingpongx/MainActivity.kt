package com.example.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        setUpPlayers()

        registerObserver()

        btPlayerOneScore.setOnClickListener {
            mainViewModel.goalPlayer1()
        }

        btPlayerTwoScore.setOnClickListener {
            mainViewModel.goalPlayer2()
        }

        btRevenge.setOnClickListener {
            mainViewModel.revenge()
        }

        btFinishMatch.setOnClickListener {
            finish()
        }
    }

    private fun registerObserver() {
        mainViewModel.playerOneScore.observe(this, Observer {
            tvPlayerOneScore.text = it.toString()
        })

        mainViewModel.playerTwoScore.observe(this, Observer {
            tvPlayerTwoScore.text = it.toString()
        })

    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }
}
