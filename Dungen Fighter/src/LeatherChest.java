
public class LeatherChest extends Armor {

	// Class variable
	double highlyDurablePoint;
	
	// Class method
	public LeatherChest(double highlyDurablePoint) {
		this.highlyDurablePoint = highlyDurablePoint;
	}
	
	public void wearLeatherChest() {
		this.setDefenseStrength(highlyDurablePoint);
	}
}
