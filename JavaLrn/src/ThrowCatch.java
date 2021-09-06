public class ThrowCatch {

    static void trymeth(int i) {
        if(i==1){
            int r = 1/0;
        }
        throw new NullPointerException();
    }
    public static void main(String[] args) {

        try {
            trymeth(1);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}