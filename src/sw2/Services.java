/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mostafa3789
 */
public class Services {
    
     public void DotaAllTeams(String URL) throws ProtocolException {
        try {
            java.net.URL myDef_url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) myDef_url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("ACCEPT" ,"application/json");

            if(conn.getResponseCode() == 200)
            {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String MyJSONstring , total = "";
                //System.out.println("The Teams: ");

                while((MyJSONstring = buffer.readLine()) != null) total+=MyJSONstring;

                total = total.substring(1, total.length()-2);
                String[] all = total.split(Pattern.quote("},"));
                for(int i = 0 ; i < all.length ; i++)
                {
                    JSONObject jsonFile = new JSONObject(all[i] + "}");
                    
                    
                    Main.a.GetArea().append("Team " + (i+1) + ":\n");
                    double teamID = jsonFile.getDouble("team_id");
                    // the Object data type because it can have null, so its not a number always.
                    Object rating = jsonFile.get("rating");
                    Object wins = jsonFile.get("wins");
                    Object losses = jsonFile.get("losses");
                    Object last_match_time = jsonFile.get("last_match_time");
                    String name = jsonFile.getString("name");
                    String tag =  jsonFile.getString("tag");
                    Main.a.GetArea().append("Team ID: " + teamID + "\n");
                    Main.a.GetArea().append("Rating: " + rating + "\n");
                    Main.a.GetArea().append("Team wins: " + wins + "\n");
                    Main.a.GetArea().append("Team losses: " + losses + "\n");
                    Main.a.GetArea().append("Team last match time: " + last_match_time + "\n");
                    Main.a.GetArea().append("Team name: " + name + "\n");
                    Main.a.GetArea().append("Team tag: " + tag + "\n");
                    Main.a.GetArea().append("\n");
                }
            }
        }
        catch (ProtocolException e) {
        } catch (IOException | JSONException e) {
        }
    }


    public void DotaSpecificTeam(String URL , int ID) throws ProtocolException {
        try {
            URL+= "/" + Integer.toString(ID);
            URL myDef_url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) myDef_url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("ACCEPT" ,"application/json");

            if(conn.getResponseCode() == 200)
            {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String MyJSONstring , total = "";
                //System.out.println("The Team: ");

                while((MyJSONstring = buffer.readLine()) != null) total+=MyJSONstring;

                JSONObject jsonFile = new JSONObject(total);

                double teamID = jsonFile.getDouble("team_id");
                // the Object data type because it can have null, so its not a number always.
                Object rating = jsonFile.get("rating");
                Object wins = jsonFile.get("wins");
                Object losses = jsonFile.get("losses");
                Object last_match_time = jsonFile.get("last_match_time");
                String name = jsonFile.getString("name");
                String tag =  jsonFile.getString("tag");
                Main.a.GetArea().append("Team ID: " + teamID + "\n");
                Main.a.GetArea().append("Team rating: " + rating + "\n");
                Main.a.GetArea().append("Team wins: " + wins + "\n");
                Main.a.GetArea().append("Team losses: " + losses + "\n");
                Main.a.GetArea().append("Team last match duration: " + last_match_time + "\n");
                Main.a.GetArea().append("Team name: " + name + "\n");
                Main.a.GetArea().append("Team tag: " + tag + "\n");
                Main.a.GetArea().append("\n");
            }
        }
        catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void DotaSpecificTeamMatches(String URL , int ID) throws ProtocolException {
        try {
            URL+= "/" + Integer.toString(ID) + "/matches";
            java.net.URL myDef_url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) myDef_url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("ACCEPT" ,"application/json");

            if(conn.getResponseCode() == 200)
            {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String MyJSONstring , total = "";
                //System.out.println("The Matches: ");

                while((MyJSONstring = buffer.readLine()) != null) total+=MyJSONstring;

                total = total.substring(1, total.length()-2);
                String[] all = total.split(Pattern.quote("},"));
                for(int i = 0 ; i < all.length ; i++)
                {
                    JSONObject jsonFile = new JSONObject(all[i] + "}");
                    
                    Main.a.GetArea().append("Match " + (i+1) + " :\n");
                    double match_id = jsonFile.getDouble("match_id");
                    // the Object data type because it can have null, so its not a number always.
                    Object duration = jsonFile.get("duration");
                    Object start_time = jsonFile.get("start_time");
                    Object opposing_team_name = jsonFile.get("opposing_team_name");
                    Object opposing_team_id = jsonFile.get("opposing_team_id");
                    Object leagueid = jsonFile.get("leagueid");
                    String league_name = jsonFile.getString("league_name");
                    Main.a.GetArea().append("League Name: " + league_name + "\n");
                    Main.a.GetArea().append("League ID: " + leagueid + "\n");
                    Main.a.GetArea().append("Match ID: " + match_id + "\n");
                    Main.a.GetArea().append("Match duration: " + duration + "\n");
                    Main.a.GetArea().append("Match starting time: " + start_time + "\n");
                    Main.a.GetArea().append("Opposing team ID: " + opposing_team_id+ "\n");
                    Main.a.GetArea().append("Opposing team name: " + opposing_team_name+ "\n");
                    Main.a.GetArea().append("\n");
                }
            }
        }
        catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void DotaSpecificTeamPlayer(String URL , int ID) throws JSONException, MalformedURLException, IOException
    {
        try {
            URL+= "/" + Integer.toString(ID) + "/players";
            java.net.URL myDef_url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) myDef_url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("ACCEPT" ,"application/json");

            if(conn.getResponseCode() == 200)
            {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String MyJSONstring , total = "";
                //System.out.println("The team playes: ");

                while((MyJSONstring = buffer.readLine()) != null) total+=MyJSONstring;

                total = total.substring(1, total.length()-2);
                String[] all = total.split(Pattern.quote("},"));
                for(int i = 0 ; i < all.length ; i++)
                {
                    Main.a.GetArea().append("Player " + (i+1) + " :\n");
                    JSONObject jsonFile = new JSONObject(all[i] + "}");

                    // the Object data type because it can have null, so its not a number always.
                    Object games_played = jsonFile.get("games_played");
                    Object wins = jsonFile.get("wins");
                    Object is_current_team_member = jsonFile.get("is_current_team_member");
                    Object account_id = jsonFile.get("account_id");
                    Object name =  jsonFile.get("name");
                    Main.a.GetArea().append("Player ID: " + account_id + "\n");
                    Main.a.GetArea().append("Player name: " + name + "\n");
                    Main.a.GetArea().append("Player wins: " + wins + "\n");
                    Main.a.GetArea().append("Player games: " + games_played + "\n");
                    Main.a.GetArea().append("Current team player? : " + is_current_team_member + "\n");
                    Main.a.GetArea().append("\n");
                }
            }
        }
        catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public void DotaSpecificTeamHeros(String URL , int ID)
    {
        try {
            URL+= "/" + Integer.toString(ID) + "/heroes";
            java.net.URL myDef_url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) myDef_url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("ACCEPT" ,"application/json");

            if(conn.getResponseCode() == 200)
            {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String MyJSONstring , total = "";
                //System.out.println("The team heros: ");

                while((MyJSONstring = buffer.readLine()) != null) total+=MyJSONstring;

                total = total.substring(1, total.length()-2);
                String[] all = total.split(Pattern.quote("},"));
                for(int i = 0 ; i < all.length ; i++)
                {
                    Main.a.GetArea().append("Hero " + (i+1) + " :\n");
                    JSONObject jsonFile = new JSONObject(all[i] + "}");

                    // the Object data type because it can have null, so its not a number always.
                    Object games_played = jsonFile.get("games_played");
                    Object wins = jsonFile.get("wins");
                    Object hero_id = jsonFile.get("hero_id");
                    Object localized_name =  jsonFile.get("localized_name");
                    Main.a.GetArea().append("Hero ID: " + hero_id + "\n");
                    Main.a.GetArea().append("Hero name: " + localized_name + "\n");
                    Main.a.GetArea().append("Hero wins: " + wins + "\n");
                    Main.a.GetArea().append("Hero games: " + games_played + "\n");
                    Main.a.GetArea().append("\n");
                }
            }
        }
        catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
}
