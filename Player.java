/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bkwia
 */
public class Player extends Account{
    long index;
    static long player_id = 0;
    String name;
    int age;

    public Player(String name, int age) {
        index = player_id++;
        this.name = name;
        this.age = age;
    }



    public void WelcomeNewPlayer(){
        System.out.println("Witaj " + name + ", czeka cię niesamowita przygoda!");

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

    
    
    public static long getPlayer_id() {
        return player_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
   


    
    
    
}
