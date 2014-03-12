package com.censkh.heist.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.censkh.heist.gun.Gun;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.ItemUseEvent;
import com.censkh.heist.item.ItemUseType;
import com.censkh.heist.item.UniqueItem;

public class EntityEventListener extends EventListener {

	@EventHandler
	public void onEntityDamageByEntityEvent(final EntityDamageByEntityEvent event) {
		Entity damagerEntity = event.getDamager();
		if (damagerEntity.hasMetadata("gun")) {
			UniqueItem item = ItemManager.getInstance().getItem(ItemType.GUN,damagerEntity.getMetadata("gun").get(0).asInt());
			if (item != null) {
				Gun gun = (Gun) item;
				//event.getEntity().getWorld().playEffect(event.getEntity().getLocation().add(0, 1, 0), Effect.STEP_SOUND, Material.REDSTONE_BLOCK.getId());
				double damage = gun.getData().getDamage();
				if (damagerEntity.getMetadata("zoomed").get(0).asBoolean()) {
					damage *= gun.getData().getZoomModifier();
				}
				event.setDamage(damage);
				damagerEntity.remove();
				if (event.getEntity() instanceof LivingEntity) {
					((LivingEntity) event.getEntity()).setNoDamageTicks(0);
				}
			}
		}
		if (damagerEntity instanceof Player) {
			Player damager = (Player) damagerEntity;
			if (damager.getItemInHand()!=null) {
				UniqueItem item = ItemManager.getInstance().getItem(damager.getItemInHand());
				if (item!=null) {
					ItemUseEvent iue = new ItemUseEvent(item, ItemUseType.WEAPON, damager, damager.getItemInHand()){{setDamageEvent(event);}};
					Bukkit.getPluginManager().callEvent(iue);
				}
			}
		
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
	}

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
		if (event.getSpawnReason() == SpawnReason.EGG) {
			event.setCancelled(true);
		}
	}

}
