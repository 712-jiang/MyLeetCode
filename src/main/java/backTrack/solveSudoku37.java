package backTrack;

/**
 * @author 712
 * @function:  37. 解数独
 * @create 2021/5/30 12:40
 */
public class solveSudoku37 {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
    boolean backtrack(char[][] board,int row, int col){
        int cap = 9;
        //结束条件
        if(row == cap) return true;
        if(col == cap) {
            return backtrack(board,row+1,0);
        }
        for(int i=row; i<cap; i++){
            for(int j=col; j<cap; j++){

                //排除已有值的位置
                if(board[i][j] !='.') {
                    //做选择，不用放值，啥也不干
                    boolean no = backtrack(board,i,j+1);
                    //撤销选择，这里值不能动，啥也不干
                    return no;
                }

                //能放哪些值？1-9
                for(char num='1'; num<='9'; num++){
                    //做选择
                    if(!isValid(board,i,j,num,cap)) continue;  //如果1-9都不满足，for循环结束，得到return,本次递归结束，回到上一次backtrack函数的下一句：撤销选择
                    board[i][j] = num;
                    if (backtrack(board, i, j + 1))  return true;//这里可以优化，已得到可行的9x9排列马上返回
                    //撤销选择
                    board[i][j] = '.';
                }
                //当前位置没有合适的数，回溯
                return false;
            }
        }
        return true;       //这里
    }

    //现在num还没有添加到board中！比较的时候可以不考虑board[row][col]
    boolean isValid(char[][] board, int row, int col, char num, int cap){
        for(int i=0; i<cap; i++){
            //列,当前col,所有row没重复
            if(board[i][col] == num) return false;
            //行，当前row,所有col没重复
            if(board[row][i] == num) return false;
            //3X3 row col不同，row满3 + 1，col 123循环
            if(board[(row/3)*3+i/3][(col/3)*3+i%3] == num) return false;
        }
        return true;
    }
}
