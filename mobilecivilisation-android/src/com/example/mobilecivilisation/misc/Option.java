package com.example.mobilecivilisation.misc;

public class Option {
	private final int iconId;
	private final int titleId;
	public Option(int iconId, int titleId) {
		super();
		this.iconId = iconId;
		this.titleId = titleId;
	}
	public int getTitleId() {
		return titleId;
	}
	public int getIconId() {
		return iconId;
	}
	
}
