package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

public class GuiMenuManager {

	private static GuiMenuManager instance;
	private final List<GuiMenu> menus = new ArrayList<GuiMenu>();
	
	public final GunMenu GUN = (GunMenu) addMenu(new GunMenu());

	public GuiMenuManager() {
		instance = this;
	}

	private GuiMenu addMenu(GuiMenu menu) {
		getMenus().add(menu);
		return menu;
	}

	public static GuiMenuManager getInstance() {
		return instance;
	}

	public List<GuiMenu> getMenus() {
		return menus;
	}

}
