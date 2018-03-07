
public class GameControl {
	// member definition
	// 1. My Player
	private GameCharacter myPlayer;
	private Weapon myWeapon;
	private Armor myArmor;
	// 2. Enemy Player
	private GameCharacter enemyPlayer;
	private Weapon enemyWeapon;
	private Armor enemyArmor;
		
	// Constructor
	public GameControl(String myCharacter, String enemyCharacter) {
		
		// Create Game Players (MyPlayer VS. EnemyPlayer)

		// 1. Create my Character
		if(myCharacter == "Ranger") {
			myPlayer = new Ranger(1,1);
		}
		else if(myCharacter == "Cerlic") {
			myPlayer = new Cerlic(1,1);
		}
		else {
			myPlayer = new Rogue(1,1);
		}
		
		// 2. Create enemy Character
		if(enemyCharacter == "Ranger") {
			enemyPlayer = new Ranger(1,1);
		}
		else if(enemyCharacter == "Cerlic") {
			enemyPlayer = new Cerlic(1,1);
		}
		else {
			enemyPlayer = new Rogue(1,1);
		}		
	}
	
	public void setMyGears(String weapon, String armor)
	{
		// 1. Create my Weapon
		if(weapon == "Sword") {
			this.myWeapon = new Sword(2);
		}
		else if(weapon == "WarAxe") {
			this.myWeapon = new WarAxe(2);
		}
		else {
			this.myWeapon = new SpikedHammer(2);
		}

		this.myPlayer.setWeapon(this.myWeapon);
		
		// 1. Create my Armor
		if(armor == "ClothesChest") {
			this.myArmor = new ClothesChest(1.5);
		}
		else if(weapon == "LeatherChest") {
			this.myArmor = new LeatherChest(1.5);
		}
		else {
			this.myArmor = new ChainmailChest(1.5);
		}
		
		this.myPlayer.setArmor(this.myArmor);
	}
	
	public void setEnemyGears(String weapon, String armor)
	{
		// 1. Create my Weapon
		if(weapon == "Sword") {
			this.enemyWeapon = new Sword(2);
		}
		else if(weapon == "WarAxe") {
			this.enemyWeapon = new WarAxe(2);
		}
		else {
			this.enemyWeapon = new SpikedHammer(2);
		}

		this.enemyPlayer.setWeapon(this.enemyWeapon);
		
		// 1. Create my Armor
		if(armor == "ClothesChest") {
			this.enemyArmor = new ClothesChest(1.5);
		}
		else if(weapon == "LeatherChest") {
			this.enemyArmor = new LeatherChest(1.5);
		}
		else {
			this.enemyArmor = new ChainmailChest(1.5);
		}
		
		this.enemyPlayer.setArmor(this.enemyArmor);
	}
	
	public int[] describeRealTimeFighting(boolean isMyAttack) 
	{
		int[] descriptionOfBattle = new int[4];
		int attackPoint;
		int defensePoint;
		int myHealthPoint;
		int enemyHealthPoint;

		myHealthPoint = this.myPlayer.getHealthPoint();
		enemyHealthPoint = this.enemyPlayer.getHealthPoint();
		
		if(isMyAttack) {
			attackPoint = (int)this.myPlayer.attack(this.myWeapon.identify());
			defensePoint = (int)this.enemyPlayer.defense(this.enemyArmor.identify());
			if(attackPoint > defensePoint)
				this.enemyPlayer.setHealthPoint(enemyHealthPoint - (attackPoint - defensePoint));
			descriptionOfBattle[0] = attackPoint;
			descriptionOfBattle[1] = defensePoint;
			
		}
		else {
			attackPoint = (int)this.enemyPlayer.attack(this.enemyWeapon.identify());
			defensePoint = (int)this.myPlayer.attack(this.myArmor.identify());
			if(attackPoint > defensePoint)
				this.myPlayer.setHealthPoint(myHealthPoint - (attackPoint - defensePoint));
			descriptionOfBattle[0] = attackPoint;
			descriptionOfBattle[1] = defensePoint;
		}
		
		descriptionOfBattle[2] = this.myPlayer.getHealthPoint();
		descriptionOfBattle[3] = this.enemyPlayer.getHealthPoint();

		return descriptionOfBattle;
	}
	
}
