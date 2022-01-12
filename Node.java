public class Node {
    
    private Node N;
    private Node S;
    private Node E;
    private Node O;

    private boolean hasPokemon = true;

    public Node() {}

    public void removePokemon() { hasPokemon = false; }
    
    /* GETTERS */
    public Node getN() { return N; }
    public Node getS() { return S; }
    public Node getE() { return E; }
    public Node getO() { return O; }

    public boolean getPokemon() { return hasPokemon; }

    /*  SETTERS */
    public void setN(Node node) { N = node; }
    public void setS(Node node) { S = node; }
    public void setE(Node node) { E = node; }
    public void setO(Node node) { O = node; }
    
}
