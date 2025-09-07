public class TicTacToe {
    int[] computer = new int[8];
    int[] human = new int[8];


    // This is simple: For every move, compute the count of its row, column and diagonal points,
    // Whichever reaches 3 point give the player a win
    public boolean hasWon(Player p) {
        int[] table = p == Player.COMPUTER ? computer : human;
        for (int i :  table) {
            if (i == 3) return true;
        }
        return false;
    }

    public void score(Player p, int pos) {
        int[] table = p == Player.COMPUTER ? computer : human;
        switch (pos) {
            case 0:
                table[0] += 1;
                table[3] += 1;
                table[6] += 1;
                break;
            case 1:
                table[0] += 1;
                table[4] += 1;
                break;
            case 2:
                table[0] += 1;
                table[5] += 1;
                table[7] += 1;
                break;
            case 3:
                table[1] += 1;
                table[3] += 1;
                break;
            case 4:
                table[1] += 1;
                table[4] += 1;
                table[6] += 1;
                table[7] += 1;
                break;
            case 5:
                table[1] += 1;
                table[5] += 1;
                break;
            case 6:
                table[2] += 1;
                table[3] += 1;
                table[7] += 1;
                break;
            case 7:
                table[2] += 1;
                table[4] += 1;
                break;
            case 8:
                table[2] += 1;
                table[5] += 1;
                table[6] += 1;

        }
    }

   public enum Player {
        COMPUTER,
        HUMAN
    }
}

