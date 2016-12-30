/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class for storing game map data
 *
 * @author IBB Teilnehmer
 */
public class MapHandler implements Drawable {

    // basic gamemap, implemented as two-dimensional array
    // public char mapdata[][];
    // gamemap as objects
    public MapCell mapcells[][];

    // width of game map (in cells)
    public int width;

    // height of game map (in cells)
    public int height;

    // cell size in pixels
    public static final int cellsize = 32;

    // master map cells
    MapCellWall wall;
    MapCellFloor floor;
    MapCellWater water;
    MapCellHealing healing;
    
    // master map objects
    MapObjectGold gold;
    MapObjectChest chest;

    /**
     * Constructor
     */
    public MapHandler() {
        // initialize with default size if none is specified
        this(10, 10);
    }

    public MapHandler(int width, int height) {
        // store size
        this.width = width;
        this.height = height;

        // create master cell types
        wall = new MapCellWall();
        floor = new MapCellFloor();
        water = new MapCellWater();
        healing = new MapCellHealing();
        
        // test: create some gold
        gold = new MapObjectGold(100, new Position(30,200));
        
        // test: create a chest
        chest = new MapObjectChest(new Position(250,250));

        // create mapdata array
        //mapdata = new char[width][height];
        mapcells = new MapCell[width][height];
        ClearMap();

        // debug output
        System.out.println("wall:" + wall);
        System.out.println("mapdata array created with size " + width + ", " + height + ".");
    }

    /**
     * Set all map tiles to "floor".
     */
    public void ClearMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //mapdata[x][y] = '.'; // dot represents "empty"
                mapcells[x][y] = floor;
            }
        }
    }

    /**
     * Create "all" borders at north, south, east, west.
     */
    public void CreateBorders() {
        // north+south
        for (int x = 0; x < width; x++) {
            //mapdata[x][0] = 'X';
            //mapdata[x][height - 1] = 'X';
            mapcells[x][0] = wall;
            mapcells[x][height - 1] = wall;
        }

        // west+east
        for (int y = 0; y < height; y++) {
            //mapdata[0][y] = 'X';
            //mapdata[width - 1][y] = 'X';
            mapcells[0][y] = wall;
            mapcells[width - 1][y] = wall;
        }
    }

    /**
     * Change a map cell.
     *
     * @param position
     * @param cell
     * @return
     */
    public boolean SetMapCell(Position position, MapCell cell) {
        if (IsInsideMap(position)) {
            mapcells[position.x][position.y] = cell;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if a point is on the map. (to avoid array out of bounds access)
     *
     * @param pos
     * @return true if inside map
     */
    public boolean IsInsideMap(Position pos) {
        return (pos.x >= 0 && pos.x < width && pos.y >= 0 && pos.y < height);
    }

    /**
     * Check if a point is on the map and inside the borders.
     *
     * @param pt
     * @return true if inside borders
     */
    private boolean IsInsideBorders(Position pt) {
        return (pt.x > 0 && pt.x < width - 1 && pt.y > 0 && pt.y < height - 1);
    }

    /**
     * Check if a point on the map is still empty.
     *
     * @param pt
     * @return true if point is empty
     */
    public boolean IsEmpty(Position pt) {
        if (!IsInsideBorders(pt)) {
            return false;
        }

        // for testing, all cells inside the borders are empty
        if (mapcells[pt.x][pt.y] instanceof MapCellWall) {
            return false;
        } else {
            return true;
        }

//        if (mapdata[pt.x][pt.y] == '.') {
//            return true;
//        } else {
//            return false;
//        }
    }

    /**
     * Fill map with blocks at random positions. Positions at borders will be
     * avoided.
     */
    public void FillRandomly() {
        // how many cells do we want to set?
        int numberOfCells = 5;
        FillRandomly(numberOfCells);
    }

    /**
     * Fill map with x random blocks. Positions at borders will be avoided.
     *
     * @param numberOfCells Number of blocks which will be placed.
     */
    public void FillRandomly(int numberOfCells) {

        // check if there can be enough cells to fill:
        int maxCells = (width - 2) * (height - 2);
        if (numberOfCells > maxCells) {
            numberOfCells = maxCells;
            System.err.println("Map cannot have so many empty cells! "
                    + "I will only try to place " + numberOfCells);
        }

        // actually count free map cells
        int numberOfEmptyCells = 0;
        for (int y = 0; y < this.width; y++) {
            for (int x = 0; x < this.width; x++) {
                if (IsEmpty(new Position(x, y))) {
                    numberOfEmptyCells++;
                }
            }
        }
        if (numberOfEmptyCells < numberOfCells) {
            System.out.println("Not enough empty cells on the map.");
            numberOfCells = numberOfEmptyCells;
            System.out.println("I will only place " + numberOfCells);
        }

        for (int i = 0; i < numberOfCells; i++) {
            Position pt;
            // find a valid position
            do {
                // create random position
                pt = new Position((int) (Math.random() * width), (int) (Math.random() * height));
            } while (!IsEmpty(pt));
            // valid position found, set a block there
            //mapdata[pt.x][pt.y] = 'O';
            mapcells[pt.x][pt.y] = wall;
        }
    }

    /**
     * Print contents of map to stdout.
     */
    public void PrintToConsole() {
        // iterate over map, print content of cells
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char c = 'X'; //mapdata[x][y];
                System.out.print(c);
            }
            // next line
            System.out.println("");
        }
    }

    /**
     * Draw contents of map onto a canvas.
     *
     * @param canvas
     */
    @Override
    public void DrawOnCanvas(Canvas canvas) {
        //System.out.println("DrawOnCanvas()");

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLACK);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

//                // get mapdata at this position
//                char c = mapdata[x][y];
//
//                // set fill color depending on cell content
//                switch (c) {
//
//                    // wall
//                    case 'X':
//                        gc.setFill(Color.BLUE);
//                        wall.DrawOnCanvas(canvas, x, y);
//                        break;
//
//                    // block
//                    case 'O':
//                        gc.setFill(Color.YELLOW);
//                        gc.fillRect(x * cellsize, y * cellsize, cellsize, cellsize);
//                        ;
//                        break;
//
//                    // empty space
//                    case '.':
//                        gc.setFill(Color.GREEN);
//                        gc.fillRect(x * cellsize, y * cellsize, cellsize, cellsize);
//                        ;
//                        break;
//
//                    // default: red rectangle to show error
//                    default:
//                        gc.setFill(Color.RED);
//                        gc.fillRect(x * cellsize, y * cellsize, cellsize, cellsize);
//                        ;
//                }
                // tell map objects to draw themselves
                mapcells[x][y].DrawOnCanvas(canvas, x, y);

                // draw rectangle (posx,posy,width,height)
            }
        }
    }

    @Override
    public void DrawOnCanvas(Canvas canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Create and initialize our game map.
     */
//    public void InitMap() {
//        this.ClearMap();
//        this.CreateBorders();
//        this.FillRandomly(3);
//    }
    
    /**
     * Load level by number (starting with 1).
     * @param level 
     */
    public void InitLevel(int level) {
        switch (level) {
            case 1:
                InitLevel1();
                break;
            case 2:
                InitLevel2();
                break;
            case 3:
                InitLevel3();
                break;
            default:
                InitLevel1();
                break;
        }
    }

    /**
     * Load Level 1
     */
    private void InitLevel1() {
        this.ClearMap();
        this.CreateBorders();

        // create some obstacles
        this.SetMapCell(new Position(3, 3), this.water);
        this.SetMapCell(new Position(4, 3), this.water);
        this.SetMapCell(new Position(3, 4), this.water);
        this.SetMapCell(new Position(4, 4), this.water);

        // create healing field
        this.SetMapCell(new Position(6, 6), this.healing);

        // place some gold on the map
        // todo: place into list of game objects later 
        gold = new MapObjectGold(100, new Position(50, 200));
    }

    /**
     * Load Level 2
     */
    private void InitLevel2() {
        this.ClearMap();
        this.CreateBorders();

        // create some obstacles
        this.SetMapCell(new Position(4, 2), this.water);
        this.SetMapCell(new Position(3, 3), this.water);
        this.SetMapCell(new Position(4, 3), this.water);
        this.SetMapCell(new Position(5, 3), this.water);
        this.SetMapCell(new Position(3, 4), this.water);
        this.SetMapCell(new Position(4, 4), this.water);
        this.SetMapCell(new Position(5, 4), this.water);
        this.SetMapCell(new Position(4, 5), this.water);

        // create healing field
        this.SetMapCell(new Position(8, 8), this.healing);
    }

    /**
     * Load Level 3
     */
    private void InitLevel3() {
        this.ClearMap();
        this.CreateBorders();

        // create some obstacles
        this.SetMapCell(new Position(3, 3), this.water);
        this.SetMapCell(new Position(3, 4), this.water);
        this.SetMapCell(new Position(3, 5), this.water);
        this.SetMapCell(new Position(3, 6), this.water);

        this.SetMapCell(new Position(4, 3), this.water);
        this.SetMapCell(new Position(4, 4), this.water);
        this.SetMapCell(new Position(4, 5), this.water);
        this.SetMapCell(new Position(4, 6), this.water);

        this.SetMapCell(new Position(5, 3), this.water);
        this.SetMapCell(new Position(5, 4), this.water);
        this.SetMapCell(new Position(5, 5), this.water);
        this.SetMapCell(new Position(5, 6), this.water);

        // create healing field
        this.SetMapCell(new Position(1, 1), this.healing);

        // add random wall obstacles
        this.FillRandomly(3);
    }

}
