package info.thomasdau;

public class Item {
    private String name;
    private String description;
    private int strengthBonus;
    private int intelligenceBonus;
    private int agilityBonus;
    private int goldValue;

    public Item(String name, String description, int strengthBonus, int intelligenceBonus, int agilityBonus, int goldValue) {
        this.name = name;
        this.description = description;
        this.strengthBonus = strengthBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.agilityBonus = agilityBonus;
        this.goldValue = goldValue;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getStrengthBonus() { return strengthBonus; }
    public void setStrengthBonus(int strengthBonus) { this.strengthBonus = strengthBonus; }
    
    public int getIntelligenceBonus() { return intelligenceBonus; }
    public void setIntelligenceBonus(int intelligenceBonus) { this.intelligenceBonus = intelligenceBonus; }
    
    public int getAgilityBonus() { return agilityBonus; }
    public void setAgilityBonus(int agilityBonus) { this.agilityBonus = agilityBonus; }
    
    public int getGoldValue() { return goldValue; }
    public void setGoldValue(int goldValue) { this.goldValue = goldValue; }
    
}
