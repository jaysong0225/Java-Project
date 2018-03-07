
public class SpikedHammer extends Weapon {
	
	// Class variable
	double smashPoint;
	
	// Class method
	public SpikedHammer(double smashPoint) {
		this.smashPoint = smashPoint;
		handleSpikedHammer();
	}
	
	private void handleSpikedHammer() {
		this.setAttackStrength(smashPoint);
	}
}
