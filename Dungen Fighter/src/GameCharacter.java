
public abstract class GameCharacter {
	// Class variable
	private int healthyLevel = 100; 
	private int attackPoint;
	private int defensePoint;
	private Weapon myWeapon;
	private Armor myArmor;
	
	// Class method
	public GameCharacter() {
		
	}
	abstract double attack(String weapon);
	abstract double defense(String armor);
	
	public Weapon getWeapon() {
		return this.myWeapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.myWeapon = weapon;
	}
	
	public Armor getArmor() {
		return this.myArmor;
	}
	
	public void setArmor(Armor armor) {
		this.myArmor = armor;
	}
	
	public int getHealthPoint() {
		return this.healthyLevel;
	}
	
	public void setHealthPoint(int healthLevel) {
		this.healthyLevel = healthLevel;
	}
	
}
