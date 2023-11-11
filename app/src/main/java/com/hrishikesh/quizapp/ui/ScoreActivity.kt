package com.hrishikesh.quizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrishikesh.quizapp.R
import com.hrishikesh.quizapp.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    private var score : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra("SCORE", 0)

        binding.tvScore.text = score.toString()
    }
}