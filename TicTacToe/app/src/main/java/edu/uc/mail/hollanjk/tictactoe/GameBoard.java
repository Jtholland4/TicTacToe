package edu.uc.mail.hollanjk.tictactoe;

/**
 * Created by Jake on 2/15/2016.
 */
public class GameBoard {
    char [] board = new char [9];
    char currentTurn='x';
    char winner = ' '; //x,o,d

    public void GameBoard(){
        resetBoard();
    }

    public void resetBoard(){
        for (int i = 0; i <9; i++){
            board[i]=' ';
        }
    }

    public void setCurrentTurn(char a){
        currentTurn=a;
    }

    public char getCurrentTurn() {
        return currentTurn;
    }

    public void setBoard(int i,char a){
        board[i]=a;
    }

    private boolean isMatch(int a, int b, int c){
        return ((board[a]==board[b])&&(board[b]==board[c])&&(board[a]!= ' '));

    }

    public boolean detectWin(){
        this.winner=' ';
        if (isMatch(0,1,2)){
            this.winner=board[0];
        } else if (isMatch(3,4,5)){
            this.winner = board[3];
        }
        else if (isMatch(3,4,5)){
            this.winner = board[3];
        }
        else if (isMatch(6,7,8)){
            this.winner = board[6];
        }
        else if (isMatch(0,3,6)){
            this.winner = board[0];
        }
        else if (isMatch(1,4,7)){
            this.winner = board[1];
        }
        else if (isMatch(2,5,8)){
            this.winner = board[2];
        }
        else if (isMatch(0,4,8)){
            this.winner = board[0];
        }
        else if (isMatch(2,4,6)){
            this.winner = board[2];
        }
        return (this.winner!=' ');
    }

    public boolean detectTie(){
        boolean hasAllFilled=true;
        for (char cell: board){
            if(cell==' '){
                hasAllFilled=false;
                break;
            }
        }
        if (hasAllFilled){
            this.winner='D';
        }
        return hasAllFilled;
    }

    public char getCell(int i){
        return board[i];
    }
}
