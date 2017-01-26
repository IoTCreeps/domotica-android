package com.domotica.creep.iot.app.iotcreep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    private Socket socket;
    @BindView(R.id.dimming_seek_bar) SeekBar dimmingSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DomoticaApplication domoticaApplication = (DomoticaApplication) getApplication();
        socket = domoticaApplication.getSocket();
        socket.connect();

        dimmingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.v("DIMMING", "" + progress);
                socket.emit("dimming", progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
