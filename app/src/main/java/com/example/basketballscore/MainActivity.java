package com.example.basketballscore;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public int localPoints, visitorPoints;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localPoints = 0;
        visitorPoints = 0;
        updatePoints();

        binding.btnLocalM1.setOnClickListener(v -> {
            local(0);
        });
        binding.btnLocalP1.setOnClickListener(v -> {
            local(1);
        });
        binding.btnLocalP2.setOnClickListener(v -> {
            local(2);
        });
        binding.btnReset.setOnClickListener(v -> {
            opciones(1);
        });
        binding.btnSig.setOnClickListener(v -> {
            opciones(2);
        });
        binding.btnVisitorM1.setOnClickListener(v -> {
            visitor(0);
        });
        binding.btnVisitorP1.setOnClickListener(v -> {
            visitor(1);
        });
        binding.btnVisitorP2.setOnClickListener(v -> {
            visitor(2);
        });
    }

    public void updatePoints(){
        String LP = Integer.toString(localPoints);
        String VP = Integer.toString(visitorPoints);
        binding.txtPuntosLocal.setText(LP);
        binding.txtPuntosVisitor.setText(VP);
    }

    public void local(int opc){
        switch (opc){
            case 0:
                if (localPoints>0){
                    localPoints = localPoints-1;
                    updatePoints();
                }else{
                    Toast.makeText(this, "Tiene el minimo de puntos el equipo local", Toast.LENGTH_SHORT).show();
                }
            break;
            case 1:
                localPoints += 1;
                updatePoints();
            break;
            case 2:
                localPoints += 2;
                updatePoints();
            break;
        }
    }

    public void visitor(int opc){
        switch (opc){
            case 0:
                if (visitorPoints>0){
                    visitorPoints = visitorPoints-1;
                    updatePoints();
                }else{
                    Toast.makeText(this, "Tiene el minimo de puntos el equipo visitante", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                visitorPoints += 1;
                updatePoints();
                break;
            case 2:
                visitorPoints += 2;
                updatePoints();
                break;
        }
    }

    public void opciones(int opc){
        if (opc == 1){
            localPoints = 0;
            visitorPoints = 0;
            updatePoints();
            Toast.makeText(this, "Se limpiaron los marcadores", Toast.LENGTH_SHORT).show();
        }
        if (opc == 2){
            Intent cambio = new Intent(this, finalScores.class);
            cambio.putExtra("local_points", localPoints);
            cambio.putExtra("visitor_points", visitorPoints);
            startActivity(cambio);
        }
    }
}