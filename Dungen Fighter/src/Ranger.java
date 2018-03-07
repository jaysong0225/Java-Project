import java.util.Random;

public class Ranger extends GameCharacter {

	// Class variable
	private double highAccuracyPoint;
	private double fastSpeedPoint;

	// Class method
	public Ranger(int highAccuracyPoint, int fastSpeedPoint) {
		super();
		this.highAccuracyPoint = highAccuracyPoint;
		this.fastSpeedPoint = fastSpeedPoint;
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
			highAccuracyPoint = 2.0;
		}
		else if (strWeapon == "WarAxe") {
			highAccuracyPoint = 1.8;
		}
		else {
			highAccuracyPoint = 1.6;
		}
		//1.2 Calculate Attack Point
		// Formula: random number(0~10) * game character's ability point * weapon point
		attackPoint = random.nextInt(10) * highAccuracyPoint * weapon.getAttackStrength();
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
			fastSpeedPoint = 1.2;
		}
		else if (strArmor == "LeatherChest") {
			fastSpeedPoint = 1.3;
		}
		else {
			fastSpeedPoint = 1.5;
		}
		//1.2 Calculate Defense Point
		// Formula: random number(0~10) * game character's ability point * armor point		
		defensePoint = random.nextInt(10) * fastSpeedPoint * armor.getDefenseStrength();
		return defensePoint;
	}

}
