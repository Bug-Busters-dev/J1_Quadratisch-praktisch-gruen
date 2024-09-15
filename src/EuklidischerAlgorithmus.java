public class EuklidischerAlgorithmus {

    public int euklidischerAlgorithmus(int zahly ,int zahlx){
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

    public int[] gemeinsameTeilerFinden(int zahly ,int zahlx){

    }
}