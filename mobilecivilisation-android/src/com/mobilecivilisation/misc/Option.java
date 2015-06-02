package com.mobilecivilisation.misc;

public class Option {
	private final int iconId;
	private final int titleId;
	private Runnable action;
	public Option(int iconId, int titleId) {
		super();
		this.iconId = iconId;
		this.titleId = titleId;
	}
	
	public Option(int iconId, int titleId, Runnable action) {
		this(iconId, titleId);
		this.action = action;
	}
	public int getTitleId() {
		return titleId;
	}
	public int getIconId() {
		return iconId;
	}
	
	public void onClick() {
		action.run();
	}
	
}
