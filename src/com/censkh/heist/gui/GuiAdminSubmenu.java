package com.censkh.heist.gui;

public abstract class GuiAdminSubmenu extends GuiMenu {
	
	public GuiAdminSubmenu(String name) {
		super(name);
	}

	@Override
	public GuiMenu getBackMenu() {
		return GuiMenuManager.getInstance().ADMIN;
	}
	
}
