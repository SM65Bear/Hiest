package com.censkh.heist.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import com.censkh.heist.ammo.Ammo556;
import com.censkh.heist.ammo.Ammo9MM;
import com.censkh.heist.ammo.AmmoM2100;
import com.censkh.heist.ammo.AmmoRocket;
import com.censkh.heist.ammo.AmmoShotgunShells;
import com.censkh.heist.drug.Drug;
import com.censkh.heist.drug.DrugData;
import com.censkh.heist.gun.Gun;
import com.censkh.heist.gun.GunData;
import com.censkh.heist.gun.WeaponType;
import com.censkh.heist.listener.EventListener;
import com.censkh.heist.throwable.FragGrenade;
import com.censkh.heist.util.BuffData;
import com.censkh.heist.util.SoundData;

public class ItemManager extends EventListener {

	private static ItemManager instance;
	private final List<UniqueItem> items = new ArrayList<UniqueItem>();

	{
		instance = this;
	}

	public final Ammo556 AMMO_556 = new Ammo556();
	public final AmmoRocket AMMO_ROCKET = new AmmoRocket();
	public final AmmoM2100 AMMO_M2100 = new AmmoM2100();
	public final AmmoShotgunShells AMMO_SHOTGUN_SHELLS = new AmmoShotgunShells();
	public final Ammo9MM AMMO_9MM = new Ammo9MM();

	public final Drug DRUG_COCANE = new Drug(600, "Cocane", new ItemStack(Material.SUGAR), new DrugData() {
		{
			addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
		}
	});
	public final Drug DRUG_CRACK = new Drug(601, "Crack", new ItemStack(Material.SUGAR), new DrugData() {
		{
			addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
		}
	});
	public final Drug DRUG_CANABIS = new Drug(602, "Canabis", new ItemStack(Material.SUGAR), new DrugData() {
		{
			addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
		}
	});
	public final Drug DRUG_HEROINE = new Drug(603, "Heroine", new ItemStack(Material.SUGAR), new DrugData() {
		{
			addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
		}
	});

	public final Gun GUN_M4 = new Gun(301, "M4", new ItemStack(Material.DIAMOND_SPADE), new GunData() {
		{
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(60);
			setDamage(4d);
			setAccuracy(0.15f);
			setRateOfFire(4);
			setType(WeaponType.ASSAULT);
		}
	});

	public final Gun GUN_ACR = new Gun(302, "ACR", new ItemStack(Material.IRON_SPADE), new GunData() {
		{
			setRarity(ItemRarity.PERFECT);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(60);
			setDamage(3.5d);
			setAccuracy(0.1f);
			setRateOfFire(3);
			setType(WeaponType.ASSAULT);
		}
	});

	public final Gun GUN_AK47 = new Gun(303, "Ak47", new ItemStack(Material.WOOD_SPADE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 2f));
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(3);
			setMagazineSize(28);
			setAccuracy(0.2f);
			setBurst(1);
			setDamage(3d);
			setReloadTime(2 * 20);
			setRateOfFire(2);
			setType(WeaponType.ASSAULT);
		}
	});

	public final Gun GUN_SCAR_H = new Gun(304, "Scar-H", new ItemStack(Material.GOLD_AXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
			setRarity(ItemRarity.ELITE);
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(30);
			setAccuracy(0.15f);
			setBurst(1);
			setDamage(2.5d);
			setReloadTime(3 * 20);
			setRateOfFire(4);
			setZoomModifier(2f);
			setType(WeaponType.ASSAULT);
		}
	});

	// -= ShotGuns =- \\

	public final Gun GUN_M3 = new Gun(310, "M3", new ItemStack(Material.WOOD_PICKAXE), new GunData() {
		{
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_SHOTGUN_SHELLS);
			setRecoil(1f);
			setZoom(0);
			setMagazineSize(20);
			setAccuracy(0.5f);
			setBurst(5);
			setDamage(3d);
			setReloadTime(3 * 18);
			setRateOfFire(8);
			setType(WeaponType.SHOTGUNS);
		}
	});

	public final Gun GUN_M1014 = new Gun(311, "M1014", new ItemStack(Material.SHEARS), new GunData() {
		{
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_SHOTGUN_SHELLS);
			setRecoil(1f);
			setZoom(0);
			setMagazineSize(20);
			setAccuracy(0.5f);
			setBurst(5);
			setDamage(3d);
			setReloadTime(3 * 18);
			setRateOfFire(8);
			setType(WeaponType.SHOTGUNS);
		}
	});

	public final Gun GUN_MODEL_1887 = new Gun(312, "Model 1887", new ItemStack(Material.DIAMOND_AXE), new GunData() {
		{
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_SHOTGUN_SHELLS);
			setRecoil(1f);
			setZoom(0);
			setMagazineSize(20);
			setAccuracy(0.5f);
			setBurst(3);
			setDamage(4d);
			setReloadTime(3 * 18);
			setRateOfFire(15);
			setType(WeaponType.SHOTGUNS);
		}
	});

	public final Gun GUN_AA_12 = new Gun(313, "AA-12", new ItemStack(Material.DIAMOND_PICKAXE), new GunData() {
		{
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_SHOTGUN_SHELLS);
			setRecoil(1f);
			setZoom(0);
			setMagazineSize(10);
			setAccuracy(0.5f);
			setBurst(2);
			setDamage(4d);
			setReloadTime(3 * 18);
			setRateOfFire(1);
			setType(WeaponType.SHOTGUNS);
		}
	});

	// -= Heavy Machineguns =- \\

	public final Gun GUN_RPG = new Gun(320, "RPG", new ItemStack(Material.GOLD_SPADE), new GunData() {
		{
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_ROCKET);
			setRecoil(1f);
			setZoom(3);
			setMagazineSize(2);
			setRateOfFire(40);
			setReloadTime(6 * 20);
			setDamage(25d);
			setAccuracy(0.01f);
			setType(WeaponType.SPECIAL);
		}
	});

	// -= Hand Guns =- \\

	public final Gun GUN_DESERT_EAGLE = new Gun(330, "Desert Eagle", new ItemStack(Material.STONE_HOE), new GunData() {
		{
			setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(16);
			setAccuracy(0.2f);
			setBurst(1);
			setDamage(2.5d);
			setReloadTime(20);
			setRateOfFire(3);
			setType(WeaponType.HANDGUN);
		}
	});

	public final Gun GUN_P250 = new Gun(331, "P250", new ItemStack(Material.IRON_HOE), new GunData() {
		{
			setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(16);
			setAccuracy(0.2f);
			setBurst(1);
			setDamage(2.5d);
			setReloadTime(20);
			setRateOfFire(3);
			setType(WeaponType.HANDGUN);
		}
	});

	public final Gun GUN_M9 = new Gun(332, "M9", new ItemStack(Material.IRON_PICKAXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_556);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(16);
			setAccuracy(0.2f);
			setBurst(1);
			setDamage(2.5d);
			setReloadTime(20);
			setRateOfFire(3);
			setType(WeaponType.HANDGUN);
		}
	});

	public final Gun GUN_GOLDEN_MAGNUM = new Gun(333, "Golden Magnum", new ItemStack(Material.GOLD_HOE), new GunData() {
		{
			setRarity(ItemRarity.ELITE);
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(6);
			setAccuracy(0.12f);
			setDamage(6d);
			setRateOfFire(20);
			setReloadTime(3 * 20);
			setType(WeaponType.HANDGUN);
		}
	});
	// -= Sniper Rifles =- \\

	public final Gun GUN_INTERVENTION = new Gun(340, "Intervention", new ItemStack(Material.WOOD_HOE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
			setRarity(ItemRarity.ELITE);
			setAmmo(AMMO_M2100);
			setRecoil(1f);
			setZoom(7);
			setMagazineSize(6);
			setAccuracy(0.3f);
			setDamage(6d);
			setRateOfFire(25);
			setZoomModifier(4f);
			setReloadTime(2 * 20);
			setType(WeaponType.SNIPER);
		}
	});

	public final Gun GUN_BARRET_50CAL = new Gun(341, "Barret .50cal", new ItemStack(Material.STONE_AXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
			setRarity(ItemRarity.BASIC);
			setAmmo(AMMO_M2100);
			setRecoil(1f);
			setZoom(7);
			setMagazineSize(6);
			setAccuracy(0.35f);
			setDamage(9d);
			setRateOfFire(12);
			setZoomModifier(2f);
			setReloadTime(2 * 20);
			setType(WeaponType.SNIPER);
		}
	});

	public final Gun GUN_M40A3 = new Gun(342, "M40A3", new ItemStack(Material.STONE_PICKAXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
			setRarity(ItemRarity.PERFECT);
			setAmmo(AMMO_M2100);
			setRecoil(1f);
			setZoom(7);
			setMagazineSize(6);
			setAccuracy(0.3f);
			setDamage(4.2d);
			setRateOfFire(20);
			setZoomModifier(4f);
			setReloadTime(2 * 20);
			setType(WeaponType.SNIPER);
		}
	});

	public final Gun GUN_KALASHNIKOV = new Gun(343, "KALASHNIKOV", new ItemStack(Material.IRON_AXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_M2100);
			setRecoil(1f);
			setZoom(7);
			setMagazineSize(6);
			setAccuracy(0.2f);
			setDamage(6d);
			setRateOfFire(15);
			setZoomModifier(4f);
			setReloadTime(2 * 20);
			setType(WeaponType.SNIPER);
		}
	});

	// -= Light Machineguns =- \\

	public final Gun GUN_P250B = new Gun(350, "P250b", new ItemStack(Material.DIAMOND_HOE), new GunData() {
		{
			setRarity(ItemRarity.RARE);
			setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(60);
			setRateOfFire(1);
			setReloadTime(4 * 20);
			setBurst(1);
			setDamage(2.5d);
			setAccuracy(0.1f);
			setType(WeaponType.LIGHT);
		}
	});

	public final Gun GUN_UMP45 = new Gun(351, "Ump45", new ItemStack(Material.GOLD_PICKAXE), new GunData() {
		{
			setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
			setRarity(ItemRarity.RARE);
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(60);
			setRateOfFire(1);
			setReloadTime(4 * 20);
			setBurst(1);
			setDamage(3.2d);
			setAccuracy(0.12f);
			setType(WeaponType.LIGHT);
		}
	});

	public final Gun GUN_MP5 = new Gun(352, "MP5", new ItemStack(Material.WOOD_AXE), new GunData() {
		{
			setRarity(ItemRarity.BASIC);
			setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(2);
			setMagazineSize(60);
			setRateOfFire(1);
			setReloadTime(4 * 20);
			setBurst(1);
			setDamage(2.5d);
			setAccuracy(0.15f);
			setType(WeaponType.LIGHT);
		}
	});

	public final Gun GUN_UZI = new Gun(353, "Uzi", new ItemStack(Material.STONE_SPADE), new GunData() {
		{
			setRarity(ItemRarity.BASIC);
			setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
			setAmmo(AMMO_9MM);
			setRecoil(1f);
			setZoom(3);
			setMagazineSize(120);
			setRateOfFire(2);
			setReloadTime(4 * 20);
			setBurst(2);
			setDamage(2d);
			setAccuracy(0.3f);
			setType(WeaponType.LIGHT);
		}
	});

	public final UniqueItem WHITE_MASK = new MaskItem(100, "White Mask", Color.WHITE);
	public final UniqueItem RED_MASK = new MaskItem(101, "Red Mask", Color.RED);
	public final UniqueItem BLACK_MASK = new MaskItem(102, "Black Mask", Color.BLACK);
	public final UniqueItem ORANGE_MASK = new MaskItem(103, "Orange Mask", Color.ORANGE);
	public final UniqueItem PURPLE_MASK = new MaskItem(104, "Purple Mask", Color.PURPLE);
	public final UniqueItem YELLOW_MASK = new MaskItem(105, "Yellow Mask", Color.YELLOW);

	public final FragGrenade FRAG_GRENADE = new FragGrenade();

	public ItemManager() {

	}
	
	@EventHandler
	public void onItemUseEvent(ItemUseEvent event) {
		event.getItem().onItemUseEvent(event);
	}

	public UniqueItem addItem(UniqueItem item) {
		getItems().add(item);
		return item;
	}

	public static ItemManager getInstance() {
		return instance;
	}

	public UniqueItem getItem(ItemStack stack) {
		for (UniqueItem item : getItems()) {
			if (item.isStack(stack)) {
				return item;
			}
		}
		return null;
	}

	public UniqueItem getItem(String name) {
		for (UniqueItem item : getItems()) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}

	public List<UniqueItem> getItems() {
		return items;
	}

	public UniqueItem getItem(int id) {
		for (UniqueItem item : getItems()) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public List<UniqueItem> getItems(ItemType type) {
		List<UniqueItem> items = new ArrayList<UniqueItem>();
		for (UniqueItem item : getItems()) {
			if (item.getType() == type) {
				items.add(item);
			}
		}
		return items;
	}

	public UniqueItem getItem(ItemType type, int id) {
		for (UniqueItem item : getItems(type)) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public UniqueItem getItem(ItemType type, ItemStack stack) {
		for (UniqueItem item : getItems(type)) {
			if (item.isStack(stack)) {
				return item;
			}
		}
		return null;
	}

}
