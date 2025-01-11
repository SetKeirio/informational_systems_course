package informational_systems.course.items;

import jakarta.persistence.*;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Связи с таблицей Hero (10 героев)
    @ManyToOne
    @JoinColumn(name = "hero1")
    private Hero hero1;

    @ManyToOne
    @JoinColumn(name = "hero2")
    private Hero hero2;

    @ManyToOne
    @JoinColumn(name = "hero3")
    private Hero hero3;

    @ManyToOne
    @JoinColumn(name = "hero4")
    private Hero hero4;

    @ManyToOne
    @JoinColumn(name = "hero5")
    private Hero hero5;

    @ManyToOne
    @JoinColumn(name = "hero6")
    private Hero hero6;

    @ManyToOne
    @JoinColumn(name = "hero7")
    private Hero hero7;

    @ManyToOne
    @JoinColumn(name = "hero8")
    private Hero hero8;

    @ManyToOne
    @JoinColumn(name = "hero9")
    private Hero hero9;

    @ManyToOne
    @JoinColumn(name = "hero10")
    private Hero hero10;

    // Связи с таблицей Player (10 игроков)
    @ManyToOne
    @JoinColumn(name = "player1")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "player3")
    private Player player3;

    @ManyToOne
    @JoinColumn(name = "player4")
    private Player player4;

    @ManyToOne
    @JoinColumn(name = "player5")
    private Player player5;

    @ManyToOne
    @JoinColumn(name = "player6")
    private Player player6;

    @ManyToOne
    @JoinColumn(name = "player7")
    private Player player7;

    @ManyToOne
    @JoinColumn(name = "player8")
    private Player player8;

    @ManyToOne
    @JoinColumn(name = "player9")
    private Player player9;

    @ManyToOne
    @JoinColumn(name = "player10")
    private Player player10;

    // Связи с таблицей Inventory (10 инвентарей)
    @ManyToOne
    @JoinColumn(name = "inventory1")
    private Inventory inventory1;

    @ManyToOne
    @JoinColumn(name = "inventory2")
    private Inventory inventory2;

    @ManyToOne
    @JoinColumn(name = "inventory3")
    private Inventory inventory3;

    @ManyToOne
    @JoinColumn(name = "inventory4")
    private Inventory inventory4;

    @ManyToOne
    @JoinColumn(name = "inventory5")
    private Inventory inventory5;

    @ManyToOne
    @JoinColumn(name = "inventory6")
    private Inventory inventory6;

    @ManyToOne
    @JoinColumn(name = "inventory7")
    private Inventory inventory7;

    @ManyToOne
    @JoinColumn(name = "inventory8")
    private Inventory inventory8;

    @ManyToOne
    @JoinColumn(name = "inventory9")
    private Inventory inventory9;

    @ManyToOne
    @JoinColumn(name = "inventory10")
    private Inventory inventory10;

    // Связи с таблицей Stats (10 статистик)
    @ManyToOne
    @JoinColumn(name = "stats1")
    private Stats stats1;

    @ManyToOne
    @JoinColumn(name = "stats2")
    private Stats stats2;

    @ManyToOne
    @JoinColumn(name = "stats3")
    private Stats stats3;

    @ManyToOne
    @JoinColumn(name = "stats4")
    private Stats stats4;

    @ManyToOne
    @JoinColumn(name = "stats5")
    private Stats stats5;

    @ManyToOne
    @JoinColumn(name = "stats6")
    private Stats stats6;

    @ManyToOne
    @JoinColumn(name = "stats7")
    private Stats stats7;

    @ManyToOne
    @JoinColumn(name = "stats8")
    private Stats stats8;

    @ManyToOne
    @JoinColumn(name = "stats9")
    private Stats stats9;

    @ManyToOne
    @JoinColumn(name = "stats10")
    private Stats stats10;

    // Дополнительные поля
    @ManyToOne
    @JoinColumn(name = "id_match")
    private Game game;

    @Column(name = "win")
    private Integer win; // 0 или 1

    @Column(name = "patch")
    private String patch;

    @Column(name = "region")
    private String region;

    @Column(name = "mode")
    private String mode;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hero getHero1() {
        return hero1;
    }

    public void setHero1(Hero hero1) {
        this.hero1 = hero1;
    }

    public Hero getHero2() {
        return hero2;
    }

    public void setHero2(Hero hero2) {
        this.hero2 = hero2;
    }

    public Hero getHero3() {
        return hero3;
    }

    public void setHero3(Hero hero3) {
        this.hero3 = hero3;
    }

    public Hero getHero4() {
        return hero4;
    }

    public void setHero4(Hero hero4) {
        this.hero4 = hero4;
    }

    public Hero getHero5() {
        return hero5;
    }

    public void setHero5(Hero hero5) {
        this.hero5 = hero5;
    }

    public Hero getHero6() {
        return hero6;
    }

    public void setHero6(Hero hero6) {
        this.hero6 = hero6;
    }

    public Hero getHero7() {
        return hero7;
    }

    public void setHero7(Hero hero7) {
        this.hero7 = hero7;
    }

    public Hero getHero9() {
        return hero9;
    }

    public void setHero9(Hero hero9) {
        this.hero9 = hero9;
    }

    public Hero getHero8() {
        return hero8;
    }

    public void setHero8(Hero hero8) {
        this.hero8 = hero8;
    }

    public Hero getHero10() {
        return hero10;
    }

    public void setHero10(Hero hero10) {
        this.hero10 = hero10;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Player getPlayer4() {
        return player4;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public Player getPlayer5() {
        return player5;
    }

    public void setPlayer5(Player player5) {
        this.player5 = player5;
    }

    public Player getPlayer6() {
        return player6;
    }

    public void setPlayer6(Player player6) {
        this.player6 = player6;
    }

    public Player getPlayer7() {
        return player7;
    }

    public void setPlayer7(Player player7) {
        this.player7 = player7;
    }

    public Player getPlayer8() {
        return player8;
    }

    public void setPlayer8(Player player8) {
        this.player8 = player8;
    }

    public Player getPlayer9() {
        return player9;
    }

    public void setPlayer9(Player player9) {
        this.player9 = player9;
    }

    public Player getPlayer10() {
        return player10;
    }

    public void setPlayer10(Player player10) {
        this.player10 = player10;
    }

    public Inventory getInventory1() {
        return inventory1;
    }

    public void setInventory1(Inventory inventory1) {
        this.inventory1 = inventory1;
    }

    public Inventory getInventory2() {
        return inventory2;
    }

    public void setInventory2(Inventory inventory2) {
        this.inventory2 = inventory2;
    }

    public Inventory getInventory3() {
        return inventory3;
    }

    public void setInventory3(Inventory inventory3) {
        this.inventory3 = inventory3;
    }

    public Inventory getInventory4() {
        return inventory4;
    }

    public void setInventory4(Inventory inventory4) {
        this.inventory4 = inventory4;
    }

    public Inventory getInventory5() {
        return inventory5;
    }

    public void setInventory5(Inventory inventory5) {
        this.inventory5 = inventory5;
    }

    public Inventory getInventory6() {
        return inventory6;
    }

    public void setInventory6(Inventory inventory6) {
        this.inventory6 = inventory6;
    }

    public Inventory getInventory7() {
        return inventory7;
    }

    public void setInventory7(Inventory inventory7) {
        this.inventory7 = inventory7;
    }

    public Inventory getInventory8() {
        return inventory8;
    }

    public void setInventory8(Inventory inventory8) {
        this.inventory8 = inventory8;
    }

    public Inventory getInventory9() {
        return inventory9;
    }

    public void setInventory9(Inventory inventory9) {
        this.inventory9 = inventory9;
    }

    public Inventory getInventory10() {
        return inventory10;
    }

    public void setInventory10(Inventory inventory10) {
        this.inventory10 = inventory10;
    }

    public Stats getStats2() {
        return stats2;
    }

    public void setStats2(Stats stats2) {
        this.stats2 = stats2;
    }

    public Stats getStats1() {
        return stats1;
    }

    public void setStats1(Stats stats1) {
        this.stats1 = stats1;
    }

    public Stats getStats3() {
        return stats3;
    }

    public void setStats3(Stats stats3) {
        this.stats3 = stats3;
    }

    public Stats getStats4() {
        return stats4;
    }

    public void setStats4(Stats stats4) {
        this.stats4 = stats4;
    }

    public Stats getStats5() {
        return stats5;
    }

    public void setStats5(Stats stats5) {
        this.stats5 = stats5;
    }

    public Stats getStats6() {
        return stats6;
    }

    public void setStats6(Stats stats6) {
        this.stats6 = stats6;
    }

    public Stats getStats7() {
        return stats7;
    }

    public void setStats7(Stats stats7) {
        this.stats7 = stats7;
    }

    public Stats getStats8() {
        return stats8;
    }

    public void setStats8(Stats stats8) {
        this.stats8 = stats8;
    }

    public Stats getStats9() {
        return stats9;
    }

    public void setStats9(Stats stats9) {
        this.stats9 = stats9;
    }

    public Stats getStats10() {
        return stats10;
    }

    public void setStats10(Stats stats10) {
        this.stats10 = stats10;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
