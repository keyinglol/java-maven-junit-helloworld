package com.example.javamavenjunithelloworld;

/**
 * A very basic program that demonstrates the use of JUnit tests. The tests include a sample unit test and an
 * integration test.
 */
public class HelloApp {

    static int DEFAULT_TIMES = 3;

    static int EXIT_STATUS_PARAMETER_NOT_UNDERSTOOD = 2;
    static int EXIT_STATUS_HELLO_FAILED = 4;

    /**
     * The main method of this program.
     *
     * @param args Arguments passed to this program.
     */
    public static void main(String[] args) {

        int times = DEFAULT_TIMES;
        if (args.length >= 1) {
            try {
                times = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("I don't understand the parameter you passed me. Is it a number? " +
                        "Parameter was: [" + args[0] + "]");
                throw new IllegalArgumentException("Parameter not understood");
                //System.exit(EXIT_STATUS_PARAMETER_NOT_UNDERSTOOD);
            }
        }

        Hello hi = new Hello();
        try {
            hi.setTimes(times);
        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong: " + e.getMessage());
            throw new IllegalArgumentException("Parameter not understood");
            //System.exit(EXIT_STATUS_HELLO_FAILED);
        }
        hi.sayHello(System.out);

//        // Keep the container alive
//        System.out.println("App finished saying hello. Now keeping container alive...");
//        try {
//            while (true) {
//                Thread.sleep(10000); // Sleep 10 seconds in a loop
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Exiting container...");
//        }
    }

}
