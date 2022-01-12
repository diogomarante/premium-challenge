public class Player {

    private Node currentNode;

    private int pokemonCount = 0;

    public Player(Node startingNode) { 
        currentNode = startingNode; 
        catchPokemon();
    }

    public int getPokemonCount() { return pokemonCount; }

    public void catchPokemon() 
    { 
        pokemonCount++; 
        currentNode.removePokemon();
    }

    public void move(String direction)
    {
        switch(direction)
        {
            case "N":
                currentNode = currentNode.getN();
                break; 
            case "S":
                currentNode = currentNode.getS();
                break;            
            case "E":
                currentNode = currentNode.getE();
                break;
            case "O":
                currentNode = currentNode.getO();
                break;    
            default: 
                System.out.println("somethin went wrong parsing char: " + direction);
                System.exit(0);        
          
        }
        if (currentNode.getPokemon()) catchPokemon();
    }

}