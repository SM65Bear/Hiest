package com.censkh.heist.util;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BuffData {

	private PotionEffectType type;
	private int amplifier;
	private int duration;

	public BuffData(PotionEffectType type, int duration, int amplifier) {
		this.type = type;
		this.amplifier = amplifier;
		this.duration = duration;
	}

	public PotionEffect toPotionEffect() {
		return new PotionEffect(getType(), getDuration(), getAmplifier());
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAmplifier() {
		return amplifier;
	}

	public void setAmplifier(int amplifier) {
		this.amplifier = amplifier;
	}

	public PotionEffectType getType() {
		return type;
	}

	public void setType(PotionEffectType type) {
		this.type = type;
	}

	public static String getBuffProperName(PotionEffectType type) {
		return type.getName().substring(0, 1) + type.getName().substring(1).toLowerCase();
	}
	
	public double getDurationAsSeconds() {
		return (double)getDuration()/20d;
	}

	@Override
	public String toString() {
		return getBuffProperName(getType()) + " " + getAmplifier() + " for " + getDurationAsSeconds() + " seconds.";
	}

}
