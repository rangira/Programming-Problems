/* package whatever; // don't place package name! */


 class PingPong {
    /**
    * Number of hits ("pings" or "pongs") that must be reached by players in one game
     */
    private final int MAX_HITS = 10;
    /**
    * Counter of hits
     */
    private int hits = 0;

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        pingPong.startGame();  //lets start a game!
    }

    /**
     *  Increase hits counter per one hit.
     *  Method contains synchronized block witch maintain multithreaded queue of Player's hits.
     *
     */
    public void hit() {

        synchronized (this){   //lock
            System.out.println(Thread.currentThread().getName() + "!");    //define thread witch invoked method
            hits++;
            notify(); // send signal to other player to hit
            try {
                wait(); //release lock for other player to hit
            } catch (InterruptedException e) {
                // exception handling
                System.out.println(Thread.currentThread().getName() + " is interrupted!");
            }
            // control of game ending
            if (gameIsOver()) {
                System.out.println("Done!");
            }
        }
    }

    /**
     * Check is game is over (hit's counter reached the maximum)
     * @return "true" - game is over
     */
    public boolean gameIsOver(){
        return hits == MAX_HITS;
    }

    public void startGame() {
        //init players
        Player ping = new Player("Ping", this);
        Player pong = new Player("Pong", this);

        System.out.println("Ready… Set… Go!");
        // start hits
        ping.start();
        pong.start();
    }


    private class Player extends Thread {
        /**
         * Reference to single game context.
         */
        PingPong table;

        public Player(String name, PingPong table) {
            super(name);
            this.table = table;
        }

        @Override
        public void run() {
            // thread works only if game is valid
             while (!table.gameIsOver()){
                 table.hit();
             }
        }
    }
}
