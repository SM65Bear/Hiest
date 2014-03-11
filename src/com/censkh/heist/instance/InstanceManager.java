package com.censkh.heist.instance;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class InstanceManager {

	private static InstanceManager instance;
	private final List<Instance> instances = new ArrayList<Instance>();

	public InstanceManager() {
		instance = this;
		init();
	}

	public void init() {
		instances.clear();
		for (World world : Bukkit.getWorlds()) {
			RegionManager regionManager = WorldGuardPlugin.inst().getRegionManager(world);
			for (ProtectedRegion region : regionManager.getRegions().values()) {
				if (region.getId().startsWith(Instance.REGION_PREFIX)) {
					add(new Instance(region));
				}
			}
		}
	}

	private void add(Instance instance) {
		instances.add(instance);
	}

	public static InstanceManager getInstance() {
		return instance;
	}

	public List<Instance> getInstances() {
		return instances;
	}

	public Instance getInstanceById(int i) {
		for (Instance inst : getInstances()) {
			if (inst.getId() == i) {
				return inst;
			}
		}
		return null;
	}

}
