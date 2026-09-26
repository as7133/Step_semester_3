package Encapsulation.assignment_problems;

class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage rejected: amount must be positive.");
        } else {
            health -= amount;
            if (health < 0) {
                health = 0;
            }
            System.out.println("Health = " + health);
        }
    }

    void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Heal rejected: amount must be positive.");
        } else {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
            System.out.println("Health = " + health);
        }
    }

    int getHealth() {
        return health;
    }

    int getMaxHealth() {
        return maxHealth;
    }
}

public class HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
        System.out.println("Final health: " + c.getHealth());
    }
}
