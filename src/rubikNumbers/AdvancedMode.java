package rubikNumbers;

public class AdvancedMode implements ModeInterface {

    private final int[][] board;
    private final int[] dimensionsBoard = new int[2];
    private String movement = "";

    public AdvancedMode() {
        requestDimensions();
        this.board = fillBoard(dimensionsBoard);
    }

    @Override
    public void requestDimensions() {
        try {
            System.out.println("[+] ¿Cuantas columnas quieres que tenga el tablero?: ");
            dimensionsBoard[0] = Integer.parseInt(App.sc.nextLine());
            System.out.println("[+] ¿Cuantas filas quieres que tenga el tablero?: ");
            dimensionsBoard[1] = Integer.parseInt(App.sc.nextLine());
        }catch (Exception e){
            System.err.println("[!] Error al pedir las dimensiones del tablero!");
            requestDimensions();
        }
    }

    @Override
    public void requestTypeOfMovement() {
        boolean stop = false;

        while(!stop){
            System.out.println("[+] Que quieres mover: [fila/columna]");
            movement = App.sc.nextLine().toLowerCase();
            if (movement.equals("fila") || movement.equals("columna")) stop=true;
        }
        if (movement.equals("fila")) moveHorizontalBoard(requestLane()-1,requestMovements());
        if (movement.equals("columna")) moveVerticalBoard(requestLane()-1,requestMovements());
    }

    @Override
    public int requestLane() {
        int lane = 0;
        try {
            System.out.println("[+] Dime que linea deseas mover: ");
            lane = Integer.parseInt(App.sc.nextLine());
            if (movement.equals("fila")) if(lane>dimensionsBoard[1]) throw new Exception();
            if (movement.equals("columna")) if(lane>dimensionsBoard[0]) throw new Exception();
        }catch (Exception e){
            System.err.println("[!] Indica una linea correcta!");
            lane = requestLane();
        }
        return lane;
    }

    @Override
    public int requestLane(String typeOfPlayer) {
        return 0;
    }


    @Override
    public int[][] fillBoard(int[] dimensions) {
        int[][] filledBoard = new int[dimensions[1]][dimensions[0]];

        try{
            for (int i = 0; i < dimensions[1]; i++) {
                for (int j = 0; j < dimensions[0]; j++) {
                    filledBoard[i][j] = (int) (Math.random()*9+1);
                }
            }
        }catch (Exception e){
            System.err.println("[!] Error al rellenar la matriz");
        }
        return filledBoard;
    }

    @Override
    public void refillBoard() {
        try {
            for (int i = 0; i < dimensionsBoard[1]; i++) {
                for (int j = 0; j < dimensionsBoard[0]; j++) {
                    if (board[i][j]!=0){
                        board[i][j] = (int) (Math.random()*9+1);
                    }
                }
            }
        }catch (Exception e){
            System.err.println("[!] Error al volver a rellenar la matriz");
        }
    }

    @Override
    public void turnBoard() {
    }

    @Override
    public void showBoard() {
        try{
            System.out.print("\t");
            for (int i = 0; i < dimensionsBoard[0]; i++) {
                if (i>=9)System.out.print(i+1+" ");
                else System.out.print(" "+(i+1)+" ");
            }
            System.out.println();
            System.out.print("\t");
            for (int i = 0; i < dimensionsBoard[0]+(dimensionsBoard[0]*0.5); i++) {
                System.out.print("- ");
            }
            System.out.println();
            for (int i = 0; i < dimensionsBoard[1]; i++) {
                if (i>=9) System.out.print(i+1+"| ");
                else System.out.print(i+1+" | ");

                for (int j = 0; j < dimensionsBoard[0]; j++) {
                    System.out.print(" "+board[i][j]+" ");
                }
                System.out.println();
            }
        }catch (Exception e){
            System.err.println("[!] Error al mostrar la matriz");
        }
    }

    @Override
    public void moveHorizontalBoard(int lane, int movements) {
        for (int i = 0; i < movements; i++) {
            int lastPosition = board[lane][dimensionsBoard[0]-1];
            for (int j = dimensionsBoard[0]-1; j > 0 ; j--) {
                board[lane][j]=board[lane][j-1];
            }
            board[lane][0]=lastPosition;
        }
    }

    @Override
    public void moveVerticalBoard(int lane, int movements) {//LO HACE ALREVES
        for (int i = 0; i < movements; i++) {
            int lastPosition = board[dimensionsBoard[1]-1][lane];
            for (int j = dimensionsBoard[1]-1; j > 0 ; j--) {
                board[j][lane]=board[j-1][lane];
            }
            board[0][lane]=lastPosition;
        }
    }

    @Override
    public int checkBoardToPointsHorizontal() {
        int checker1 = 0;
        int checker2 = 3;
        String lane = "";
        int puntos = 0;

        for (int i = 0; i < dimensionsBoard[1]; i++) {
            for (int j = 0; j < dimensionsBoard[0]; j++) {
                lane+=String.valueOf(board[i][j]);
            }
            for (int j = 0; j < lane.length(); j++) {
                if (checker1==lane.length()-2) break;
                else{
                    String laneToCheck = lane.substring(checker1,checker2);
                    checker1++;
                    checker2++;
                    String n1 = laneToCheck.substring(0,1);
                    String n2 = laneToCheck.substring(1,2);
                    String n3 = laneToCheck.substring(2,3);

                    if (n1.equals(n2) && n2.equals(n3)) {
                        if (n1.equals("0")) break;
                        board[i][j] = 0;
                        board[i][j+1] = 0;
                        board[i][j+2] = 0;
                        puntos++;
                    }
                }
            }
            checker1 = 0;
            checker2 = 3;
            lane = "";
        }
        return puntos;
    }

    @Override
    public int checkBoardToPointsVertical() {
        int checker1 = 0;
        int checker2 = 3;
        String lane = "";
        int puntos = 0;

        for (int i = 0; i < dimensionsBoard[0]; i++) {
            for (int j = 0; j < dimensionsBoard[1]; j++) {
                lane+=String.valueOf(board[j][i]);
            }
            for (int j = 0; j < lane.length(); j++) {
                if (checker1==lane.length()-2) break;
                else{
                    String laneToCheck = lane.substring(checker1,checker2);
                    checker1++;
                    checker2++;
                    String n1 = laneToCheck.substring(0,1);
                    String n2 = laneToCheck.substring(1,2);
                    String n3 = laneToCheck.substring(2,3);

                    if (n1.equals(n2) && n2.equals(n3)) {
                        if (n1.equals("0")) break;
                        board[j][i] = 0;
                        board[j+1][i] = 0;
                        board[j+2][i] = 0;
                        puntos++;
                    }
                }
            }
            checker1 = 0;
            checker2 = 3;
            lane = "";
        }
        return puntos;
    }
}

