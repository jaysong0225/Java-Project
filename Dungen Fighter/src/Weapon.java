
public abstract class Weapon {
	
	// Class variable
	private double attackStrength;
	
	// Class method
	public String identify() {
		return this.getClass().getName();
	}
	
	public double getAttackStrength() {
		return this.attackStrength;
	}
	
	public void setAttackStrength(double attackStrength) {
		this.attackStrength = attackStrength;
	}
}
