/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
/**
 *
 * @author bkwia
 */
public class CharacterCreator{

    int strength;
    int intelligence;
    int dexterity;
    int num = 0;
    
  
    
    
    public static void main(String[] args) {
        ArrayList<Player> Chars = new ArrayList();
        Chars.add(new Character(Races.ORC,Classes.MAGE,10,15,10,"John",45));
        Chars.add(new Character(Races.ELF,Classes.HUNTER,10,12,10,"Ben",320));
        Chars.add(new Character(Races.HUMAN,Classes.HUNTER,10,91,10,"Dave",26));
        Chars.add(new Character(Races.TROLL,Classes.WARRIOR,10,13,10,"Luke",8));
        
        
      
        //System.out.println(szukany.getIntelligence());
        
        Scanner scan = new Scanner(System.in);
        int op = 0;
        while (op != 6) {
            System.out.println("\n*** Kreator postaci ***");
            System.out.println("Menu:");
            System.out.println("1. Stwórz postać"); // pokaz dostepne rasy/ pokaz dostepne klasy/kreator rozdaj 20 pkt doswiadczenia 
            System.out.println("2. Usuń postać");
            System.out.println("3. Modyfikuj statystyki postaci");
            System.out.println("4. Znajdź postać zawierającą dany ciąg znaków");
            System.out.println("5. Zapisz informacje o postaci do pliku .txt");
            System.out.println("6. Wyjdź z programu");
            System.out.print("Wybierz opcję: ");
            
            while (!scan.hasNextInt()) {
                System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                scan.next();
                            }
                                  
           op = scan.nextInt();
            switch (op) {
                case 1:
                    int op_1 = 0;
                    
                    while (op_1 != 5) {
                    System.out.println("\n*** Stwórz postać ***");
                    System.out.println("1. Pokaż dostępne rasy");
                    System.out.println("2. Pokaż dostępne klasy");
                    System.out.println("3. Pokaż wszystkie postaci");
                    System.out.println("4. Przejdź do kreatora");
                    System.out.println("5. Wróć do poprzedniego menu");
                    
                    System.out.print("Wybierz opcję: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                        scan.next();
                            }
                    op_1 = scan.nextInt();
                    
                    
                    switch (op_1) {
                      
                        case 1:
                            System.out.println("\nLista dostępnych ras:");
                            for (Races r : Races.values()) {
                               System.out.println(r);
                                }
                            break;
                        case 2:
                            System.out.println("\nLista dostępnych klas:");
                            for (Classes c : Classes.values()) {
                               System.out.println(c);
                                }
                            break;

                        case 3:
                            System.out.println("\nLista postaci:");
                            for(Player g: Chars){
                        if (g instanceof Character c1)
                            {
                                System.out.println(g);
                                    }
                            }
                            break;
                        case 4:
                            
                            //Kreator postaci
                            scan.nextLine();
                            System.out.println("\n*** Witaj w kreatorze postaci ***");
                            
                            
                            System.out.println("\n->Jak ma na imię twoja postać?");
                            
                            final String[] given_name = new String[1]; //dane analizowane przez wyrazenie lambda musza być final,
                            //mozna wiec nadac liscie given_name typ final, ale zmieniac jej zawartosc, w ten sposob sama lista jest final
                            // mozna tez uzyc AtomicReference -> final AtomicReference<String> given_name = new AtomicReference<>("");
                            //i pozniej zmieniac wartosc za pomoca given_name.set(scanner.nextLine());
                            given_name[0] = scan.nextLine();
                            String character_name ;
                            
                            boolean exists = Chars.stream().filter(c -> c.getName().equalsIgnoreCase(given_name[0])).findFirst().isPresent();
                            while(exists) {
                             System.out.println("\nPostać o tym imieniu już istnieje, podaj nowe imię: ");
                             given_name[0] = scan.nextLine();
                             exists = Chars.stream().filter(c -> c.getName().equalsIgnoreCase(given_name[0])).findFirst().isPresent();
                            }
                            character_name = given_name[0];
                         
                       
                            System.out.println("\n->Jaką rasę wybierasz?");
                            String race = scan.nextLine();
                            race = race.toUpperCase();
                            
                            //Sprawdzamy czy taka rasa istnieje
                            //Jesli nie istnieje, kaze wpisac ponownie, lub wyjsc do menu
                            boolean test_race = true;
                            while (test_race)
                            try {
                            Races.valueOf(Races.class,race);
                            test_race = false;
                            }
                            catch (IllegalArgumentException ex) {
                                System.out.println("Wpisz ponownie jaką rasę wybierasz?");
                                race = scan.nextLine();
                                race = race.toUpperCase();
                                test_race = true;
                                
                            }
                                    

                            System.out.println("\n->Jaką klasę wybierasz?");
                            String classType = scan.nextLine();
                            classType = classType.toUpperCase();
                            //Sprawdzamy czy taka rasa istnieje
                            //Jesli nie istnieje, kaze wpisac ponownie, lub wyjsc do menu
                            boolean test_class = true;
                            while (test_class)
                            try {
                            Classes.valueOf(Classes.class,classType);
                            test_class = false;
                            }
                            catch (IllegalArgumentException ex) {
                                System.out.println("\nWpisz ponownie jaką klasę wybierasz?");
                                classType = scan.nextLine();
                                classType = classType.toUpperCase();
                                test_class = true;
                            }
                            
                            
                            
                            System.out.println("\n->Ile lat ma twoja postać?");
                            //sprawdzamy czy wpisany został wiek jako liczba
                                    while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    
                                    }
                                    int given_age = scan.nextInt();
                                    int age = Math.abs(given_age);
                                    
                                    
                                    
                            
                            int total_points = 20;
                            System.out.println("\n->Rozdaj punkty doświadczenia, masz dostępne " + total_points + " punktów");
                            
                            int strength = 0;
                            int intelligence = 0;
                            int dexterity = 0;
                            int num =0;
                            
                            while (total_points > 0) {
                                
                            System.out.println("\nSiła");
                            while (!scan.hasNextInt()) {
                                System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                scan.next();
                            }
                            num = scan.nextInt();
                            total_points = total_points - num;
                            if (total_points <0) {
                                System.out.println("Wydałeś zbyt dużo punktów, poprzednia operacje została cofnięta");
                                total_points = total_points + num;
                                System.out.println("\nRozdaj punkty doświadczenia, masz dostępne " + total_points + " punktów");
                            }
                            else if (total_points == 0) {
                                      strength += num;
                                      System.out.println("\nWydałeś już wszystkie punkty");
                                      break;
                                        }
                            else {
                                strength += num;
                            }
                                
                            System.out.println("Pozostało Ci " + total_points + " punktów");
                            
                            
                            System.out.println("\nInteligencja");
                            while (!scan.hasNextInt()) {
                            System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                            scan.next();
                            }
                            num = scan.nextInt();
                            total_points = total_points - num;
                            if (total_points <0) {
                                System.out.println("Wydałeś zbyt dużo punktów, poprzednia operacje została cofnięta");
                                total_points = total_points + num;
                                System.out.println("\nRozdaj punkty doświadczenia, masz dostępne " + total_points + " punktów");
                            }
                            else if (total_points == 0) {
                                      intelligence += num;
                                      System.out.println("\nWydałeś już wszystkie punkty");
                                      break;
                                        }
                            else {
                                intelligence += num;
                            }
                            System.out.println("Pozostało Ci " + total_points + " punktów");
                            
                            System.out.println("\nZwinność");
                            while (!scan.hasNextInt()) {
                                System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                scan.next();
                            }
                            num = scan.nextInt();
                            total_points = total_points - num;
                            
                            if (total_points <0) {
                                System.out.println("Wydałeś zbyt dużo punktów, poprzednia operacje została cofnięta");
                                total_points = total_points + num;
                                System.out.println("\nRozdaj punkty doświadczenia, masz dostępne " + total_points + " punktów");
                            }
                            else if (total_points == 0) {
                                      dexterity += num;
                                      System.out.println("\nWydałeś już wszystkie punkty");
                                      break;
                                        }
                            else {
                                dexterity += num;
                            }
                            System.out.println("Pozostało Ci " + total_points + " punktów");
                            }
                            
                            
                            //Weryfikacja poprawnosci danych
                            System.out.println("Gratulacje! Twoja postać to " + race + " " + classType + " o imieniu " + character_name + " który ma " + age + " lat, a jego statystki startowe to:" + "\nSiła: " + strength + "\nInteligencja: " + intelligence + "\nZwinność: " + dexterity );
                            System.out.println("\nJeśli Te informacje się zgadzają napisz 'tak', jeśli chcesz zacząć od nowa napisz 'nie'");
                            scan.nextLine();
                            String odpowiedz = scan.nextLine();
                            
                            //Zapisywanie postaci
                            if(odpowiedz.equalsIgnoreCase("tak")){
                                Chars.add(new Character(Races.valueOf(race),Classes.valueOf(classType),strength,intelligence,dexterity,character_name,age));
                                System.out.println("Postać została zapisana");
                                Chars.stream().filter(l-> l.name.equalsIgnoreCase(character_name)).map(l->(Character) l).findFirst().orElse(null).WelcomeNewPlayer();
                                //new_character.WelcomeNewPlayer();
                            }
                            else if(odpowiedz.equalsIgnoreCase("nie")){
                            System.out.println("Postać nie została zapisana, wracam do menu tworzenia postaci");
                            }
                            else{
                            System.out.println("wpisałeś niepoprawną instrukcję, wracam do menu tworzenia postaci");
                            }
                            break;
                        case 5:
                            
                            break;
                            
                        default:
                            System.out.println("Nie ma takiej opcji");

                    }
                    
                    }
                    break;
                case 2:
                                        int op_2 = 0;
                    
                    while (op_2 != 3) {
                    System.out.println("\n*** Usuwanie postaci ***");
                    System.out.println("1. Pokaż wszystkie postaci");
                    System.out.println("2. Usuń wybraną postać");
                    System.out.println("3. Wróć do poprzedniego menu");
                    System.out.print("Wybierz opcję: ");
                   while (!scan.hasNextInt()) {
                         System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                         scan.next();
                            }

                    op_2 = scan.nextInt();
 
                    switch (op_2) { 
                    
                        case 1: 
                            System.out.println("\nPokaż wszystkie postaci");
                             for(Player g: Chars){
                                if (g instanceof Character c1)
                                     {
                                    System.out.println(g);
                                    }
                                     }
                            
                            break;
                        case 2:     
                            System.out.println("\nPodaj ID postaci, którą chcesz usunąć:");
                            while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    int character_index = scan.nextInt();
                                    Character found = Chars.stream().filter(l-> l.index == (character_index)).map(l->(Character) l).findFirst().orElse(null);
                                    int index_to_delete = Chars.indexOf(found);
                                    try {
                                        Chars.remove(index_to_delete);
                                        } 
                                    catch (IndexOutOfBoundsException e) {
                                         System.out.println("\nPostać o tym ID nie istnieje");
                                        }
                                    break;
                        case 3:
                                break;
                        default: 
                            System.out.println("Nie ma takiej opcji");
                             break;
                    
                    }
                   
                    }
                break;
                case 3:
                   
                    int op_3 = 0;
                    while (op_3 != 4) {
                    System.out.println("\n*** Edytuj statystyki postaci ***");
                    System.out.println("1. Pokaż wszystkie postaci");
                    System.out.println("2. Zmień statystyki wybraje postaci");
                    System.out.println("3. Pokaż sumę statystyk wybranej postaci");
                    System.out.println("4. Wróć do poprzedniego menu");
                    System.out.print("Wybierz opcję: ");
                    
                    while (!scan.hasNextInt()) {
                         System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                         scan.next();
                            }

                    op_3 = scan.nextInt();
              
                    
                    
                    switch (op_3) {
                        case 1:
                            System.out.println("\nLista postaci:");
                            for(Player g: Chars){
                            if (g instanceof Character c1)
                            {
                                System.out.println(g);
                                    }
                            }
                            break;
                            
                        case 2:
                            System.out.println("\nPodaj ID postaci, której statystyki chcesz zmienić: ");
                            while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    final AtomicReference<Integer> character_index = new AtomicReference<>(0);
                                    character_index.set(scan.nextInt());
                                    boolean not_exists  = Chars.stream().anyMatch(x-> x.index == character_index.get());
                                    while (!not_exists) {
                                    System.out.println("\nPostać o tym ID nie istnieje");
                                    System.out.println("->Podaj inne ID: ");
                                    while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    character_index.set(scan.nextInt());
                                    not_exists  = Chars.stream().anyMatch(x-> x.index == character_index.get());
                                    }
                                    
                                    Character found_character = Chars.stream().filter(l-> l.index == (character_index.get())).map(l->(Character) l).findFirst().orElse(null);
                                    System.out.println("\nWpisz ile punktów chcesz dodać do poszczególnych statystyk: ");
                                    System.out.println("\nSiła: ");
                                    while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    int str_to_add = scan.nextInt();
                                    System.out.println("\nInteligencja: ");
                                    while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    int int_to_add = scan.nextInt();
                                    System.out.println("\nZwinność: ");
                                    while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }        
                                    int dex_to_add = scan.nextInt();
                                    
                                    found_character.addStats(str_to_add,int_to_add,dex_to_add);
                                    
                                    System.out.println("\nStatystyki zostały uaktualnione");
                                break;
                        case 3:
                            System.out.println("\nPodaj ID postaci, której sumę statystyk chcesz wyświetlić: ");
                            while (!scan.hasNextInt()) {
                                       System.out.println("Nie wpisałeś liczby, spróbuj ponownie"); 
                                       scan.next();
                                    }
                                    final AtomicReference<Integer> character_index_2 = new AtomicReference<>(0);
                                    character_index_2.set(scan.nextInt());
                                    boolean not_exists_2  = Chars.stream().anyMatch(x-> x.index == character_index_2.get());
                                    while (!not_exists_2) {
                                    System.out.println("\nPostać o tym ID nie istnieje");
                                    System.out.println("->Podaj inne ID: ");
                                    character_index_2.set(scan.nextInt());
                                    not_exists_2  = Chars.stream().anyMatch(x-> x.index == character_index_2.get());
                                    }
                                    Character found_character_2 = Chars.stream().filter(l-> l.index == (character_index_2.get())).map(l->(Character) l).findFirst().orElse(null);
                                    
                                    System.out.println("\nSuma statystyk tej postaci to: " + found_character_2.totalStats());
                                   
                                        
                                   
                        case 4:
                            break;
                        default:
                            System.out.println("Niepoprawna opcja");
                            break;
                    } 
                      }    
                    break;
                    case 4:
                        System.out.println("\nWpisz ciąg znaków: ");
                        scan.nextLine();
                        String to_find = scan.nextLine().toLowerCase();
                        List<java.lang.Character> charList = to_find.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
                        ArrayList<String> chars_that_contain = new ArrayList<>();
                        
                        
                        for (Player p : Chars) {                                
                           String name = p.getName().toLowerCase();
                           List<java.lang.Character> nameCharList = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList()); 
                           
                           if (nameCharList.containsAll(charList)){
                               chars_that_contain.add(p.getName());
                           }
                        }

                        if (!chars_that_contain.isEmpty()){
                            System.out.println("\nZnaleziono następujące postaci, które zaweierają wprowadzony ciąg znaków: ");
                            for (String c: chars_that_contain){
                                System.out.println(c);
                            }
                            }
                        else {
                            System.out.println("Nie znaleziono postaci zawierającej wprowadzony ciąg znaków");
                        }
                        
                    break;
                    case 5:
                        scan.nextLine();
                        System.out.println("\nPodaj imię postaci, której dane chcesz zapisać: ");
                        String nameToSave = scan.nextLine();
                         boolean exists  = Chars.stream().anyMatch(x-> x.name.equalsIgnoreCase(nameToSave));
                         if (exists){
                             Character found_character = Chars.stream().filter(l-> l.name.equalsIgnoreCase(nameToSave)).map(l->(Character) l).findFirst().orElse(null);
                             found_character.saveToFile();

                         }
                         else {
                             System.out.println("Postać o tym imieniu nie istnieje");
                         }
                        
                    break;
                    case 6:
                    break;
                    default:
                    System.out.println("Niepoprawna opcja");
        
                    
        
                            }   

                        }
                    }
      

             }
   



    
