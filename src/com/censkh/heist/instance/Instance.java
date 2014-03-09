package com.censkh.heist.instance;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.censkh.heist.chat.Node;
import com.censkh.heist.listener.EventListener;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;
import com.sk89q.worldguard.protection.flags.StringFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Instance extends EventListener {

	private static int iid = 0;

	private final int id = iid++;
	private final String name;
	private World world;
	private final List<Player> players = new ArrayList<Player>();
	private ProtectedRegion region;
	private boolean started = false;

	public Instance(String name) {
		super();
		this.name = name;
		World world = null;
		for (World w : Bukkit.getWorlds()) {
			if (WorldGuardPlugin.inst().getRegionManager(w).hasRegion(getRegionName())) {
				world = w;
			}
		}
		setWorld(world);
		if (!hasRegion()) {
			System.out.println("Instance " + toString() + " does not have a w/g region setup, fix it stupids. Create a region called '" + getRegionName() + "'");
		} else {
			updateRegion();
		}
	}

	@Override
	public String toString() {
		return getRegionName() + "(name:" + getName() + ")";
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
		return "instance-" + getId();
	}

	public boolean hasRegion() {
		return getWorld() != null;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public void updateRegion() {
		if (!hasRegion()) {
			return;
		}
		// ProtectedRegion region =getRegion();
		setFlag(DefaultFlag.GREET_MESSAGE, Node.INSTANCE_MESSAGE_COLOUR + "You have entered " + Node.INSTANCE_NAME_COLOUR + getName() + Node.INSTANCE_MESSAGE_COLOUR + ".");
		setFlag(DefaultFlag.FAREWELL_MESSAGE, Node.INSTANCE_MESSAGE_COLOUR + "You have left " + Node.INSTANCE_NAME_COLOUR + getName() + Node.INSTANCE_MESSAGE_COLOUR + ".");
	}

	public void setFlag(StringFlag flag, String value) {
		try {
			getRegion().setFlag(flag, flag.parseInput(WorldGuardPlugin.inst(), Bukkit.getConsoleSender(), value));
		} catch (InvalidFlagFormat e) {
			e.printStackTrace();
		}
	}

	public ProtectedRegion getRegion() {
		if (region == null) {
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

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
		updateRegion();
	}

}
