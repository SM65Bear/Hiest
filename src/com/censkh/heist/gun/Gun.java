package com.censkh.heist.gun;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.censkh.heist.Heist;

public class Gun {
	
	private static int iid = 0;
	
	private final int id = iid++;
	private final ItemStack stack;
	private final GunData data;
	private final String name;
	public final Random random = new Random();

	public Gun(String name, ItemStack stack, GunData data) {
		this.name = name;
		this.stack = stack;
		this.data = data;
	}

	public void bake() {

	}

	public ItemStack shoot(Player player, ItemStack stack) {
		GunStack gunStack = new GunStack(stack);
		if (gunStack.canFire(player)) {
			for (int i = 0; i < getData().getBurst(); i++) {
				Projectile projectile = player.launchProjectile(getData().getAmmo().getType());
				projectile.setMetadata("gun", new FixedMetadataValue(Heist.getPlugin(Heist.class), getId()));
				projectile.setMetadata("zoomed", new FixedMetadataValue(Heist.getPlugin(Heist.class), GunManager.getInstance().isZoomed(player)));
				Vector velocity = calculateVelocity(player);
				projectile.setVelocity(velocity);
				getData().getShootSound().play(player.getLocation());
				player.playSound(player.getLocation(), Sound.EXPLODE, 0.3f, 2f);
				gunStack.setLoadedBullets(gunStack.getLoadedBullets() - 1);
			}
			GunManager.getInstance().setGunCooldown(player, this, getData().getRateOfFire());
		} else {
			if (gunStack.getState()==GunState.EMPTY)player.playSound(player.getLocation(), Sound.CLICK, 2f, 2f);
		}
		return gunStack.write(stack);
	}

	public void zoom(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3, getData().getZoom()), true);
	}

	public ItemStack getItemType() {
		return stack.clone();
	}

	public ItemStack getStack() {
		return getStack(1);
	}
	
	public String getIdent() {
		return "Gun #"+id;
	}

	public ItemStack getStack(int i) {
		GunStack stack = new GunStack(this);
		stack.setAmount(i);
		return stack.write();
	}

	public Vector calculateVelocity(Player player) {
		float accuracy = player.isSneaking() ? 0f : getData().getAccuracy() / 3f;
		if (GunManager.getInstance().isZoomed(player)) {
			accuracy /= getData().getZoomModifier();
		}
		if (accuracy <= 0f) {
			accuracy = 0.01f;
		}
		Location ploc = player.getLocation();
		Random rand = new Random();
		double dir = -ploc.getYaw() - 90;
		double pitch = -ploc.getPitch();
		double a = 100000.0;
		double xwep = ((rand.nextInt((int) Math.ceil(accuracy * a)) - rand.nextInt((int) Math.ceil(accuracy * a))) + 0.5) / a;
		double ywep = ((rand.nextInt((int) Math.ceil(accuracy * a)) - rand.nextInt((int) Math.ceil(accuracy * a))) + 0.5) / a;
		double zwep = ((rand.nextInt((int) Math.ceil(accuracy * a)) - rand.nextInt((int) Math.ceil(accuracy * a))) + 0.5) / a;
		double xd = Math.cos(Math.toRadians(dir)) * Math.cos(Math.toRadians(pitch)) + xwep;
		double yd = Math.sin(Math.toRadians(pitch)) + ywep;
		double zd = -Math.sin(Math.toRadians(dir)) * Math.cos(Math.toRadians(pitch)) + zwep;
		Vector vec = new Vector(xd, yd, zd);
		return vec.multiply(getData().getAmmo().getTravelSpeed());
	}

	public GunData getData() {
		return data;
	}

	public String getName() {
		return name;
	}

	public boolean isStack(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		if (meta.hasLore()) {
			if (ChatColor.stripColor(meta.getLore().get(meta.getLore().size() - 1)).equals(getIdent())) {
				return true;
			}
		}
		return false;
	}

	public boolean equals(Gun gun) {
		return gun.getName().equals(getName());
	}

	public int getId() {
		return id;
	}

}
