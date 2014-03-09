package com.censkh.heist.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.censkh.heist.Hiest;

public abstract class EventListener implements Listener {

	public static void createListeners() {
		new EntityEventListener();
		new PlayerEventListener();
	}

	public EventListener() {
		Bukkit.getPluginManager().registerEvents(this, Hiest.getPlugin(Hiest.class));
	}

}
