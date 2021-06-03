package space.invaders;

import java.util.Random;

public class Spawner {
    private float spawnTime;
    private boolean[] spawnPoints = new boolean[Main.WINDOW_WIDTH / Main.SIZE * 2 + 1];

    public Spawner(){
        this.spawnTime = 3;
    }
    
    public float getSpawnTime() {
        return this.spawnTime;
    }

    public void setSpawnTime(float spawnTime) {
        this.spawnTime = spawnTime;
    }
    
    public Enemy spawnEnemy(){
        System.out.println("spawn enemy");
        Random rand = new Random();
        int x;
        
        int resets = 0;
        
        do{
            x = rand.nextInt(Main.WINDOW_WIDTH / Main.SIZE * 2);
            resets++;
        }while(spawnPoints[x] && resets >= 30);
        
        spawnPoints[x] = true;
        
        Enemy enemy = new Enemy(new Position(x * Main.SIZE / 2, 0), 1, 1, 10, "enemy1");
        return enemy;
    }
    
    public Shield spawnShield()
    {
        //System.out.println("spawn shield");
        Random rand = new Random();
        //int x = rand.nextInt(Main.WINDOW_WIDTH / Main.SIZE * 2);
        Shield shield= new Shield(new Position(Main.SIZE, Main.WINDOW_HEIGHT + Main.SIZE), 5, 0, "shield");
        return shield;
        
    }
    /*
    public Enemy spawnEnemy(Position pos){
        Enemy enemy = new Enemy(pos, 1, 1, 10, "enemy1");
        return enemy;
    }
    */
}
