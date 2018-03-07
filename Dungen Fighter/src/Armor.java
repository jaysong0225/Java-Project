
public abstract class Armor {

	// Class variable
	private double defenseStrength;
	
	// Class method
	public String identify() {
		return this.getClass().getName();
	}
	
	public double getDefenseStrength() {
		return this.defenseStrength;
	}
	
	public void setDefenseStrength(double defenseStrength) {
		this.defenseStrength = defenseStrength;
	}	
}
