class nano {
    public void pr() {
        System.out.println("Here");
    }
}

public class Nonstatic_static {

    static private int x = 0;
    private int y = 44;

    public static class Static_class {
        public void staticfn() {
            System.out.println("Inside Static class");
            System.out.println(x);

            // The non static instance variable can be accessed through obj only!
            System.out.println(new Nonstatic_static().y);
        }
        // public class Instatic{
        // public void tfn(){
        // System.out.println("Inside nested class of static class");
        // }
        // }
    }

    public class Nonstaic_class {
        public void nonstaticfn() {
            System.out.println("Inside Non Static Class");
        }
    }

    public static void main(String[] args) {
        Nonstatic_static.Static_class a = new Nonstatic_static.Static_class();
        a.staticfn();

        // Nonstatic_static.Static_class.Instatic i = a.new Instatic();
        // i.tfn();

        // Nonstatic_static.Nonstaic_class b = new Nonstatic_static().new
        // Nonstaic_class();
        // b.nonstaticfn();
        // nano n = new nano();
        // n.pr();

    }
}
