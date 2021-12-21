package com.example.basketballscore;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        updatePoints();

        binding.btnLocalM1.setOnClickListener(v -> {
            viewModel.local(0);
            updatePoints();
        });
        binding.btnLocalP1.setOnClickListener(v -> {
            viewModel.local(1);
            updatePoints();
        });
        binding.btnLocalP2.setOnClickListener(v -> {
            viewModel.local(2);
            updatePoints();
        });
        binding.btnReset.setOnClickListener(v -> {
            opciones(1);
        });
        binding.btnSig.setOnClickListener(v -> {
            opciones(2);
        });
        binding.btnVisitorM1.setOnClickListener(v -> {
            viewModel.visitor(0);
            updatePoints();
        });
        binding.btnVisitorP1.setOnClickListener(v -> {
            viewModel.visitor(1);
            updatePoints();
        });
        binding.btnVisitorP2.setOnClickListener(v -> {
            viewModel.visitor(2);
            updatePoints();
        });
    }

    public void updatePoints(){
        String LP = Integer.toString(viewModel.getLocalPoints().getValue());
        String VP = Integer.toString(viewModel.getVisitorPoints().getValue());
        binding.txtPuntosLocal.setText(LP);
        binding.txtPuntosVisitor.setText(VP);
    }



    public void opciones(int opc){
        if (opc == 1){
            viewModel.reset();
            updatePoints();
            Toast.makeText(this, "Se limpiaron los marcadores", Toast.LENGTH_SHORT).show();
        }
        if (opc == 2){
            Intent cambio = new Intent(this, finalScores.class);
            cambio.putExtra("local_points", viewModel.getLocalPoints().getValue());
            cambio.putExtra("visitor_points", viewModel.getVisitorPoints().getValue());
            startActivity(cambio);
        }
    }
}