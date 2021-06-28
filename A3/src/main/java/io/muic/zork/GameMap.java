package io.muic.zork;


import io.muic.zork.enemy.Enemy;
import io.muic.zork.enemy.EnemyFactory;
import io.muic.zork.item.Item;
import io.muic.zork.item.ItemFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private List< List<Room> > gameMap;
    private int mapRow;
    private int mapCol;
    private int pStartRow;
    private int pStartCol;

    /**
     * Constructor. Given specifications in a file, it creates a map
     * @param path
     * @throws IOException
     */
    public GameMap(String path) throws IOException {
        // Read from file specified by path
        File file = new File(path);
        FileReader fr = new FileReader(file);   //reads the file
        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream

        // First 4 lines are map dimensions and starting point
        mapRow = Integer.parseInt(br.readLine());
        mapCol = Integer.parseInt(br.readLine());
        pStartRow = Integer.parseInt(br.readLine());
        pStartCol = Integer.parseInt(br.readLine());

        // Start reading the rest of the file and convert them into 2D List of Rooms
        this.gameMap = new ArrayList<>();
        for (int row=0 ; row<mapRow ; row++)
        {
            List<Room> mapVert = new ArrayList<>(); // Each ArrayList<Room> in ArrayList<ArrayList<Room>> gameMap
            for (int col=0 ; col<mapCol ; col++)
            {
                // Get traversable directions
                String openDoor = br.readLine();
                // These String tell which enemy and/or item to put into this Room
                Enemy enemy = null;
                Item item = null;
                String enemyStr = br.readLine();
                String itemStr = br.readLine();
                // Convert enemy and item's string representation to its class instance
                if (!enemyStr.equals("∅")) enemy = EnemyFactory.createEnemy(enemyStr);
                if (!itemStr.equals("∅")) item = ItemFactory.createItem(itemStr);
                // Once we have Enemy and Item, create Room and add it into mapVert
                Room room = new Room(openDoor, enemy, item);
                mapVert.add(room);
            }
            this.gameMap.add(mapVert); // After each column is complete, move on to the next
        }
        fr.close();    //closes the stream and release the resources

    }

    // Functioning utilities

    /**
     * Get the Room at the specified coordinate
     * @param row
     * @param col
     * @return
     */
    public Room getRoomAt(int row, int col) {
        return this.gameMap.get(row).get(col);
    }

    /**
     * Returns true if, based on the dimensions our map have,
     * the coordinate is valid. (not out of bounds, etc.)
     * @param row
     * @param col
     * @return
     */
    public boolean isValidCoord(int row, int col) {
        if (row < 0 || row >= mapRow) return false;
        if (col < 0 || col >= mapCol) return false;
        return true;
    }



    // Printing utilities

    /**
     * Print content of all Rooms in this map column by column.
     */
    public void printMapContent() {
        int cnt = 0;
        for (int row = 0; row < mapRow; row++) {
            for (int col = 0; col < mapCol; col++) {
                gameMap.get(row).get(col).printRoomContent();
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public void printContentAtRoom(int row, int col) {
        System.out.println("ROOM INFO:");
        this.gameMap.get(row).get(col).printRoomContent();
    }


    // Getters

    public int getMapRow() {
        return mapRow;
    }

    public int getMapCol() {
        return mapCol;
    }

    public int getpStartRow() {
        return pStartRow;
    }

    public int getpStartCol() {
        return pStartCol;
    }





    public static void main(String[] args) throws IOException {
//        String path = "C:\\Users\\Administrator.1LIZRQUYRIVXOVB\\Desktop\\MUIC\\Trimester VI\\Software Construction\\A3\\src\\main\\resources\\map1.txt";
        String path = "src\\main\\resources\\map1.txt";
        GameMap map1 = new GameMap(path);
        map1.printMapContent();
    }

}

