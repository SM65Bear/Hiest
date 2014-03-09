package com.censkh.hiest.event;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.censkh.hiest.gun.Gun;
import com.censkh.hiest.gun.GunManager;

public class EntityEventListener extends EventListener {

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
				}
				if (damager instanceof Player) {
					((Player) damager).playSound(event.getEntity().getLocation(), Sound.SUCCESSFUL_HIT, 2f, 1f);
				}
			}
		}
		if (event.getEntity() instanceof Projectile) {
			Projectile p = ()
		}
	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent event) {
		event.blockList().clear();
	}
	
	@EventHandler
	public void onProjectileHitEvent(ProjectileHitEvent event) {
		if (event.getEntity() instanceof WitherSkull) {
			event.getEntity().remove();
			event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4.5f);
		}
		if (event.getEntity().hasMetadata("gun")) {
			event.getEntity().getWorld().playEffect(event.getEntity().getLocation(), Effect.STEP_SOUND,173);
		}
	}

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
		if (event.getSpawnReason() == SpawnReason.EGG) {
			event.setCancelled(true);
		}
	}

}
