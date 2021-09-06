class NewThread2 implements Runnable{
    Thread t;

    NewThread2(){
//        t = new Thread(this, "Daemon Thread"); //create a second thread
          t = new Thread(this, "Daemon Thread");
        System.out.println("Child Thread "+t);
        t.start();
    }

    @Override
    public void run() {
        for(int i=5;i>0;i--){
            System.out.println("Child Thread "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting child thread");
    }
}



public class RunnableThread {
    public static void main(String[] args) {
        new NewThread2();
        for (int i=5;i>0;i--){
            System.out.println("Main Thread "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread exiting");
    }

}
