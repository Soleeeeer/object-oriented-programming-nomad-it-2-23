import java.awt.Color;
import java.util.Random;

public class GameBoard {

    public static final int BOARD_COLUMNS = 4;
    public static final int BOARD_ROWS = 4;
    public Tile[][] board = new Tile[BOARD_ROWS][BOARD_COLUMNS];
    public int[] powers = new int[10];
    public Color[] colors = new Color[10];

    public GameBoard() {
        initPowers();
        int rV = randomValue();
        board[randomRow()][randomColumn()] = new Tile(rV, colors[rV], Color.BLACK);
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j] == null) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
    }

    public int randomColumn() {
        return new Random().nextInt(BOARD_COLUMNS);
    }

    public int randomRow() {
        return new Random().nextInt(BOARD_ROWS);
    }

    public int randomValue() {
        return Math.random() < 0.9 ? 2 : 4;
    }

    public void initPowers() {
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (int) Math.pow(2, i);
            colors[i] = getTileColor(powers[i]);
        }
    }

    private Color getTileColor(int value) {
        Color start = new Color(255, 255, 255);
        Color end = new Color(255, 100, 0);
        int maxPower = 11;
        int currentPower = (int) (Math.log(value) / Math.log(2));
        float t = (float) currentPower / maxPower;
        int r = (int) (start.getRed() + t * (end.getRed() - start.getRed()));
        int g = (int) (start.getGreen() + t * (end.getGreen() - start.getGreen()));
        int b = (int) (start.getBlue() + t * (end.getBlue() - start.getBlue()));
        return new Color(r, g, b);
    }

    public void right() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 1; j >= 0; j--) {
                Tile value = board[i][j];
                int count = j;
                for (int k = j + 1; k < BOARD_COLUMNS; k++) {
                    if (board[i][k].getValue() == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count != j) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[i][count] = value;
                }
            }
        }
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 2; j >= 0; j--) {
                Tile value = board[i][j];
                Tile value2 = board[i][j + 1];
                if (value.getValue() == value2.getValue() && value2.getValue() != 1) {
                    int val = value.getValue() + value2.getValue();
                    board[i][j + 1] = new Tile(val, getTileColor(val), Color.BLACK);
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 1; j >= 0; j--) {
                Tile value = board[i][j];
                int count = j;
                for (int k = j + 1; k < BOARD_COLUMNS; k++) {
                    if (board[i][k].getValue() == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count != j) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[i][count] = value;
                }
            }
        }
        spawnAndPrint();
    }

    public void left() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                Tile value = board[i][j];
                int count = j;
                for (int k = j - 1; k >= 0; k--) {
                    if (board[i][k].getValue() == 1) {
                        count--;
                    } else {
                        break;
                    }
                }
                if (count != j) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[i][count] = value;
                }
            }
        }
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS - 1; j++) {
                Tile value = board[i][j];
                Tile value2 = board[i][j + 1];
                if (value.getValue() == value2.getValue() && value2.getValue() != 1) {
                    int val = value.getValue() + value2.getValue();
                    board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                    board[i][j + 1] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                Tile value = board[i][j];
                int count = j;
                for (int k = j - 1; k >= 0; k--) {
                    if (board[i][k].getValue() == 1) {
                        count--;
                    } else {
                        break;
                    }
                }
                if (count != j) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[i][count] = value;
                }
            }
        }
        spawnAndPrint();
    }

    public void up() {
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = 0; i < BOARD_ROWS; i++) {
                Tile value = board[i][j];
                int count = i;
                for (int k = i - 1; k >= 0; k--) {
                    if (board[k][j].getValue() == 1) {
                        count--;
                    } else {
                        break;
                    }
                }
                if (count != i) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[count][j] = value;
                }
            }
        }
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = 0; i < BOARD_ROWS - 1; i++) {
                Tile value = board[i][j];
                Tile value2 = board[i + 1][j];
                if (value.getValue() == value2.getValue() && value2.getValue() != 1) {
                    int val = value.getValue() + value2.getValue();
                    board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                    board[i + 1][j] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = 0; i < BOARD_ROWS; i++) {
                Tile value = board[i][j];
                int count = i;
                for (int k = i - 1; k >= 0; k--) {
                    if (board[k][j].getValue() == 1) {
                        count--;
                    } else {
                        break;
                    }
                }
                if (count != i) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[count][j] = value;
                }
            }
        }
        spawnAndPrint();
    }

    public void down() {
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = BOARD_ROWS - 1; i >= 0; i--) {
                Tile value = board[i][j];
                int count = i;
                for (int k = i + 1; k < BOARD_ROWS; k++) {
                    if (board[k][j].getValue() == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count != i) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[count][j] = value;
                }
            }
        }
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = BOARD_ROWS - 1; i > 0; i--) {
                Tile value = board[i][j];
                Tile value2 = board[i - 1][j];
                if (value.getValue() == value2.getValue() && value2.getValue() != 1) {
                    int val = value.getValue() + value2.getValue();
                    board[i][j] = new Tile(val, getTileColor(val), Color.BLACK);
                    board[i - 1][j] = new Tile(1, colors[1], Color.BLACK);
                }
            }
        }
        for (int j = 0; j < BOARD_COLUMNS; j++) {
            for (int i = BOARD_ROWS - 1; i >= 0; i--) {
                Tile value = board[i][j];
                int count = i;
                for (int k = i + 1; k < BOARD_ROWS; k++) {
                    if (board[k][j].getValue() == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count != i) {
                    board[i][j] = new Tile(1, colors[1], Color.BLACK);
                    board[count][j] = value;
                }
            }
        }
        spawnAndPrint();
    }

    private void spawnAndPrint() {
        boolean full = true;
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j].getValue() == 1) {
                    full = false;
                    break;
                }
            }
        }
        if (!full) {
            while (true) {
                int i = randomRow();
                int j = randomColumn();
                if (board[i][j].getValue() == 1) {
                    int rV = randomValue();
                    board[i][j] = new Tile(rV, getTileColor(rV), Color.BLACK);
                    break;
                }
            }
        }
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                System.out.print(board[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}