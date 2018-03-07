
public class Sword extends Weapon {

	// Class variable
	double sharpPoint;
	
	// Class method
	public Sword(double sharpPoint) {
		this.sharpPoint = sharpPoint;
		handleSword();
	}
	
	private void handleSword() {
		this.setAttackStrength(sharpPoint);
	}
}
