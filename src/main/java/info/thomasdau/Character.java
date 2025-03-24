package info.thomasdau;

import java.util.ArrayList;
import java.util.List;


public class Character {
    private String name;
    private int baseStrength;
    private int baseIntelligence;
    private int baseAgility;
    private int strength;
    private int intelligence;
    private int agility;
    private int gold;
    private List<Item> items;
    private List<Skill> skills;
    // Stage 2
    private Manager manager;

    public Character(String name) {
        this.name = name;
        this.baseStrength = 1;
        this.baseIntelligence = 1;
        this.baseAgility = 1;
        this.strength = baseStrength;
        this.intelligence = baseIntelligence;
        this.agility = baseAgility;
        this.gold = 0;
        this.items = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public void transitionToManager() {
        manager = new Manager(name + "'s Team", 0.5);
        manager.addWorker(new Worker("zezima", 1.0));
        manager.addWorker(new Worker("worker2", 1.2));
        System.out.println(name + "is now a manager!");
    }

    public void applyItemBonuses() {
        strength = baseStrength;
        intelligence = baseIntelligence;
        agility = baseAgility;

        for (Item item : items) {
            strength += item.getStrengthBonus();
            intelligence += item.getIntelligenceBonus();
            agility += item.getAgilityBonus();
        }
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getBaseStrength() { return baseStrength; }
    public void setBaseStrength(int baseStrength) { this.baseStrength = baseStrength; }

    public int getBaseIntelligence() { return baseIntelligence; }
    public void setBaseIntelligence(int baseIntelligence) { this.baseIntelligence = baseIntelligence; }

    public int getBaseAgility() { return baseAgility; }
    public void setBaseAgility(int baseAgility) { this.baseAgility = baseAgility; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    public int getAgility() { return agility; }
    public void setAgility(int agility) { this.agility = agility; }

    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }

    public List<Item> getItems() { return items; }
    public void addItem(Item item) { this.items.add(item); }

    public List<Skill> getSkills() { return skills; }
    public void addSkill(Skill skill) { this.skills.add(skill); }

    public Manager getManager() { return manager; }

}
