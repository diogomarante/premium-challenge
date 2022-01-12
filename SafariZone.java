public class SafariZone {

    private ZoneData zoneData;
    private Node[][] nodes;

    SafariZone(ZoneData zoneData) 
    {
        this.zoneData = zoneData;

        nodes = new Node[zoneData.getHeight()][zoneData.getWidth()];

        setNodes();
    }

    public Node getStartingNode()
    {
        return nodes[zoneData.getinitialY()][zoneData.getinitialX()];
    }

    private void setNodes() 
    {
        int gridWidth = zoneData.getWidth();
        int gridHeight = zoneData.getHeight();

        // Create the nodes
        for (int i = 0; i < gridHeight; i++) 
            for (int j = 0; j < gridWidth; j++) 
                nodes[i][j] = new Node();

        // Set orthogonally adjacent nodes
        for (int i = 0; i < gridHeight; i++) 
            for (int j = 0; j < gridWidth; j++) 
            {
                if (i < gridHeight - 1) nodes[i][j].setS(nodes[i+1][j]);
                if (i > 0) nodes[i][j].setN(nodes[i-1][j]);
                if (j > 0) nodes[i][j].setO(nodes[i][j-1]);
                if (j < gridWidth - 1) nodes[i][j].setE(nodes[i][j+1]);
            }
    }
    
}
