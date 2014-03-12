package com.censkh.heist.npcs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomNpc implements Listener {
	
	int maxValue = Integer.MAX_VALUE;
	
	public void onEnable() {
		
	}
	
	public void SpawnDrugDealer(Player player){
		
		Zombie z = (Zombie) player.getLocation().getWorld().spawn(player.getLocation(), Zombie.class);
		
		z.setCustomName(ChatColor.DARK_AQUA + "Blackmarket Gun Dealer");
		z.setCustomNameVisible(true);
		z.getEquipment().setItemInHand(new ItemStack(Material.DIAMOND_SPADE));
		z.getEquipment().setHelmet(new ItemStack(Material.SKULL_ITEM));
		z.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		// TRIED THIS JAMES BUT IT DIDN'T WORK, IDK WHY.... z.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4));
		z.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		z.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
		z.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, maxValue, 6));
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a){
		if(cmd.getName().equalsIgnoreCase("npc")){
			Player p = (Player) sender;
			SpawnDrugDealer(p);
		}
		return false;
		
	}

}
