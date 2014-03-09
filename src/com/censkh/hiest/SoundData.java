package com.censkh.hiest;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundData {

	private Sound sound;
	private float pitch;
	private float volume;

	public SoundData(Sound sound, float volume, float pitch) {
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public void play(Player player) {
		player.playSound(player.getLocation(), getSound(), getVolume(), getPitch());
	}

	public void play(Location location) {
		location.getWorld().playSound(location, getSound(), getVolume(), getPitch());
	}

}
