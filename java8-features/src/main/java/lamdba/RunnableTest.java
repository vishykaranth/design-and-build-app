package lamdba;

public class RunnableTest {
    public static void main(String[] args) {
        // Anonymous Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Example via Anonymous");
            }
        };

        //Lambda Runnable
        Runnable runnableLambda = () -> System.out.println("Runnable via Lambda");

        runnable.run();
        runnableLambda.run();


    }
}
