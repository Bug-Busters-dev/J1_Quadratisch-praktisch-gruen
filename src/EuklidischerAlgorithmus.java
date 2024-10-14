import java.util.ArrayList;
import java.util.Arrays;

public class EuklidischerAlgorithmus {

    private int euklidischerAlgorithmus(int zahly ,int zahlx){
        int ggT = 0;

        int a = 0;
        int b = 0;

        if (zahlx < zahly){
            a = zahly;
            b = zahlx;
        } else{
            a = zahlx;
            b = zahly;
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        ggT = a;

        return ggT;
    }


    public int[] gemeinsameTeilerFinden(int zahly, int zahlx) {
        ArrayList<Integer> teiler = new ArrayList<>();
    
        int ggT = this.euklidischerAlgorithmus(zahly, zahlx);
    
        
        for (int i = 1; i <= Math.sqrt(ggT); i++) {
            if (ggT % i == 0) {
                teiler.add(i); 
                if (i != ggT / i) {
                    teiler.add(ggT / i); 
                }
            }
        }
       
        int[] returnTeiler = new int[teiler.size()];
        for (int i = 0; i < returnTeiler.length; i++) {
            returnTeiler[i] = teiler.get(i);
        }

        Arrays.sort(returnTeiler);
    
        return returnTeiler; 
    }
}