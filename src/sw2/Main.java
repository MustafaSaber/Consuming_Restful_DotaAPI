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
        
        //Set the GUI visible --> Go to service class --> then app class
        a.setVisible(true);
    }
}
