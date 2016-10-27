ou are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Analysis

leetcode-nim-game-java

Java Solution

public boolean canWinNim(int n) {
    return n%4>0;
}
