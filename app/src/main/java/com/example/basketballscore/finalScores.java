package com.example.basketballscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.basketballscore.databinding.ActivityFinalScoresBinding;
import com.example.basketballscore.databinding.ActivityMainBinding;

public class finalScores extends AppCompatActivity {

    ActivityFinalScoresBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalScoresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle data = getIntent().getExtras();
        String localP = Integer.toString(data.getInt("local_points"));
        String visitorP = Integer.toString(data.getInt("visitor_points"));
        binding.txtEdiLocal1.setText(localP);
        binding.txtEdiVisitor1.setText(visitorP);
        resultados(data.getInt("local_points"), data.getInt("visitor_points"));
    }

    private void resultados(int local, int visit){
        if (local == visit){
            binding.txtResult.setText("Fue un empate 😐");
        }else {
            if (local>visit) {
                binding.txtResult.setText("¡Ganó el equipo local!");
            }else {
                binding.txtResult.setText("¡Ganó el equipo Visitante!");
            }
        }
    }
}