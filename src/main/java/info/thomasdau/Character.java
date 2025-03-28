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
    private int stage;
    // Stage 1
    private Job job;
    // Stage 2
    private Manager manager;
    // Stage 3
    private Owner owner;

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
        this.stage = 1;
    }

    public void startJob() {
        this.addItem(new Item("Basic Pickaxe", "A simple pickaxe", 1, 0, 0, 10));
        this.applyItemBonuses();
        job = new Job("Miner", 0.1);
        this.addJob(job);
    }

    public void transitionToManager() {
        manager = new Manager(name + "'s Team", 0.5);
        Character zezima = new Character("zezima");
        zezima.setIntelligence(2);
        manager.hireWorker(zezima);
        manager.hireWorker(new Character("worker2"));
        stage = 2;
        System.out.println(name + "is now a manager!");
    }

    public void transitionToOwner() {
        owner = new Owner(name + "'s Empire", 0.3);
        System.out.println(owner.getName() + " is now an owner!");
        stage = 3;

        Company company1 = new Company("Company A", 1.0);
        Manager genericManager = new Manager("generic joe", 1.1);
        Manager genericManagerSenior = new Manager("generic older joe", 1.2);
        Character genericWorker = new Character("Bo");
        genericManagerSenior.hireLeader(genericManager);
        genericManager.hireWorker(genericWorker);

        owner.addCompany(company1);
        company1.hireManager(genericManagerSenior);

        Company company2 = new Company("Company B", 1.0);
        company2.hireManager(genericManager);

        owner.addCompany(company2);
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

    public void updateProgress() {
        if (stage == 1) {
            job.updateProgress(this);
        }
        if (stage == 2) {
            manager.updateProgress(this);
        }
        if (stage == 3 ){
            owner.updateProgress(this);
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

    public int getStage() { return stage; }

    public Job getJob() { return this.job; }
    public void addJob(Job job) { this.job = job; }

    public Manager getManager() { return manager; }

    public Owner getOwner() { return owner; }

}
