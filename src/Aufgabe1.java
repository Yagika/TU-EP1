/*
    Aufgabe 1) Zweidimensionale Arrays und Gameplay - Sokoban
*/

import codedraw.*;
import codedraw.Image;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aufgabe1 {
    private static final int SQUARE_SIZE = 40;

    // reads levels from file / first line is number of levels
    private static String[] readLevels(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int numberOfLevels = sc.nextInt();
        int counter = -1; // starts at -1 because first line is empty after reading int
        String[] levels = new String[numberOfLevels];
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                levels[++counter] = "";
            } else {
                levels[counter] += line + "\n";
            }
        }
        return levels;
    }

    // returns level as char array and fills goal positions into goals array
    private static char[][] newLevel(int[][] goals, String levelString) {
        // calculate array size
        int xSize = 0;
        int ySize = 0;
        int counter = 0;

        for (int i = 0; i < levelString.length(); i++) {
            if (levelString.charAt(i) == '\n') {
                ySize++;
                if (counter > xSize) {
                    xSize = counter;
                }
                counter = 0;
            } else {
                counter++;
            }
        }

        // fill array and goals
        char[][] levelArr = new char[ySize][xSize];
        int goalCounter = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < levelString.length(); i++) {
            char item = levelString.charAt(i);
            switch (item) {
                case '.' -> {
                    levelArr[y][x] = ' ';
                    goals[goalCounter++] = new int[]{x, y};
                    x++;
                }
                case '\n' -> {
                    y++;
                    x = 0;
                }
                case '#', '$', '@', ' ' -> {
                    levelArr[y][x] = item;
                    x++;
                }
                default -> {
                }
            }
        }
        return levelArr;
    }

    // calculates based on the current position and the direction the new position coordinates
    private static int[] adjacentPosition(int[] position, int direction) {
        return switch (direction) {
            case 1 -> new int[]{position[0], position[1] - 1};
            case 2 -> new int[]{position[0], position[1] + 1};
            case 3 -> new int[]{position[0] - 1, position[1]};
            case 4 -> new int[]{position[0] + 1, position[1]};
            default -> new int[]{-1, -1};
        };
    }

    // helping method for writing text in the CodeDraw window
    private static void showText(CodeDraw myDrawObj, double x, double y, String text) {
        myDrawObj.clear(Color.white);
        myDrawObj.setColor(Color.black);
        myDrawObj.drawText(x, y, text);
        myDrawObj.show();
    }

    // returns the total number of goals in the level
    private static int numberOfGoals(String levelString) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (levelString != null && levelString.length() > 0) {
            int sum = 0;
            for (int i = 0; i < levelString.length(); i++) {
                if (levelString.charAt(i) == '.') {
                    sum++;
                }
            }
            return sum;
        }
        return -1; //Zeile kann geändert oder entfernt werden.
    }

    // returns position of the figure. [0] = x, [1] = y
    private static int[] figurePosition(char[][] level) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (level != null) {

            for (int x = 0; x < level.length; x++) {
                if (level[x] != null) {
                    for (int y = 0; y < level[1].length; y++) {
                        if (level[x][y] == '@') {
                            return new int[]{y, x};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1}; //Zeile kann geändert oder entfernt werden.
    }


    // moves figure and box if they don't hit an obstacle
    // returns true if figure was moved
    private static boolean move(char[][] level, int direction) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (level != null && direction > 0 && direction < 5) {
            int[] curPos = figurePosition(level);
            int[] newPos = adjacentPosition(curPos, direction);

            if (curPos[0] == -1 || curPos[1] == -1 || newPos[0] < 0 || newPos[0] >= level[0].length || newPos[1] < 0 || newPos[1] >= level.length) {
                return false;
            }

            char curZei = level[curPos[1]][curPos[0]];
            char newZei = level[newPos[1]][newPos[0]];

            if (newZei == ' ') {
                level[newPos[1]][newPos[0]] = curZei;
                level[curPos[1]][curPos[0]] = ' ';
                return true;
            } else if (newZei == '$') {
                int[] boxPosition = adjacentPosition(newPos, direction);
                if (boxPosition == null) {
                    return false;
                }
                char nextCharacter = level[boxPosition[1]][boxPosition[0]];
                if (nextCharacter == ' ' || nextCharacter == '.') {
                    level[newPos[1]][newPos[0]] = curZei;
                    level[boxPosition[1]][boxPosition[0]] = '$';
                    level[curPos[1]][curPos[0]] = ' ';
                    return true;
                }
            } else if (newZei == '#') {
                return false;
            }
        }
        return false;
    }

    // returns current position of all boxes
    private static int[][] boxPositions(char[][] level, int numberOfBoxes) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] boxesPos = new int[numberOfBoxes][2];
        int sum = 0;
        for (int x = 0; x < level.length; x++) {
            for (int y = 0; y < level[x].length; y++) {
                if (level[x][y] == '$') {
                    boxesPos[sum][0] = x;
                    boxesPos[sum][1] = y;
                    sum++;
                }
            }
        }
        return boxesPos; //Zeile kann geändert oder entfernt werden.
    }

    // returns true if all boxes are on a goal
    private static boolean won(char[][] level, int[][] goals) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int[] goal : goals) {
            int goalX = goal[0];
            int goalY = goal[1];

            if (level[goalY][goalX] != '$') {
                return false;
            }
        }

        return true; //Zeile kann geändert oder entfernt werden.
    }


    // draws the current level with all elements
    private static void drawGame(CodeDraw myDrawObj, char[][] level, int[][] goals, int direction) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int x = 0; x < level.length; x++) {
            for (int y = 0; y < level[x].length; y++) {
                for (int[] goal : goals) {
                    if (goal[1] == x && goal[0] == y) {
                        myDrawObj.drawImage(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, Image.fromFile("src/endpoint.png"));
                        break;
                    }
                }
                switch (level[x][y]) {
                    case '#' ->
                            myDrawObj.drawImage(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, Image.fromFile("src/wall.png"));
                    case ' ' -> {
                        myDrawObj.setColor(Color.WHITE);
                        myDrawObj.drawRectangle(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                    }
                    case '$' -> {
                        boolean endpoint = false;
                        for (int[] goal : goals) {
                            if (goal[1] == x && goal[0] == y) {
                                endpoint = true;
                                break;
                            }
                        }
                        if (endpoint) {
                            myDrawObj.drawImage(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, Image.fromFile("src/box_goal.png"));
                        } else {
                            myDrawObj.drawImage(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, Image.fromFile("src/box.png"));
                        }
                    }
                    case '@' -> {

                        String dir = switch (direction) {
                            case 0, 2 -> "down";
                            case 1 -> "up";
                            case 3 -> "left";
                            case 4 -> "right";
                            default -> "";
                        };
                        myDrawObj.drawImage(y * SQUARE_SIZE, x * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE, Image.fromFile("src/figure_" + dir + ".png"));
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "sokoban_levels.csv";  // all levels for sokoban
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName;
        String[] allLevels = readLevels(filePath); //read all levels

        int levelId = 0;
        int[][] goals = new int[numberOfGoals(allLevels[levelId])][];//extract all goals of the first level
        char[][] level = newLevel(goals, allLevels[levelId]);//generate the first level as char array
        boolean gameRunning = true;
        int moveDirection = 0;
        int stepsLevel = 0;
        int stepsTotal = 0;

        CodeDraw myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
        myDrawObj.setTitle("Sokoban");
        TextFormat format = myDrawObj.getTextFormat();
        format.setTextOrigin(TextOrigin.CENTER);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        drawGame(myDrawObj, level, goals, moveDirection);
        myDrawObj.show();

        while (gameRunning) {
            // direction -> key: up, down, left and right
            // restart -> key r
            // to next level -> key t
            // quit -> key q
            if (myEventSC.hasKeyDownEvent()) {
                Key currentKey = myEventSC.nextKeyDownEvent().getKey();
                System.out.println("Last KEY pressed: " + currentKey);
                if (currentKey == Key.UP) {
                    moveDirection = 1;
                } else if (currentKey == Key.DOWN) {
                    moveDirection = 2;
                } else if (currentKey == Key.LEFT) {
                    moveDirection = 3;
                } else if (currentKey == Key.RIGHT) {
                    moveDirection = 4;
                } else if (currentKey == Key.R) { // reset current level
                    stepsLevel = 0;
                    goals = new int[numberOfGoals(allLevels[levelId])][];
                    level = newLevel(goals, allLevels[levelId]);
                    drawGame(myDrawObj, level, goals, moveDirection);
                } else if (currentKey == Key.T) { // skip to next level
                    if (levelId < allLevels.length - 1) {
                        stepsLevel = 0;
                        levelId++;
                        goals = new int[numberOfGoals(allLevels[levelId])][];
                        level = newLevel(goals, allLevels[levelId]);
                        myDrawObj.close();
                        myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
                        myDrawObj.setTextFormat(format);
                        myDrawObj.setTitle("Sokoban");
                        myEventSC = myDrawObj.getEventScanner();
                        drawGame(myDrawObj, level, goals, moveDirection);
                    } else { // end game
                        gameRunning = false;
                        showText(myDrawObj, level.length * SQUARE_SIZE / 2.0, level[0].length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                    }
                } else if (currentKey == Key.Q) { // quit game
                    gameRunning = false;
                }
            } else {
                myEventSC.nextEvent();
            }

            if (moveDirection != 0) {
                if (move(level, moveDirection)) {
                    stepsLevel++;
                    stepsTotal++;
                }
                drawGame(myDrawObj, level, goals, moveDirection);
                moveDirection = 0;
                if (won(level, goals)) {
                    showText(myDrawObj, level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "Steps: " + stepsLevel);
                    myDrawObj.show(2000);
                    stepsLevel = 0;
                    if (levelId < allLevels.length - 1) { // load next level
                        levelId++;
                        goals = new int[numberOfGoals(allLevels[levelId])][];
                        level = newLevel(goals, allLevels[levelId]);
                        myDrawObj.close();
                        myDrawObj = new CodeDraw(SQUARE_SIZE * level[0].length, SQUARE_SIZE * level.length);
                        myDrawObj.setTextFormat(format);
                        myDrawObj.setTitle("Sokoban");
                        myEventSC = myDrawObj.getEventScanner();
                        drawGame(myDrawObj, level, goals, moveDirection);
                        myDrawObj.show();
                    } else { // end game
                        gameRunning = false;
                        showText(myDrawObj, level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                        myDrawObj.show(2000);
                    }
                }
                System.out.println("Steps Level: " + stepsLevel + " Steps Total: " + stepsTotal);
            }
            myDrawObj.show();
        }
        myDrawObj.close();
    }
}
