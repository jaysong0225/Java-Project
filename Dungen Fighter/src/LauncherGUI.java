import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;

public class LauncherGUI extends JFrame {

	// variable for GameControl creation	
	private GameControl gameControl;
	
	private String myCharacter = "Ranger";
	private String enemyCharacter = "Ranger";
	
	private String myWeapon = "Sword";
	private String myArmor = "ClothesChest";
	private String enemyWeapon = "Sword";
	private String enemyArmor = "ClothesChest";
			
	// Panels
	private JPanel contentPane;	
	private JPanel panelSplash;
	private JPanel panelCharacter;
	private JPanel panelGears;
	private JPanel panelGameReady;
	private JPanel panelBattleField;

	// Game Sets
	private String[] characterNames = {"Ranger","Cerlic","Rogue"};	
	private String[] weaponNames ={"Sword","WarAxe","SpikedHammer"};
	private String[] armorNames = {"ClothesChest","LeatherChest","ChainmallChest"};

	
	// Images
	private Icon splashImage = new ImageIcon(getClass().getResource("/Image/Main.png"));

	private Icon[] characterImage = {
			new ImageIcon(getClass().getResource("/Image/" + characterNames[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + characterNames[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + characterNames[2] + ".png"))
	};
		
	private Icon[] weaponImage = {
			new ImageIcon(getClass().getResource("/Image/" + weaponNames[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + weaponNames[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + weaponNames[2] + ".png"))
	};
	
	private Icon[] armorImage = {
			new ImageIcon(getClass().getResource("/Image/" + armorNames[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + armorNames[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + armorNames[2] + ".png"))			
	};

	private String[] thumbnailCharacter = {"thumbnailRanger","thumbnailCerlic","thumbnailRogue"};	
	private String[] thumbnailWeapon ={"thumbnailSword","thumbnailWarAxe","thumbnailSpikedHammer"};
	private String[] thumbnailArmor = {"thumbnailClothesChest","thumbnailLeatherChest","thumbnailChainmallChest"};
	
	private Icon[] thumbnailCharacterImg = {
			new ImageIcon(getClass().getResource("/Image/" + thumbnailCharacter[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailCharacter[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailCharacter[2] + ".png"))
	};
		
	private Icon[] thumbnailWeaponImg = {
			new ImageIcon(getClass().getResource("/Image/" + thumbnailWeapon[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailWeapon[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailWeapon[2] + ".png"))
	};
	
	private Icon[] thumbnailArmorImg = {
			new ImageIcon(getClass().getResource("/Image/" + thumbnailArmor[0] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailArmor[1] + ".png")),
			new ImageIcon(getClass().getResource("/Image/" + thumbnailArmor[2] + ".png"))			
	};	

	JTextArea textAreaLiveBattle = new JTextArea();
	JButton btnPlayAgain;
	JButton btnTerminate;
	JProgressBar progressBarBattleStatus;
	private Timer timer = new Timer(2000, new TimerHandler());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LauncherGUI frame = new LauncherGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LauncherGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		/************************************************
		/* 				Splash Panel
		*************************************************/
		panelSplash = new JPanel();
		panelSplash.setBackground(UIManager.getColor("Panel.background"));
		contentPane.add(panelSplash, "name_11329710433751");
		panelSplash.setLayout(null);
		
		JLabel lblDungeonFighter = new JLabel("Dungeon Fighter");
		lblDungeonFighter.setFont(new Font("DejaVu Serif", Font.BOLD, 25));
		lblDungeonFighter.setBounds(187, 32, 250, 33);
		panelSplash.add(lblDungeonFighter);
		
		JLabel lblSplashImage = new JLabel("");
		lblSplashImage.setBounds(79, 103, 459, 251);
		panelSplash.add(lblSplashImage);
		lblSplashImage.setIcon(splashImage);
		
		JButton btnEnterGame = new JButton("Enter the Game");
		btnEnterGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// hide and show
				panelSplash.setVisible(false);
				panelCharacter.setVisible(true);	
			}
		});
		btnEnterGame.setBounds(229, 389, 173, 25);
		panelSplash.add(btnEnterGame);
		

		/************************************************
		/* 				Character Panel
		*************************************************/		
		panelCharacter = new JPanel();
		panelCharacter.setForeground(UIManager.getColor("Button.light"));
		contentPane.add(panelCharacter, "name_1222189664446");
		panelCharacter.setLayout(null);
		
		JLabel lblChooseCharacter = new JLabel("Choose Your Character");
		lblChooseCharacter.setFont(new Font("DejaVu Serif", Font.BOLD, 25));
		lblChooseCharacter.setBounds(152, 53, 368, 33);
		panelCharacter.add(lblChooseCharacter);
		
		JLabel lblCharacters = new JLabel("<Characters> ");
		lblCharacters.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCharacters.setForeground(Color.BLACK);
		lblCharacters.setBackground(SystemColor.menuText);
		lblCharacters.setBounds(102, 126, 132, 23);
		panelCharacter.add(lblCharacters);
		
		JLabel lblCharacterImage = new JLabel("");
		lblCharacterImage.setBounds(330, 107, 215, 152);
		panelCharacter.add(lblCharacterImage);
		
		JLabel lblCharacterDescription = new JLabel("Describe");
		lblCharacterDescription.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCharacterDescription.setBounds(61, 285, 510, 80);
		panelCharacter.add(lblCharacterDescription);

		
		JRadioButton rdbtnRanger = new JRadioButton("Ranger");
		rdbtnRanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCharacterImage.setIcon(characterImage[0]);
				lblCharacterDescription.setText("<html>Questing knights, conquering overlords, royal champions, elite foot soldiers, "
						+ "hardened mercenaries, and bandit kings—as fighters, Ranger share an unparalleled mastery with weapons and armor, "
						+ "and a thorough knowledge of the skills of combat..</html>");
				setMyCharacter(characterNames[0]);
			}
		});
		rdbtnRanger.setBounds(112, 168, 149, 23);
		panelCharacter.add(rdbtnRanger);
		
		JRadioButton rdbtnCerlic = new JRadioButton("Cerlic");
		rdbtnCerlic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCharacterImage.setIcon(characterImage[1]);
				lblCharacterDescription.setText("<html>Clerics are intermediaries between the mortal world and the distant "
						+ "planes of the gods. As varied as the gods they serve, they strive to embody the handiwork of "
						+ "their deities.</html>");
				setMyCharacter(characterNames[1]);
			}
		});
		rdbtnCerlic.setBounds(112, 195, 149, 23);
		panelCharacter.add(rdbtnCerlic);
		
		JRadioButton rdbtnRogue = new JRadioButton("Rogue");
		rdbtnRogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCharacterImage.setIcon(characterImage[2]);
				lblCharacterDescription.setText("<html>Rogue is the pinnacle of trained combat. "
						+ "He specializes in striking fast and hard without being seen, heard, or hit, "
						+ "running at great speeds. If he does get hit, he is able to take massive attacks "
						+ "with little to no effect. He is extremely tough regardless and is the paragon of greek combat.</html>");				
				setMyCharacter(characterNames[2]);
			}
		});
		rdbtnRogue.setBounds(112, 222, 149, 23);
		panelCharacter.add(rdbtnRogue);

		ButtonGroup bgCharacter = new ButtonGroup();
		bgCharacter.add(rdbtnRanger);
		bgCharacter.add(rdbtnCerlic);
		bgCharacter.add(rdbtnRogue);
		rdbtnRanger.setSelected(true);
		lblCharacterImage.setIcon(characterImage[0]);
		lblCharacterDescription.setText("<html>Questing knights, conquering overlords, royal champions, elite foot soldiers, "
				+ "hardened mercenaries, and bandit kings—as fighters, Ranger share an unparalleled mastery with weapons and armor, "
				+ "and a thorough knowledge of the skills of combat..</html>");	
		
		JButton btnCharacterSelect = new JButton("Select >>");
		btnCharacterSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// hide and show
				panelCharacter.setVisible(false);	
				panelGears.setVisible(true);	
			}
		});
		btnCharacterSelect.setBackground(UIManager.getColor("Button.select"));
		btnCharacterSelect.setBounds(262, 405, 117, 25);
		panelCharacter.add(btnCharacterSelect);
		
		
		/************************************************
		/* 				Gears Panel
		*************************************************/
		panelGears = new JPanel();
		contentPane.add(panelGears, "name_8576433552987");
		panelGears.setLayout(null);
		
		JLabel lblChooseGears = new JLabel("Choose Gears");
		lblChooseGears.setFont(new Font("DejaVu Serif", Font.BOLD, 25));
		lblChooseGears.setBounds(229, 27, 250, 33);
		panelGears.add(lblChooseGears);
		
		JLabel lblWeaponImage = new JLabel("");
		lblWeaponImage.setBounds(265, 95, 171, 115);
		panelGears.add(lblWeaponImage);
		
		JLabel lblWeaponDescription = new JLabel("Describe");
		lblWeaponDescription.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblWeaponDescription.setBounds(448, 105, 149, 80);
		panelGears.add(lblWeaponDescription);
		
		JLabel labelWeapon = new JLabel("Choose a Weapon");
		labelWeapon.setForeground(Color.BLACK);
		labelWeapon.setBackground(Color.BLACK);
		labelWeapon.setBounds(89, 95, 149, 15);
		panelGears.add(labelWeapon);
		
		JRadioButton rdbtnSword = new JRadioButton("Sword");
		rdbtnSword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeaponImage.setIcon(weaponImage[0]);
				lblWeaponDescription.setText("<html>Two-handed melee weapon in the heavy blade weapon group</html>");				
				setMyWeapon(weaponNames[0]);
			}
		});
		rdbtnSword.setBounds(89, 119, 149, 23);
		panelGears.add(rdbtnSword);
		
		JRadioButton rdbtnAxe = new JRadioButton("War Axe");
		rdbtnAxe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeaponImage.setIcon(weaponImage[1]);
				lblWeaponDescription.setText("<html>War Axes are a One-handed weapons and offering a balance between swords and maces, "
						+ "swinging faster than the latter but more damaging than the former.</html>");			
				setMyWeapon(weaponNames[1]);
			}
		});
		rdbtnAxe.setBounds(89, 146, 149, 23);
		panelGears.add(rdbtnAxe);
		
		JRadioButton rdbtnHammer = new JRadioButton("Spiked Hammer");
		rdbtnHammer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeaponImage.setIcon(weaponImage[2]);
				lblWeaponDescription.setText("<html>A spiked chain has reach, so a character wielding it can make attacks other than "
						+ "opportunity attacks on enemies either 1 or 2 squares away.</html>");			
				setMyWeapon(weaponNames[2]);
			}
		});
		rdbtnHammer.setBounds(89, 173, 149, 23);
		panelGears.add(rdbtnHammer);

		ButtonGroup bgWeapon = new ButtonGroup();
		bgWeapon.add(rdbtnSword);
		bgWeapon.add(rdbtnAxe);
		bgWeapon.add(rdbtnHammer);
		rdbtnSword.setSelected(true);
		lblWeaponImage.setIcon(weaponImage[0]);
		lblWeaponDescription.setText("<html>Two-handed melee weapon in the heavy blade weapon group</html>");
		
		JLabel lblArmorImage = new JLabel("");
		lblArmorImage.setBounds(265, 255, 171, 115);
		panelGears.add(lblArmorImage);
		
		JLabel lblArmorDescription = new JLabel("Describe");
		lblArmorDescription.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblArmorDescription.setBounds(448, 265, 149, 80);
		panelGears.add(lblArmorDescription);
		
		JLabel labelArmor = new JLabel("Choose an Armor");
		labelArmor.setForeground(Color.BLACK);
		labelArmor.setBackground(Color.BLACK);
		labelArmor.setBounds(89, 255, 149, 15);
		panelGears.add(labelArmor);
		
		JRadioButton rdbtnClothesChest = new JRadioButton("Clothes Chest");
		rdbtnClothesChest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArmorImage.setIcon(armorImage[0]);
				lblArmorDescription.setText("<html>Clothes Chest Armor is light protection wear prevent from "
						+ "various types of damage.</html>");				
				setMyArmor(armorNames[0]);
			}
		});
		rdbtnClothesChest.setBounds(89, 278, 149, 23);
		panelGears.add(rdbtnClothesChest);
		
		JRadioButton rdbtnLeatherChest = new JRadioButton("Leather Chest");
		rdbtnLeatherChest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArmorImage.setIcon(armorImage[1]);
				lblArmorDescription.setText("<html>Leather Chest Armor is middle weight but highly durable "
						+ "protection wear</html>");			
				setMyArmor(armorNames[1]);
			}
		});
		rdbtnLeatherChest.setBounds(89, 305, 149, 23);
		panelGears.add(rdbtnLeatherChest);
		
		JRadioButton rdbtnChainmallChest = new JRadioButton("Chainmall Chest");
		rdbtnChainmallChest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblArmorImage.setIcon(armorImage[2]);
				lblArmorDescription.setText("<html>Chainmall Chest Armor is heavy weight but extremely durable "
						+ "protection wear </html>");			
				setMyArmor(armorNames[2]);
			}
		});
		rdbtnChainmallChest.setBounds(89, 332, 149, 23);
		panelGears.add(rdbtnChainmallChest);

		ButtonGroup bgArmor = new ButtonGroup();
		bgArmor.add(rdbtnClothesChest);
		bgArmor.add(rdbtnLeatherChest);
		bgArmor.add(rdbtnChainmallChest);
		rdbtnClothesChest.setSelected(true);
		lblArmorImage.setIcon(armorImage[0]);
		lblArmorDescription.setText("<html>Clothes Chest Armor is light protection wear prevent from "
						+ "various types of damage.</html>");	

		// Image Labels of Game Ready Panel: Requires to be updated images here
		JLabel lblMyCharacterImage = new JLabel("");
		JLabel lblMyWeaponImage = new JLabel("");
		JLabel lblMyArmorImage = new JLabel("");
		JLabel lblEnemyCharacterImage = new JLabel("");
		JLabel lblEnemyWeaponImage = new JLabel("");
		JLabel lblEnemyArmorImage = new JLabel("");
		
		JButton btnGearSelect = new JButton("Select >>");
		btnGearSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// hide and show
				panelGears.setVisible(false);	
				panelGameReady.setVisible(true);
				
				// Generate Random Enemy Setting
				Random random = new Random();
				setEnemyCharacter(characterNames[random.nextInt(2)]);
				setEnemyWeapon(weaponNames[random.nextInt(2)]);
				setEnemyArmor(armorNames[random.nextInt(2)]);		

				// Update "Game Ready" Panel Image
				lblMyCharacterImage.setIcon(characterImage[Arrays.asList(characterNames).indexOf(myCharacter)]);
				lblMyWeaponImage.setIcon(thumbnailWeaponImg[Arrays.asList(weaponNames).indexOf(myWeapon)]);
				lblMyArmorImage.setIcon(thumbnailArmorImg[Arrays.asList(armorNames).indexOf(myArmor)]);
				lblEnemyCharacterImage.setIcon(characterImage[Arrays.asList(characterNames).indexOf(enemyCharacter)]);
				lblEnemyWeaponImage.setIcon(thumbnailWeaponImg[Arrays.asList(weaponNames).indexOf(enemyWeapon)]);
				lblEnemyArmorImage.setIcon(thumbnailArmorImg[Arrays.asList(armorNames).indexOf(enemyArmor)]);	
				

			}
		});
		btnGearSelect.setBounds(405, 408, 117, 25);
		panelGears.add(btnGearSelect);
		
		JButton btnBackToCharacter = new JButton("<< Previous");
		btnBackToCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// hide and show
				panelCharacter.setVisible(true);	
				panelGears.setVisible(false);	
			}
		});
		btnBackToCharacter.setBounds(121, 408, 117, 25);
		panelGears.add(btnBackToCharacter);
		
		
		/************************************************
		/* 				Game Ready Panel
		*************************************************/
		panelGameReady = new JPanel();
		contentPane.add(panelGameReady, "name_15874542514728");
		panelGameReady.setLayout(null);		

		
		JLabel lblGameReady = new JLabel("Game Ready!");
		lblGameReady.setFont(new Font("DejaVu Serif", Font.BOLD, 25));
		lblGameReady.setBounds(240, 23, 250, 33);
		panelGameReady.add(lblGameReady);
		
		//lblMyCharacterImage = new JLabel("");
		lblMyCharacterImage.setBounds(61, 96, 209, 204);
		panelGameReady.add(lblMyCharacterImage);
		
		//lblMyWeaponImage = new JLabel("");
		lblMyWeaponImage.setBounds(61, 313, 93, 57);
		panelGameReady.add(lblMyWeaponImage);
		
		//lblMyArmorImage = new JLabel("");
		lblMyArmorImage.setBounds(177, 313, 93, 57);
		panelGameReady.add(lblMyArmorImage);
		
		//lblEnemyCharacterImage = new JLabel("");
		lblEnemyCharacterImage.setBounds(354, 96, 209, 204);
		panelGameReady.add(lblEnemyCharacterImage);
		lblEnemyCharacterImage.setIcon(characterImage[0]);		
		
		//lblEnemyWeaponImage = new JLabel("");
		lblEnemyWeaponImage.setBounds(354, 313, 93, 57);
		panelGameReady.add(lblEnemyWeaponImage);
		
		//lblEnemyArmorImage = new JLabel("");
		lblEnemyArmorImage.setBounds(470, 313, 93, 57);
		panelGameReady.add(lblEnemyArmorImage);		
		
		JLabel lblVs = new JLabel("VS.");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setBounds(282, 191, 45, 15);
		panelGameReady.add(lblVs);
		
		//Image Labels of Battle Field Panel: Requires to be updated images here
		JLabel lblMyCharThumbnail = new JLabel("");
		JLabel lblEnemyCharThumbnail = new JLabel("");
		
		JButton btnGameStart = new JButton("Game Start");
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create game characters, set gears
				gameControl = new GameControl(myCharacter, enemyCharacter);
				gameControl.setMyGears(myWeapon, myArmor);
				gameControl.setEnemyGears(enemyWeapon, enemyArmor);

				// Update "Battle Field" Panel Image
				lblMyCharThumbnail.setIcon(thumbnailCharacterImg[Arrays.asList(characterNames).indexOf(myCharacter)]);
				lblEnemyCharThumbnail.setIcon(thumbnailCharacterImg[Arrays.asList(characterNames).indexOf(enemyCharacter)]);
				
				// hide and show	
				panelGameReady.setVisible(false);
				panelBattleField.setVisible(true);
				
				// Start Game Timer
				timer.start();
							
			}
		});
		btnGameStart.setBounds(250, 405, 117, 25);
		panelGameReady.add(btnGameStart);
		
		
		/************************************************
		/* 				Battle Field
		*************************************************/		
		panelBattleField = new JPanel();
		contentPane.add(panelBattleField, "name_397802109652");
		panelBattleField.setLayout(null);
		
		JLabel lblBattleField = new JLabel("Battle Field");
		lblBattleField.setBounds(240, 23, 250, 33);
		panelBattleField.add(lblBattleField);
		lblBattleField.setFont(new Font("DejaVu Serif", Font.BOLD, 25));
		
		lblMyCharThumbnail.setBounds(130, 68, 118, 103);
		panelBattleField.add(lblMyCharThumbnail);
		
		JLabel lblVsBattle = new JLabel("VS.");
		lblVsBattle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVsBattle.setBounds(286, 112, 45, 15);
		panelBattleField.add(lblVsBattle);
		
		lblEnemyCharThumbnail.setBounds(373, 68, 118, 103);
		panelBattleField.add(lblEnemyCharThumbnail);
		
		textAreaLiveBattle.setBounds(69, 195, 485, 215);
		panelBattleField.add(textAreaLiveBattle);
		
		JScrollPane scrollPane = new JScrollPane(textAreaLiveBattle);
		scrollPane.setBounds(69, 195, 485, 215);
		panelBattleField.add(scrollPane);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// hide and show
				panelCharacter.setVisible(true);
				panelBattleField.setVisible(false);
				
				// Initialize game sets
				myCharacter = characterNames[0];
				enemyCharacter = characterNames[0];
				
				myWeapon = weaponNames[0];
				myArmor = armorNames[0];
				enemyWeapon = weaponNames[0];
				enemyArmor = armorNames[0];				
						
				// Initialize panel sets
				rdbtnRanger.setSelected(true);
				lblCharacterImage.setIcon(characterImage[0]);
				lblCharacterDescription.setText("<html>Description of Ranger</html>");	
				
				rdbtnSword.setSelected(true);
				lblWeaponImage.setIcon(weaponImage[0]);
				lblWeaponDescription.setText("<html>Description of Sword</html>");	
				
				rdbtnClothesChest.setSelected(true);
				lblArmorImage.setIcon(armorImage[0]);
				lblArmorDescription.setText("<html>Description of Cloth Chest</html>");	
							
				// Reset panelBattleFiel
				btnPlayAgain.setVisible(false);
				btnTerminate.setVisible(false);
				textAreaLiveBattle.setText(null);
				progressBarBattleStatus.setValue(50);
			}
		});
		btnPlayAgain.setBounds(69, 433, 117, 25);
		panelBattleField.add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
		
		btnTerminate = new JButton("Exit");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTerminate.setBounds(437, 433, 117, 25);
		panelBattleField.add(btnTerminate);
		
		progressBarBattleStatus = new JProgressBar();
		progressBarBattleStatus.setForeground(Color.BLUE);
		progressBarBattleStatus.setBackground(Color.RED);
		progressBarBattleStatus.setBounds(69, 175, 485, 15);
		panelBattleField.add(progressBarBattleStatus);
		btnTerminate.setVisible(false);
		progressBarBattleStatus.setValue(50);
				
	}
	
	private void setMyCharacter(String character) {
		this.myCharacter = character;
	}
	
	private void setMyWeapon(String weapon) {
		this.myWeapon = weapon;		
	}
	
	private void setMyArmor(String armor) {
		this.myArmor = armor;
	}
	
	private void setEnemyCharacter(String character) {
		this.enemyCharacter = character;
	}
	
	private void setEnemyWeapon(String weapon) {
		this.enemyWeapon = weapon;		
	}
	
	private void setEnemyArmor(String armor) {
		this.enemyArmor = armor;
	} 
	
	private class TimerHandler implements ActionListener{
		int[] battleDescription = new int[4];
		boolean isMyAttack = true;
		int progressiveValue;
		Random random = new Random();		
		@Override
		public void actionPerformed(ActionEvent arg0) {

			isMyAttack = random.nextBoolean();
			// battleDescription: [attackPoint, defensePoint, myHealthPoint, enemyHealthPoint]
			battleDescription = gameControl.describeRealTimeFighting(isMyAttack);
			
			if(isMyAttack) {
				textAreaLiveBattle.append("My attackPoint is: " + battleDescription[0] + "\n");
				textAreaLiveBattle.append("Enemy defensePoint is: " + battleDescription[1] + "\n");
				isMyAttack = false;
			}
			else {
				textAreaLiveBattle.append("Enemy attackPoint is: " + battleDescription[0] + "\n");
				textAreaLiveBattle.append("My defensePoint is: " + battleDescription[1] + "\n");
				isMyAttack = true;
			}
			
			if(battleDescription[2] > 0 && battleDescription[3] > 0) {
				textAreaLiveBattle.append("My Health Point: " + battleDescription[2] + 
												" / Enemy Health Point: " + battleDescription[3] + "\n\n");
				progressiveValue = (int)(battleDescription[2] * 100 / (battleDescription[2] + battleDescription[3]));
				System.out.println(progressiveValue);
				progressBarBattleStatus.setValue(progressiveValue);
				
			}
			else {
				if(battleDescription[2] <= 0) {
					textAreaLiveBattle.append("\n<<GAME OVER>> You LOST!!!");
					progressBarBattleStatus.setValue(0);
				}
				else {
					textAreaLiveBattle.append("\n<<GAME OVER>> YOU WON!!!");
					progressBarBattleStatus.setValue(100);
				}
				// STOP Game Timer
				timer.stop();
				
				// Enable buttons
				btnPlayAgain.setVisible(true);
				btnTerminate.setVisible(true);
				
			}

		}
	}	
}
