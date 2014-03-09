package com.censkh.heist.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;

public class EventBlockManager {
	
	private static EventBlockManager instance;
	private final List<Block> blocks = new ArrayList<Block>();
	
	public EventBlockManager() {
		instance = this;
	}
	
	public static EventBlockManager getInstance() {
		return instance;
	}

	public List<Block> getBlocks() {
		return blocks;
	}
	
}
