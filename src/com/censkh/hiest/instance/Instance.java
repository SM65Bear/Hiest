package com.censkh.hiest.instance;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;
import com.sk89q.worldguard.protection.flags.StringFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Instance {

	private static int iid = 0;

	private final int id = iid++;
	private final String name;
	private World world;
	private final List<Player> players = new ArrayList<Player>();
	private ProtectedRegion region;

	public Instance(String name) {
		this.name = name;
		World world = null;
		for (World w : Bukkit.getWorlds()) {
			if (WorldGuardPlugin.inst().getRegionManager(w).hasRegion(getRegionName())) {
				world = w;
			}
		}
		setWorld(world);
		if (!hasRegion()) {
			System.out.println("Instance " + toString() + " does not have a w/g region setup, fix it stupids. Create a region called '"+getRegionName()+"'");
		} else {
			initRegion();
		}
	}
	
	@Override
	public String toString() {
		return getRegionName() + "(name:"+getName()+")";
	}

	public List<Player> getPlayers() {
		return players;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public String getRegionName() {
		return "instance-"+getId();
	}
	
	public boolean hasRegion() {
		return getWorld()!=null;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public void initRegion() {
		if (!hasRegion()) {
			return;
		}
		//ProtectedRegion region =getRegion();
		setFlag(DefaultFlag.GREET_MESSAGE, ChatColor.YELLOW + "You have entered " + getName() + ".");
	}
	
	public void setFlag(StringFlag flag, String value) {
		try {
			getRegion().setFlag(flag, flag.parseInput(WorldGuardPlugin.inst(), Bukkit.getConsoleSender(), value));
		} catch (InvalidFlagFormat e) {
			e.printStackTrace();
		}
	}
	
	public ProtectedRegion getRegion() {
		if (region==null) {
			if (hasRegion()) {
				region = WorldGuardPlugin.inst().getRegionManager(getWorld()).getRegion(getRegionName());
				return region;
			} else {
				return null;
			}
		} else {
			return region;
		}
		
	}
	
}
