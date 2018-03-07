
public class WarAxe extends Weapon {

	// Class variable
	double chopPoint;
	
	// Class method
	public WarAxe(double chopPoint) {
		this.chopPoint = chopPoint;
		handleWarAxe();
	}
	
	private void handleWarAxe() {
		this.setAttackStrength(chopPoint);
	}
	
}
