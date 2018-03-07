import java.util.Random;

public class Cerlic extends GameCharacter {

	// Class variable
	private double strongPowerPoint;
	private double thickSkinPoint;

	// Class method
	public Cerlic(int strongPowerPoint, int thickSkinPoint) {
		super();
		this.strongPowerPoint = strongPowerPoint;
		this.thickSkinPoint = thickSkinPoint;
	}
	
	@Override
	double attack(String strWeapon) {
		// TODO Auto-generated method stub		
		double attackPoint = 0;
		
		Random random = new Random();
		Weapon weapon = this.getWeapon();		
		
		// Attack with Ranger's specialties
		//1.1 Get weight factors
		if (strWeapon == "Sword") {
			strongPowerPoint = 1.6;
		}
		else if (strWeapon == "WarAxe") {
			strongPowerPoint = 2.0;
		}
		else {
			strongPowerPoint = 1.8;
		}
		//1.2 Calculate Attack Point
		// Formula: random number(0~10) * game character's ability point * weapon point
		attackPoint = random.nextInt(10) * strongPowerPoint * weapon.getAttackStrength();
		return attackPoint;
	}

	@Override
	double defense(String strArmor) {
		// TODO Auto-generated method stub
		double defensePoint = 0;
		
		Random random = new Random();
		Armor armor = this.getArmor();		
				
		// Defense with Ranger's specialties
		//1.1 Get weight factors
		if (strArmor == "ClothesChest") {
			thickSkinPoint = 1.5;
		}
		else if (strArmor == "LeatherChest") {
			thickSkinPoint = 1.3;
		}
		else {
			thickSkinPoint = 1.2;
		}
		//1.2 Calculate Defense Point
		// Formula: random number(0~10) * game character's ability point * armor point		
		defensePoint = random.nextInt(10) * thickSkinPoint * armor.getDefenseStrength();
		return defensePoint;
	}

}
