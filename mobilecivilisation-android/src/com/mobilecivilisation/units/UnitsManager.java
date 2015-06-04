package com.mobilecivilisation.units;
import java.util.ArrayList;

public class UnitsManager {

	private class Unit {

		private String type = "";
		private int cost = 1;
		private int defense = 1;
		private int attack = 1;
		private int productivityCost = 1; /* koszt w tarczach */
		private int movementPoints = 1;
		private int maxHealth = 1;

		public String getType() {
			return type;
		}

		public int getCost() {
			return cost;
		}

		public int getDefense() {
			return defense;
		}

		public int getAttack() {
			return attack;
		}

		public int getProductivityCost() {
			return productivityCost;
		}

		public int getMovementPoints() {
			return movementPoints;
		}

		public int getMaxHealth() {
			return maxHealth;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public void setDefense(int defense) {
			this.defense = defense;
		}

		public void setAttack(int attack) {
			this.attack = attack;
		}

		public void setProductivityCost(int productivityCost) {
			this.productivityCost = productivityCost;
		}

		public void setMovementPoints(int movementPoints) {
			this.movementPoints = movementPoints;
		}

		public void setMaxHealth(int maxHealth) {
			this.maxHealth = maxHealth;
		}
	}

	private ArrayList<Unit> unitsTypeTab;

	private static UnitsManager instance = null;

	protected UnitsManager() {
		Unit u = new Unit();
		u.setAttack(1);
		u.setCost(1);
		u.setDefense(1);
		u.setMaxHealth(1);
		u.setMovementPoints(1);
		u.setProductivityCost(1);
		u.setType("Cave Man");
		unitsTypeTab.add(u);
	}

	public static UnitsManager getInstance() {
		if (instance == null) {
			instance = new UnitsManager();
		}
		return instance;
	}

	public String getType(int id){
		return unitsTypeTab.get(id).getType();
	}

	public int getCost(int id){
		return unitsTypeTab.get(id).getCost();
	}

	public int getDefense(int id){
		return unitsTypeTab.get(id).getDefense();
	}

	public int getAttack(int id){
		return unitsTypeTab.get(id).getAttack();
	}

	public int getProductivityCost(int id){
		return unitsTypeTab.get(id).getProductivityCost();
	}

	public int getMovementPoints(int id){
		return unitsTypeTab.get(id).getMovementPoints();
	}

	public int getMaxHealth(int id){
		return unitsTypeTab.get(id).getMaxHealth();
	}
}
