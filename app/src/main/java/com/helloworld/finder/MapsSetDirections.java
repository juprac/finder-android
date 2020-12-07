package com.helloworld.finder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MapsSetDirections extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_direction);

        final EditText etOrigen = findViewById(R.id.etOrigen);
        final EditText etDestino = findViewById(R.id.etDestino);
        Button btGoToDestination = findViewById(R.id.btGoToDestination);

        btGoToDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String origin = etOrigen.getText().toString();
                String destination = etDestino.getText().toString();

                if (origin.isEmpty() || destination.isEmpty()){
                    return;
                }

                try {
                    String originEncoded = URLEncoder.encode(origin, "utf-8");
                    String destinationEncoded = URLEncoder.encode(destination, "utf-8");

                    Intent intent = new Intent(MapsSetDirections.this, MapsInputPolylineActivity.class);
                    intent.putExtra("from_location", originEncoded);
                    intent.putExtra("to_location", destinationEncoded);
                    startActivity(intent);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
