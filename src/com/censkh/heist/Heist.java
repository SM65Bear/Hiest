package com.censkh.heist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.censkh.heist.event.EventBlockManager;
import com.censkh.heist.gui.GuiMenuManager;
import com.censkh.heist.gun.Gun;
import com.censkh.heist.gun.GunManager;
import com.censkh.heist.gun.GunStack;
import com.censkh.heist.gun.GunState;
import com.censkh.heist.instance.Instance;
import com.censkh.heist.instance.InstanceManager;
import com.censkh.heist.listener.EventListener;
import com.censkh.heist.throwable.ThrowableManager;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Heist extends JavaPlugin {

	private final Random random = new Random();
	public static int ticks = 0;

	@Override
	public void onEnable() {
		new InstanceManager();
		new EventBlockManager();
		new ThrowableManager();
		new GunManager();
		new GuiMenuManager();
		EventListener.createListeners();
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				List<World> worlds = new ArrayList<World>();
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (!worlds.contains(player.getWorld())) {
						worlds.add(player.getWorld());
					}
					if (player.getItemInHand() != null) {
						if (player.getItemInHand().getType() != Material.AIR) {
							Gun gun = GunManager.getInstance().getGun(player.getItemInHand());
							if (gun != null) {
								GunStack stack = new GunStack(player.getItemInHand());
								if (stack.getState() == GunState.RELOADING) {
									stack.setReloadCountdown(stack.getReloadCountdown() - 1);
									if (stack.getReloadCountdown() % 10 == 0)
										player.playSound(player.getLocation(), random.nextBoolean() ? Sound.DOOR_CLOSE : Sound.DOOR_OPEN, 1f, 2f);
								}
								player.setItemInHand(stack.write());
								if (GunManager.getInstance().isZoomed(player)) {
									gun.zoom(player);
								}
							} else {
								GunManager.getInstance().setZoomed(player, false);
							}
						}
					}
					if (ticks%10==0) {
						player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
						for (ProtectedRegion r : WorldGuardPlugin.inst().getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
							if (r.getId().startsWith("instance-")) {
								Instance instance = InstanceManager.getInstance().getInstanceById(Integer.parseInt(r.getId().substring("instance-".length())));
								if (instance!=null) {
									player.setScoreboard(instance.getScoreboard());
								}
							}
						}
					}
					
				}
				GunManager.getInstance().update();
				ThrowableManager.getInstance().update();
				for (World world : worlds) {
					List<Entity> re = new ArrayList<Entity>();
					for (Entity e : world.getEntities()) {
						if (e.hasMetadata("gun")) {
							Gun gun = GunManager.getInstance().getGun(e.getMetadata("gun").get(0).asString());
							if (gun != null) {
								if (e.getTicksLived() >= gun.getData().getAmmo().getLifetime()) {
									re.add(e);
								}
							}
						}
					}
					for (Entity e : re) {
						e.remove();
					}
				}
				ticks++;
			}
		}, 1l, 1l);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("admin")) {
			GuiMenuManager.getInstance().ADMIN.open((Player) sender);
			return true;
		}
		return false;
	}

}
