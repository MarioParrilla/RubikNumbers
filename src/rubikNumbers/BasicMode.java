package rubikNumbers;

public class BasicMode implements ModeInterface {


    private final int[][] board;
    private final int[] dimensionsBoard = new int[1];

    public BasicMode() {
        requestDimensions();
        this.board = fillBoard(dimensionsBoard);
    }

    public void requestDimensions(){
        String number = null;

        try {
            System.out.println("[+] De cuantas dimensiones quieres que sea el tablero: "+
                    "\n\tEjemplo --> 5 y lo que daria un tablero 5 x 5");
            number = App.sc.nextLine();
            dimensionsBoard[0] = Integer.parseInt(number);
        }
        catch (Exception e){
            System.err.println("[!] Introduce una dimension valida!, '"+number+"' no es una dimension valida.");
            requestDimensions();
        }
    }

    @Override
    public int requestLane() {
        int lane = 0;
        try {
            System.out.println("[+] Dime que linea deseas mover: ");
            lane = Integer.parseInt(App.sc.nextLine());
            if(lane>board.length) throw new Exception();
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
    public void requestTypeOfMovement() {}

    public int[][] fillBoard(int[] dimensions){
        int[][] filledBoard = new int[dimensionsBoard[0]][dimensionsBoard[0]];

        try{
            for (int i = 0; i < filledBoard.length; i++) {
                for (int j = 0; j < filledBoard.length; j++) {
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

    }

    @Override
    public void turnBoard() {
    }

    public void showBoard(){
        try{
            System.out.print("\t");
            for (int i = 0; i < board.length; i++) {
                if (i>=9)System.out.print(i+1+" ");
                else System.out.print(" "+(i+1)+" ");
            }
            System.out.println();
            System.out.print("\t");
            for (int i = 0; i < board.length+(board.length*0.5); i++) {
                System.out.print("- ");
            }
            System.out.println();
            for (int i = 0; i < board.length; i++) {
                if (i>=9) System.out.print(i+1+"| ");
                else System.out.print(i+1+" | ");

                for (int j = 0; j < board.length; j++) {
                    System.out.print(" "+board[i][j]+" ");
                }
                System.out.println();
            }
        }catch (Exception e){
            System.err.println("[!] Error al mostrar la matriz");
        }
    }

    public void moveHorizontalBoard(int lane, int movements){
        for (int i = 0; i < movements; i++) {
            int lastPosition = board[lane][board.length-1];
            for (int j = board.length-1; j > 0 ; j--) {
                board[lane][j]=board[lane][j-1];
            }
            board[lane][0]=lastPosition;
        }
    }

    public void moveVerticalBoard(int lane, int movements){
        for (int i = 0; i < movements; i++) {
            int lastPosition = board[board.length-1][lane];
            for (int j = board.length-1; j > 0 ; j--) {
                board[j][lane]=board[j-1][lane];
            }
            board[0][lane]=lastPosition;
        }
    }

    public int checkBoardToPointsHorizontal(){
        int checker1 = 0;
        int checker2 = 3;
        String lane = "";
        int puntos = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
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

    public int checkBoardToPointsVertical(){
        int checker1 = 0;
        int checker2 = 3;
        String lane = "";
        int puntos = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
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
