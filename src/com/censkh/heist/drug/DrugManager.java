package com.censkh.heist.drug;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.censkh.heist.drug.Drug;
import com.censkh.heist.drug.DrugManager;

public class DrugManager {
	
	private static DrugManager instance;
	private final List<Drug> drugs = new ArrayList<Drug>();
	public static DrugManager getInstance() {
		
		return instance;
		
	public DrugManager() {
		
		//fucked up here 2 /\
		instance = this;
		
		addDrug(new Drug("Cocane", new ItemStack(Material.SUGAR), new DrugData() {
			setCauseSpeed(1);
			
			//fucked up again
			
			
		}));
		
		addDrug(new Drug("Crack", new ItemStack(Material.SUGAR), new DrugData() {
			setCauseSpeed(1);
			
			//fucked up again
			
			
		}));
		
		addDrug(new Drug("Canabis", new ItemStack(Material.SUGAR), new DrugData() {
			setCauseSpeed(1);
			
			//fucked up again
			
			
		}));
		addDrug(new Drug("Herobrine/Heroin", new ItemStack(Material.SUGAR), new DrugData() {
			setCauseSpeed(1);
			
			//and here too, oh they alll but this one start with a "c" - my name begins with a c..... oh :/ im a drug, deal with it bitch!
			
			
		}));
		
	}	//don't you love fucking up....i don't
	
	//have fun with this btw
	
		
		
		
		
		
		
	}
	public static void setInstance(DrugManager instance) {
		DrugManager.instance = instance;
	}
	public List<Drug> getDrugs() {
		return drugs;
	}

}
