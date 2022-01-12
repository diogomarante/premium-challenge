import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PokemonPremium {

    //calcs the zone Size based on the maximum number of E/O and N/S [max(E/O), max(N/S), staringX, startingY]
    private static ZoneData getZoneData(String input)
    {
        int N = 0, S = 0, E = 0, O = 0;

        for (int i = 0; i< input.length(); i++)
        {
            switch(input.charAt(i)) {
                case 'N':
                    N++;
                    break;
                case 'S':
                    S++;
                    break;
                case 'E':
                    E++;
                    break;
                case 'O':
                    O++;
                    break;
                default:
                    System.out.println("somethin went wrong parsing char: " + input.charAt(i));
                    System.exit(0);
            }
        }
        
        int[] data = new int[4];
        // i dont know if he will move to left or right first so i need to assume worst cases
        data[0] = E + O + 1 ; //x axis size
        data[1] = N + S + 1; // y axis size
        data[2] = O; // x starting point OFFSET
        data[3] = N; // y starting point OFFSET
        ZoneData zoneData = new ZoneData(data[0], data[1], data[2], data[3]);
        return zoneData;
    }

    // runs a string with directions and returns the output
    private static int run(String directions)
    {

        // get zone info
        ZoneData zoneData = getZoneData(directions);
        
        // create the grid
        SafariZone zone = new SafariZone(zoneData);

        // create the player
        Player ash = new Player(zone.getStartingNode());

        // move the player and he will check if the node has pokemon and add it to his count
        for( int i = 0 ; i < directions.length(); i++) 
            ash.move(directions.substring(i,i+1));

        return ash.getPokemonCount();
    }
    public static void main(String args[])
    {   
        if (args.length > 0) //has input file
        {
            Scanner inputs;
            try {
                inputs = new Scanner(new File(args[0] + ".txt"));

            } catch (FileNotFoundException e) {
                System.out.println("No such file: " + args[0]);
                return;
            }
            if (args.length == 1) { // input only
                String input;
                while(inputs.hasNext()) {
                    input = inputs.nextLine();
                    int myOutput = run(input);
                }
            } else { // has output file
                Scanner outputs;
            
                try {
                    outputs = new Scanner(new File(args[1] + ".txt"));
    
                } catch (FileNotFoundException e) {
                    System.out.println("No such file: " + args[1]);
                    return;
                }
    
                String input, output;
                int testsPassed = 0;
                int testsRun = 0;
    
                // get output for every line
                while(inputs.hasNext()) {
                    input = inputs.nextLine();
                    output = outputs.nextLine();
                    int myOutput = run(input);
                    testsRun++;

                    if (Integer.toString(myOutput).equals(output)) { //pass test
                        testsPassed++;
                        System.out.println("\u001B[32m[PASSED]:\u001b[0m test " + testsRun + "\t run(" + input + ")" );
    
                    } else {
                        System.out.println("\u001B[31m[FAILED]:\u001B[31m test " + testsRun + "\t run(" + input + "). Expected '" + output + "' but got '" + myOutput + "'."   );
    
                    }
                    
                }
                if (testsPassed == testsRun) {
                    System.out.println("\u001B[32mTests run: " + testsRun + "\u001b[0m, Failures: " + (testsRun - testsPassed) );
                }  else {
                    System.out.println("\u001B[33mTests run: " + testsRun + "\u001B[33m, \u001B[0mFailures: " + (testsRun - testsPassed) + "\u001B[31m");
    
                }
    
            }
           

        } else { // loop console input
            while(true) 
            {
                Scanner input = new Scanner(System.in);
                //System.out.print("> Insira a sequencia de direcoes");
                String directions = input.nextLine();
                int myOutput = run(directions);

                System.out.println(myOutput); 
            }
        }
        
    }
}

