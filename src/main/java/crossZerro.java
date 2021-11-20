import java.util.Random;
import java.util.Scanner;

public class crossZerro {
    public static char[][] MAP;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMAPFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMAPFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private static boolean isMAPFull() {
        for (int i=0; i< SIZE;i++){
            for (int j=0;j<SIZE; j++){
                if (MAP[i][j] == DOT_EMPTY){
                    return false;
                }
            }
    }return  true;

}

    public static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
               MAP[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static Scanner sc = new Scanner(System.in);
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (MAP[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static Random rand = new Random();
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        MAP[y][x] = DOT_O;
    }
    public static boolean checkWin(char symb) {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        for (int i = 0; i < SIZE; i++) {
            if (symb == MAP[i][c]) {
                a = a + 1;
                c = c + 1;
            } else {
                c = c + 1;
            }
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symb) {

                    b = b + 1;

                }
                if ((a == DOTS_TO_WIN) || (b == DOTS_TO_WIN)) return true;
            }
            for (i = 0; i < MAP.length; i++) {
                if (symb == MAP[i][i]) {
                    d = d + 1;
                }
            }
            for (i = 0; i < MAP.length; i++) {
                for (int j = 0; j < MAP.length - i; j++) {
                    if (symb == MAP[i][j]) {
                        e = e + 1;
                    }

                }if ((e == DOTS_TO_WIN) || (d == DOTS_TO_WIN)) return true;



            }

        }return false;
    }
}















//        if(MAP[0][0] == symb && MAP[0][1] == symb && MAP[0][2] == symb) return true;
//        if(MAP[1][0] == symb && MAP[1][1] == symb && MAP[1][2] == symb) return true;
//        if(MAP[2][0] == symb && MAP[2][1] == symb && MAP[2][2] == symb) return true;
//        if(MAP[0][0] == symb && MAP[1][0] == symb && MAP[2][0] == symb) return true;
//        if(MAP[0][1] == symb && MAP[1][1] == symb && MAP[2][1] == symb) return true;
//        if(MAP[0][2] == symb && MAP[1][2] == symb && MAP[2][2] == symb) return true;
//        if(MAP[0][0] == symb && MAP[1][1] == symb && MAP[2][2] == symb) return true;
//        if(MAP[2][0] == symb && MAP[1][1] == symb && MAP[0][2] == symb) return true;
//        return false;
//    }




