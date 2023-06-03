/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
/**
 *
 * @author bkwia
 */
public class Character extends Player implements ICharacter{
    private Races race;
    private Classes classType;
    private int strength;
    private int intelligence;
    private int dexterity;
  
    
    public Character(Races race, Classes classType, int strength, int intelligence, int dexterity, String name, int age) {
        super(name, age);
        this.race = race;
        this.classType = classType;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        
    }

    
    
    
    @Override
        public int totalStats() {     
            int total_stats = intelligence+strength+dexterity;
            return total_stats;
    }
   
    @Override
    public void saveToFile() {
        try {
            String directoryName = "Characters";
            File directory = new File(directoryName);
            directory.mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(directoryName + File.separator + index + "_" + name + ".txt"));
            writer.write(toString());
           writer.close();
            System.out.println("\nPomyślnie zapisano dane postaci do pliku " +index + "_" + name);
            }         
        catch (IOException e) {
            e.printStackTrace();
            }
        }  
 //   public boolean isNameAvailable(String givenName){
   //         if (givenName.equalsIgnoreCase(name)){
     //           retu
      //      } 
       //     else {
        
        //return true;
    //}
   // }
    public void addStats(int x,int y, int z){
        strength += x;
        intelligence += y;
        dexterity += z;
    }
    
    

    public Races getRace() {
        return race;
    }

    public Classes getClassType() {
        return classType;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public long getIndex() {
        return index;
    }

    public static long getPlayer_id() {
        return player_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setRace(Races race) {
        this.race = race;
    }

    public void setClassType(Classes classType) {
        this.classType = classType;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public static void setPlayer_id(long player_id) {
        Player.player_id = player_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

@Override
   public String toString(){
        return "ID Postaci: " + index + "\nImie postaci: " + name + "\nRasa: " + race + "\nKlasa: " + classType + "\nSiła: " + strength + "\nInteligencja: " + intelligence + "\nZwinność: " + dexterity +  "\n";
    }



  


    

   
    
    
    
    
}
