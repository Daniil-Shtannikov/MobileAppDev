package Отработка_первое;

class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public Player(char x) {
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(weapon.getDamage());
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}


public class OOPPlay {
    public static void main(String[] args){

    }
}
