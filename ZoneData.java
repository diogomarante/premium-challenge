public class ZoneData {
    private int width;
    private int height;
    private int initialX;
    private int initialY;
    
    public ZoneData(int width, int height, int initialX, int initialY) 
    {
        this.width = width;
        this.height = height;
        this.initialX = initialX;
        this.initialY = initialY;
    }

    /* GETTERS */
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getinitialX() { return initialX; }
    public int getinitialY() { return initialY; }
}
