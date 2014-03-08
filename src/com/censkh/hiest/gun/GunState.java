package com.censkh.hiest;

public enum GunState {
	LOADED,EMPTY,RELOADING;

	public static GunState getState(String string) {
		for (GunState state : values()) {
			if (string.startsWith(state.name())) {
				return state;
			}
		}
		return null;
	}
}
