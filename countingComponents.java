import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class countingComponents {

    public static void main(String[] args) throws IOException {

        Stack<Integer> myStack = new Stack<Integer>();
        BufferedReader buffered = null;
        String str;
        int lineCount = 0, columnCount = 0, flag = 0,i,j,k,coor_x,coor_y,count=0;
        try {

            System.out.println("Please Enter the Input File");
            Scanner obj = new Scanner(System.in);
            String File = obj.nextLine();

            FileInputStream f = new FileInputStream(File);
            buffered = new BufferedReader(new InputStreamReader(f));

            while ((str = buffered.readLine()) != null) {
                if (flag == 0) {
                    columnCount = str.length() / 2;
                    flag++;
                }

                lineCount++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (buffered != null) {
                try {
                    buffered.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        buffered = new BufferedReader(new FileReader("test_file_1.txt"));
        int[][] array= new int[lineCount][columnCount];
        flag=0;
        for(k=0;k<lineCount;k++) {
            str = buffered.readLine();
            String items[] = str.split(" ");
            for(i=0,j=0;i<str.length()-1;i=i+2,j++){
                array[k][j]=Integer.parseInt(items[i/2]);
            }
        }

        for(i=0;i<lineCount;i++) {
            for (j = 0; j < columnCount; j++) {
                if (array[i][j] == 1) {
                    array[i][j] = 5;
                    count++;
                    myStack.push(i);
                    myStack.push(j);


                    while(myStack.isEmpty()==false){
                        coor_y=myStack.pop();
                        coor_x=myStack.pop();

                        if(coor_y > 0 && array[coor_x][coor_y-1]==1){//controls left
                            array[coor_x][coor_y-1] = 5;
                            myStack.push(coor_x);
                            myStack.push((coor_y-1));
                        }

                        if((coor_x<lineCount-1) && array[coor_x+1][coor_y]==1  ){//controls down
                            array[coor_x+1][coor_y] = 5;
                            myStack.push((coor_x+1));
                            myStack.push(coor_y);
                        }

                        if((coor_y<columnCount-1) && array[coor_x][coor_y+1]==1 ){//controls right
                            array[coor_x][coor_y+1] = 5;
                            myStack.push(coor_x);
                            myStack.push((coor_y+1));
                        }

                        if(coor_x>0 && array[coor_x-1][coor_y]==1  ){//controls up
                            array[coor_x-1][coor_y] = 5;
                            myStack.push((coor_x-1));
                            myStack.push(coor_y);
                        }
                    }
                }
            }
        }
        System.out.println("Count of Components:"+ count);
    }
}