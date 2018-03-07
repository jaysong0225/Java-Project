
public class ClothesChest extends Armor {

	// Class variable
	double lightWeightPoint;
	
	// Class method
	public ClothesChest(double lightWeightPoint) {
		this.lightWeightPoint = lightWeightPoint;
		wearClotheChest();
	}
	
	private void wearClotheChest() {
		this.setDefenseStrength(lightWeightPoint);
	}
}
