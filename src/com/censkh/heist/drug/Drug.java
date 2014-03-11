package com.censkh.heist.drug;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.censkh.heist.drug.DrugData;
import com.censkh.heist.item.UniqueItem;

public class Drug extends UniqueItem {
	
	private final ItemStack stack;
	private final DrugData data;
	private final String name;
	public final Random random = new Random();

	public Drug(int id,String name, ItemStack stack, DrugData data) {
		super(id);
		this.name = name;
		this.stack = stack;
		this.data = data;
	}

	@Override
	public ItemStack getStack(int i) {
		DrugStack stack = new DrugStack(this);
		stack.setAmount(i);
		return null;
	}
	
	public void CauseNausa(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3, getData().getCauseNausa()), true);
	}
	
	public void CauseSpeed(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, getData().getCauseSpeed()), true);
		entity.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3, getData().getCauseSpeed()), true);
	}
	
	public void CauseRegen(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2, getData().getCauseRegen()), true);
	}
	
	public void CauseRessist(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, getData().getCauseRessist()), true);
	}
	
	public void CauseJump(LivingEntity entity) {
		entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3, getData().getCauseJump()), true);
	}
	
	
	public DrugData getData() {
		return data;
	}

	public String getName() {
		return name;
	}

}
