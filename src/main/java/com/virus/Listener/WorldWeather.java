package com.virus.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldWeather implements Listener {
    @EventHandler
    public void weather(WeatherChangeEvent e){
        if(e.toWeatherState()){
            e.setCancelled(true);
        }
    }
}
