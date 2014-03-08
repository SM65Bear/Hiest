package com.censkh.hiest;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Hiest extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		new ThrowableManager();
		new GunManager();
		getServer().getPluginManager().registerEvents(this, this);
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
										player.playSound(player.getLocation(), Sound.CLICK, 2f, 0.3f);
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
				}
				GunManager.getInstance().update();
				ThrowableManager.getInstance().update();
				for (World world : worlds) {
					List<Entity> re = new ArrayList<Entity>();
					for (Entity e : world.getEntities()) {
						if (e.hasMetadata("gun")) {
							Gun gun = GunManager.getInstance().getGun(e.getMetadata("gun").get(0).asString());
							if (gun != null) {
								if (e.getTicksLived() >= gun.getAmmo().getLifetime()) {
									re.add(e);
								}
							}
						}
					}
					for (Entity e : re) {
						e.remove();
					}
				}
			}
		}, 1l, 1l);
		for (Player player : Bukkit.getOnlinePlayers()) {
			for (Gun gun : GunManager.getInstance().getGuns())
				player.getInventory().addItem(gun.getStack());
			for (Throwable throwable : ThrowableManager.getInstance().getThrowables())
				player.getInventory().addItem(throwable.getStack(20));
		}
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onProjectileHitEvent(ProjectileHitEvent event) {
		if (event.getEntity() instanceof WitherSkull) {
			event.getEntity().remove();
			event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4.5f);
		}
	}

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
		if (event.getSpawnReason() == SpawnReason.EGG) {
			event.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		Entity damager = event.getDamager();
		if (damager.hasMetadata("gun")) {
			Gun gun = GunManager.getInstance().getGun(damager.getMetadata("gun").get(0).asString());
			if (gun != null) {
				event.getEntity().getWorld().playEffect(event.getEntity().getLocation().add(0, 1, 0), Effect.STEP_SOUND, Material.REDSTONE_BLOCK.getId());
				double damage = gun.getData().getDamage();
				if (damager.getMetadata("zoomed").get(0).asBoolean()) {
					damage *= gun.getData().getZoomModifier();
				}
				event.setDamage(damage);
				damager.remove();
				if (event.getEntity() instanceof LivingEntity) {
					((LivingEntity) event.getEntity()).setNoDamageTicks(0);
					if (event.getEntity() instanceof Player) {
						((Player) event.getEntity()).playSound(event.getEntity().getLocation(), Sound.SUCCESSFUL_HIT, 2f, 1f);
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Gun gun = GunManager.getInstance().getGun(event.getItemDrop().getItemStack());
		if (gun != null) {
			GunStack stack = new GunStack(event.getItemDrop().getItemStack());
			if (!stack.isFull()) {
				event.getPlayer().setItemInHand(stack.reload().write());
				event.getPlayer().sendMessage(ChatColor.GRAY + "Reloading...");
				event.getItemDrop().remove();
			} else {
			}
		}
	}

	@EventHandler
	public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
		if (event.getNewSlot() != event.getPreviousSlot()) {
			GunManager.getInstance().setZoomed(event.getPlayer(), false);
		}
	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {
		event.blockList().clear();
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		if (event.getItem() != null) {
			Gun gun = GunManager.getInstance().getGun(event.getItem());
			if (gun != null) {
				event.setCancelled(true);
				event.setUseInteractedBlock(Result.DENY);
				event.setUseItemInHand(Result.DENY);
				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					event.getPlayer().setItemInHand(gun.shoot(event.getPlayer(), event.getItem()));
					event.getPlayer().updateInventory();
				} else {
					GunManager.getInstance().setZoomed(event.getPlayer(), !GunManager.getInstance().isZoomed(event.getPlayer()));
				}
			} else {
				Throwable throwable = ThrowableManager.getInstance().getThrowable(event.getItem());
				if (throwable != null) {
					event.setCancelled(true);
					event.setUseInteractedBlock(Result.DENY);
					event.setUseItemInHand(Result.DENY);
					throwable.shoot(event.getPlayer());
					event.getPlayer().getInventory().removeItem(throwable.getStack());
				}
			}
		}
	}

}
