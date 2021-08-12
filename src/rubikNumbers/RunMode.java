package rubikNumbers;

public class RunMode {
    static int player1, player2;
    final static int MAXPOINTS = 5;

    public static void basicMode(){
        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo basico!");
        BasicMode bM = new BasicMode();
        c.start();

        bM.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        while(true){
            System.out.println("\nPlayer 1 -- Horizontal");
            bM.moveHorizontalBoard(bM.requestLane()-1,bM.requestMovements());
            int puntos = bM.checkBoardToPointsHorizontal() + bM.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            bM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2 -- Vertical");
            bM.moveVerticalBoard(bM.requestLane()-1,bM.requestMovements());
            puntos = bM.checkBoardToPointsHorizontal() + bM.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            bM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!\n");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!\n");
        c.stopTime();
        System.out.println(c.getTime());
        App.menu();
    }

    public static void advancedMode(){

        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo Avanzado!");
        AdvancedMode aM = new AdvancedMode();
        c.start();

        aM.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        while(true){
            System.out.println("\nPlayer 1");

            aM.requestTypeOfMovement();
            int puntos = aM.checkBoardToPointsHorizontal() + aM.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            aM.refillBoard();
            aM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2");

            aM.requestTypeOfMovement();
            puntos = aM.checkBoardToPointsHorizontal() + aM.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            aM.refillBoard();
            aM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!\n");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!\n");
        c.stopTime();
        System.out.println(c.getTime());
        App.menu();
    }

    public static void expertMode(){

        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo Experto!");
        ExpertMode eM = new ExpertMode();

        eM.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);
        c.start();

        while (true){
            System.out.println("\nPlayer 1 -- Horizontal");
            eM.moveHorizontalBoard(eM.requestLane("player1")-1,eM.requestMovements());
            int puntos = eM.checkBoardToPointsHorizontal() + eM.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            eM.turnBoard();
            eM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2 -- Vertical");
            eM.moveVerticalBoard(eM.requestLane("player2")-1,eM.requestMovements());
            puntos = eM.checkBoardToPointsHorizontal() + eM.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            eM.turnBoard();
            eM.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);
        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!\n");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!\n");
        c.stopTime();
        System.out.println(c.getTime());
        App.menu();

    }
}
