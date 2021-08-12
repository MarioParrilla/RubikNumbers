package rubikNumbers;

public interface ModeInterface {
    int[][] board = null;

    public void requestDimensions();
    public default int requestMovements(){
        int movements = 0;
        try {
            System.out.println("[+] Dime cuantas veces deseas mover: ");
            movements = Integer.parseInt(App.sc.nextLine());
        }catch (Exception e){
            System.err.println("[!] Indica una cantidad correcta!");
            movements = requestMovements();
        }
        return movements;
    }

    public int requestLane();
    public int requestLane(String typeOfPlayer);
    public void requestTypeOfMovement();
    public int[][] fillBoard(int[] dimensions);
    public void refillBoard();
    public void turnBoard();
    public void showBoard();
    public void moveHorizontalBoard(int lane, int movements);
    public void moveVerticalBoard(int lane, int movements);
    public int checkBoardToPointsHorizontal();
    public int checkBoardToPointsVertical();
}
