package com.censkh.heist.instance;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.censkh.heist.chat.Node;
import com.censkh.heist.listener.EventListener;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;
import com.sk89q.worldguard.protection.flags.StringFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Instance extends EventListener {

	private static int iid = 0;
	public static final String REGION_PREFIX = "instance_";

	private final int id = iid++;
	private final String name;
	private final List<Player> players = new ArrayList<Player>();
	private ProtectedRegion region;
	private boolean started = false;
	private final Scoreboard scoreboard;

	public Instance(ProtectedRegion region) {
		super();
		this.name = region.getId();
		this.region = region;
		scoreboard = createScoreboard();
		updateRegion();
	}

	private Scoreboard createScoreboard() {
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("sidebar", "dummy");
		objective.setDisplayName(Node.INSTANCE_NAME_COLOUR + getName());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.getScore(Bukkit.getOfflinePlayer("Started")).setScore(0);
		return scoreboard;
	}

	@Override
	public String toString() {
		return getName();
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

	public void updateRegion() {
		// ProtectedRegion region =getRegion();
		setFlag(DefaultFlag.GREET_MESSAGE, Node.INSTANCE_MESSAGE_COLOUR + "You have entered " + Node.INSTANCE_NAME_COLOUR + getName() + Node.INSTANCE_MESSAGE_COLOUR + ", there is "
				+ (isStarted() ? "a mission occuring" : "no mission going on") + ".");
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
			return region;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
		updateRegion();
		getObjective().getScore(Bukkit.getOfflinePlayer("Started")).setScore(started ? 1 : 0);
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public Objective getObjective() {
		return scoreboard.getObjective(DisplaySlot.SIDEBAR);
	}

}
