package com.censkh.heist.drug;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import com.censkh.heist.BuffData;

public class DrugData {
	
	private final List<BuffData> buffs = new ArrayList<BuffData>();
	
	public List<String> toLore() {
		List<String> lore = new ArrayList<String>();
		for (BuffData data : getBuffs()) {
			lore.add(ChatColor.GRAY + data.toString());
		}
		return lore;
	}
	
	public void addBuff(BuffData data) {
		buffs.add(data);
	}

	public List<BuffData> getBuffs() {
		return buffs;
	}


}
