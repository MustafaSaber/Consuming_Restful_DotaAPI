/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2;

import java.io.IOException;
import java.util.Scanner;
import org.json.JSONException;

/**
 *
 * @author mostafa3789
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Services s = new Services();
    public static App a = new App();
    
    public static void main(String[] args) throws JSONException {
        
        
        a.setVisible(true);
        /* try
        {
            Services s = new Services();
            Scanner in = new Scanner(System.in);
            String dotaWebServi = "https://api.opendota.com/api/teams";
            System.out.println("------------Welcome to DOTA 2 Game------------");
            System.out.println("It's a program using api of DOTA to know information about DOTA matches");
            int choice;
            while(true)
            {
                System.out.println("1- See all DOTA teams.\n"
                +   "2- See a specific DOTA team.\n"
                +   "3- See a Specific DOTA team matches.\n"
                +   "4 - See a Specific DOTA team players.\n"
                +   "5 - See a Specific DOTA team heros.\n"
                +   "6 - Close.\n");
                System.out.println("Choose one of the previous options.");
                choice = in.nextInt();
                if(choice == 1)
                {
                    s.DotaAllTeams(dotaWebServi);
                }
                else if(choice == 2)
                {
                    Scanner enter = new Scanner(System.in);
                    System.out.println("Please enter the ID of the match: ");
                    int ID = enter.nextInt();
                    s.DotaSpecificTeam(dotaWebServi, ID);
                }
                else if(choice == 3)
                {
                    Scanner enter = new Scanner(System.in);
                    System.out.println("Please enter the ID of the match: ");
                    int ID = enter.nextInt();
                    s.DotaSpecificTeamMatches(dotaWebServi, ID);
                }
                else if(choice == 4)
                {
                    Scanner enter = new Scanner(System.in);
                    System.out.println("Please enter the ID of the match: ");
                    int ID = enter.nextInt();
                    s.DotaSpecificTeamPlayer(dotaWebServi, 1049906);
                }
                else if(choice == 5)
                {
                    Scanner enter = new Scanner(System.in);
                    System.out.println("Please enter the ID of the match: ");
                    int ID = enter.nextInt();
                    s.DotaSpecificTeamHeros(dotaWebServi , ID);
                }
                else if(choice == 6) break;
                else
                    {
                        System.out.println("This is not an option, please choose another one.");
                        continue;
                    }
            }

        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    */
    }
}
