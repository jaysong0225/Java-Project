
public class ChainmailChest extends Armor {

	// Class variable
	double strongProtectPoint;
	
	// Class method
	public ChainmailChest(double strongProtectPoint) {
		this.strongProtectPoint = strongProtectPoint;
		wearChainmailChest();
	}
	
	private void wearChainmailChest() {
		this.setDefenseStrength(strongProtectPoint);
	}
}