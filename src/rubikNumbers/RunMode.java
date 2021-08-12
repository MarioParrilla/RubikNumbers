package rubikNumbers;

public class RunMode {
    static int player1, player2;
    final static int MAXPOINTS = 5;

    public void basicMode(){
        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo basico!");
        BasicMode basicMode = new BasicMode();
        c.start();

        basicMode.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        while(true){
            System.out.println("\nPlayer 1 -- Horizontal");
            basicMode.moveHorizontalBoard(basicMode.requestLane()-1,basicMode.requestMovements());
            int puntos = basicMode.checkBoardToPointsHorizontal() + basicMode.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            basicMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2 -- Vertical");
            basicMode.moveVerticalBoard(basicMode.requestLane()-1,basicMode.requestMovements());
            puntos = basicMode.checkBoardToPointsHorizontal() + basicMode.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            basicMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!");

        this.getTimeOfGame(c);
        App.menu();
    }

    public void advancedMode(){

        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo Avanzado!");
        AdvancedMode advancedMode = new AdvancedMode();
        c.start();

        advancedMode.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        while(true){
            System.out.println("\nPlayer 1");

            advancedMode.requestTypeOfMovement();
            int puntos = advancedMode.checkBoardToPointsHorizontal() + advancedMode.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            advancedMode.refillBoard();
            advancedMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2");

            advancedMode.requestTypeOfMovement();
            puntos = advancedMode.checkBoardToPointsHorizontal() + advancedMode.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            advancedMode.refillBoard();
            advancedMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!");

        this.getTimeOfGame(c);
        App.menu();
    }

    public void expertMode(){

        Crono c = new Crono();
        player1 = 0;
        player2 = 0;

        System.out.println("\nVas a jugar al modo Experto!");
        ExpertMode expertMode = new ExpertMode();

        expertMode.showBoard();
        System.out.println("Player 1: "+player1+" -- Player 2: "+player2);
        c.start();

        while (true){
            System.out.println("\nPlayer 1 -- Horizontal");
            expertMode.moveHorizontalBoard(expertMode.requestLane("player1")-1,expertMode.requestMovements());
            int puntos = expertMode.checkBoardToPointsHorizontal() + expertMode.checkBoardToPointsVertical();
            if (puntos!=0)player1+=puntos;
            if (player1>=MAXPOINTS) break;

            expertMode.turnBoard();
            expertMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);

            System.out.println("\nPlayer 2 -- Vertical");
            expertMode.moveVerticalBoard(expertMode.requestLane("player2")-1,expertMode.requestMovements());
            puntos = expertMode.checkBoardToPointsHorizontal() + expertMode.checkBoardToPointsVertical();
            if (puntos!=0)player2+=puntos;
            if (player2>=MAXPOINTS) break;

            expertMode.turnBoard();
            expertMode.showBoard();
            System.out.println("Player 1: "+player1+" -- Player 2: "+player2);
        }
        if (player1>=MAXPOINTS) System.out.println("El Player 1 ha ganado con "+player1+" puntos!");
        else System.out.println("El Player 2 ha ganado con "+player2+" puntos!");

        this.getTimeOfGame(c);
        App.menu();

    }

    public void getTimeOfGame(Crono c){
        c.stopTime();
        System.out.println("La partida ha tardado: "+c.getTime()+"\n");
    }

}
