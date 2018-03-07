import java.util.Random;

public class Rogue extends GameCharacter {
	
	// Class variable
	private double intelligentPoint;
	private double charismaPoint;

	// Class method
	public Rogue(int intelligentPoint, int charismaPoint) {
		super();
		this.intelligentPoint = intelligentPoint;
		this.charismaPoint = charismaPoint;
	}
	
	@Override
	double attack(String strWeapon) {
		// TODO Auto-generated method stub
		double attackPoint = 0;
		
		Random random = new Random();
		Armor armor = this.getArmor();
		
		// Attack with Ranger's specialties
		//1.1 Get weight factors
		if (strWeapon == "Sword") {
			intelligentPoint = 1.8;
		}
		else if (strWeapon == "WarAxe") {
			intelligentPoint = 1.6;
		}
		else {
			intelligentPoint = 2.0;
		}
		//1.2 Calculate Attack Point
		// Formula: random number(0~10) * game character's ability point * armor point		
		attackPoint = random.nextInt(10) * intelligentPoint * armor.getDefenseStrength();
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
			charismaPoint = 1.2;
		}
		else if (strArmor == "LeatherChest") {
			charismaPoint = 1.5;
		}
		else {
			charismaPoint = 1.3;
		}
		//1.2 Calculate Defense Point
		// Formula: random number(0~10) * game character's ability point * armor point		
		defensePoint = random.nextInt(10) * charismaPoint * armor.getDefenseStrength();
		return defensePoint;
	}

}
