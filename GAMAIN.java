package TTTGA;
import java.util.Arrays.*;
import java.util.*;
/**
 * Write a description of class GAMAIN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GAMAIN {
    ArrayList<String[][]> popArray = new ArrayList<String[][]>();
    static Random rand = new Random();
    int pop = 256;
    int mutRate = 10;
    int indLen = 8;
    int genes = 5812;
    int bestCase = 0;
    String choices = "123456789";
    String moves = "OX";
    int maxGens = 50;
    public String[][] createIndividual(){
        String[][] ind = new String[genes][2];
        //ind.add(Integer.toString(chars));   
        int num;
        for(int i = 0; i < (genes); i++) {
            ind[i][0] = choices;
            String newS = ind[i][0];
            if(i == 0){
                
            }else{
               for(int p = 0; p < 9; p++){
                    int pic = rand.nextInt(6) + 1; 
                    if (pic == 6) {
                        newS = newS.substring(0,p) + "X" + newS.substring(p + 1);
                    }else if (pic == 5) {
                        newS = newS.substring(0,p) + "O" + newS.substring(p + 1);
                    } else {
                        
                    }
                    
                }
                
            }
            ind[i][0] = newS;
        }
        for(int t = 0; t < genes; t++){
            ind[t][1] = "";
            boolean Notdecided = true;
            while(Notdecided){
               num = rand.nextInt(9) + 1;
               String id = (ind[t][0]);
               for(int e = 0; e < 9; e++){
                   
                   if(String.valueOf(num).equals((id.substring(e,e+1)))){
                      ind[t][1] += (num); 
                      Notdecided = false;
                   }
               }
               ind[t][1] += (num);
               Notdecided = false;
            }
            
            
        }
        //ind.set(0,0);  
        return ind;
    } 
    
    public int Turn(String[][] ind, String board) {
        GATicTacToe ttt = new GATicTacToe();
        bestCase = 0;
        int looped = 0;
        //System.out.println("board: " +board);
        for(int i = 0; i < genes; i++) {
            looped++;
            String ideal = ind[i][0];
            //System.out.println("loop " + looped);
            if(ideal.equals(board)){
                bestCase++;
                //System.out.println("ideal");
                for(int e = 0; e < board.length(); e++){
                    if(board.substring(e, e + 1).equals(ind[i][1])) {
                        //System.out.println("Found");
                        return Integer.valueOf(ind[i][1]);
                    }
                }
                /*if((ttt.getStatus(Integer.valueOf(ind[i][1])) == 0)) {
                    System.out.println("Ideal Found: "+ bestCase);
                    return Integer.valueOf(ind[i][1]);
                }*/
            }
        }
        return rand.nextInt(9) + 1;
    }
    
    
    public ArrayList<String[][]> mutate(ArrayList<String[][]> popA){
        ArrayList<String[][]> newArray = new ArrayList<String[][]>();
        for(int t = 0; t < pop ; t++){
            int mut = rand.nextInt(100) + 1;
            String[][] ind = new String[genes][2];
            
            ind = popA.get(t);
            
            int randCol = rand.nextInt(1);
            int randRow = rand.nextInt(genes);
            
            int place = rand.nextInt(3) + 1;
            
            int randV = rand.nextInt(1);
            int randI = rand.nextInt(9) + 1;
            if(mut < mutRate){
                ind = popA.get(t);
                if(randCol == 1){
                    ind[randRow][randCol] = String.valueOf(randI);
                }else{
                    String ideal = ind[randRow][randCol];
                    if(place == 1){
                        ind[randRow][randCol] = ideal.substring(0 ,place) + "X" + ideal.substring(place + 1);
                    }else if(place == 2){
                       ind[randRow][randCol] = ideal.substring(0 ,place) + "O" + ideal.substring(place + 1); 
                    }else {
                        ind[randRow][randCol] = ideal.substring(0 ,place) + place + ideal.substring(place + 1);
                    }
                }
            }
            newArray.add(ind);
        }
        return newArray;
    }
    
    public ArrayList<String[][]> crossOver(String[][] ind1,String[][] ind2){
        ArrayList<String[][]> popA = new ArrayList<String[][]>();
        for(int t = 0; t < pop ; t++){
           String[][] ind = new String[genes][2];
           //String[][] ind = popA.gt
           int randSpot = rand.nextInt(genes);
           int randSpot2 = rand.nextInt(genes);
           if(randSpot > randSpot2) {
               for(int e = 0; e < randSpot2; e++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[e][0] = ind1[e][0];
                       ind[e][1] = ind1[e][1];
                   }else{
                       ind[e][0] = ind2[e][0];
                       ind[e][1] = ind2[e][1];
                   }
               }
               for(int i = randSpot2; i < randSpot; i++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[i][0] = ind1[i][0];
                       ind[i][1] = ind1[i][1];
                   }else{
                       ind[i][0] = ind2[i][0];
                       ind[i][1] = ind2[i][1];
                   }
               }
               for(int a = randSpot; a < genes; a++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[a][0] = ind1[a][0];
                       ind[a][1] = ind1[a][1];
                   }else{
                       ind[a][0] = ind2[a][0];
                       ind[a][1] = ind2[a][1];
                   }
               }
           } else {
               for(int e = 0; e < randSpot; e++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[e][0] = ind1[e][0];
                       ind[e][1] = ind1[e][1];
                   }else{
                       ind[e][0] = ind2[e][0];
                       ind[e][1] = ind2[e][1];
                   }
               }
               for(int i = randSpot; i < randSpot2; i++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[i][0] = ind1[i][0];
                       ind[i][1] = ind1[i][1];
                   }else{
                       ind[i][0] = ind2[i][0];
                       ind[i][1] = ind2[i][1];
                   }
               }
               for(int a = randSpot2; a < genes; a++){
                   int rand55 = rand.nextInt(2) + 1;
                   if (rand55 == 1){
                       ind[a][0] = ind1[a][0];
                       ind[a][1] = ind1[a][1];
                   }else{
                       ind[a][0] = ind2[a][0];
                       ind[a][1] = ind2[a][1];
                   }
               }
               
           }
           popA.add(ind);
        }
        return popA;
    }
    
    
    public static void printArray(String matrix[][]) {
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row));   
        }
    }
    public static void printArrayList(ArrayList<String[][]> array) {
        for(String[][] ind : array) {
            System.out.println("individual");
            for (String[] row : ind) {
                System.out.println(Arrays.toString(row));   
            }
        }
    }
    public void playVGen(int gen,String[][] best,String[][] old ){
       GATicTacToe ttt = new GATicTacToe();
       int played = 0;
       int won = 0;
       boolean turn = true;
       Double cent = 0.0;
       for(int i = 0; i < 100; i++){
           String winner = ttt.mainClass(best, old);
           while (winner.equals("C")){
               winner = ttt.mainClass(best, old);
           }
           if(winner == "X") {
               won += 1;
           }else if(winner == "O"){
               
           }             
        }
       cent = (double)won ;
       System.out.println("Gen " + gen+ " Won " + cent + "%" + " of the time against the first gen");     
       
        
    }
    public void main() {
        System.out.println("Starting...");
        for(int e = 0; e < pop; e++) {
            //ArrayList<Integer> newInd = new ArrayList<Integer>();
            String[][] newInd;
            System.out.println("Making...");
            newInd = createIndividual();
            System.out.println("Made");
            popArray.add(newInd);
            System.out.println("Adding...");
            System.out.println("Inds: " + popArray.size());
        }
        ArrayList<String[][]> Gens = new ArrayList<String[][]>();
        //Orig = popArray;
        boolean on = true;
        Gens.add(popArray.get(0));
        int gen = 1;
        ArrayList<String> ind;
        GATicTacToe ttt = new GATicTacToe();
        playVSGA play = new playVSGA();
        
        while (on) {
            ArrayList<String[][]> newpopArray = new ArrayList<String[][]>();
            String[][] won;
            
            
            
            String didWin;
            
            //System.out.println("POP Cut:"+ popArray.size());
            if(popArray.size() == 2){
                System.out.println("Gen: " + gen);
                
                if(gen == 10){
                    Gens.add(popArray.get(0));
                }
                if(gen == 100){
                    Gens.add(popArray.get(0));
                }
                if(gen == 1000){
                    Gens.add(popArray.get(0));
                }
                if(gen == 10000){
                    Gens.add(popArray.get(0));
                }
                gen++;
                popArray = crossOver(popArray.get(0), popArray.get(1));
                popArray = mutate(popArray);
                //on = false;
                //popArray = crossOver(popArray.get(0), popArray.get(1));
                //popArray = mutate(popArray);
                //printArrayList(popArray);
                
            }
             
            
            //popArray = mutate(popArray.get(0), popArray.get(1))
            for(int i = 0; i < popArray.size() - 1; i += 2){
                //System.out.println("Cycling: "+ (i / 2));
                int ind2 = i + 1;
                
     
                String winner = ttt.mainClass(popArray.get(i), popArray.get(ind2));
                while (winner.equals("C")){
                    
                    winner = ttt.mainClass(popArray.get(i),popArray.get(ind2));
                }
                if(winner == "X") {
                     won = popArray.get(i);
                }else if(winner == "O"){
                     won = popArray.get(ind2);
                }else {
                    won = popArray.get(ind2);
                }              
                newpopArray.add(won);
            }
            popArray = newpopArray;
            if  (gen > maxGens){
                    if(popArray.size() <= 2){
                        Gens.add(popArray.get(0));
                        on = false;
                    }
            }
            
        }
        System.out.println("Gen: " + gen);
        for(int l = 1; l < Gens.size(); l++){
            //System.out.println((int)Math.pow(10,l));
            playVGen((int)Math.pow(10,l), Gens.get(l),Gens.get(0));
        }    
        on = true;
        while(on){
            play.mainClass(popArray.get(0));
        }
        on = false;
    }
}
