package com.domotica.creep.iot.app.iotcreep;

import android.app.Application;

import com.domotica.creep.iot.app.iotcreep.util.Constants;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;
/**
 * Created by Billy.Caballero on 1/26/17.
 */

public class DomoticaApplication extends Application {

    private Socket socket;
    {
        try {
            socket = IO.socket(Constants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
