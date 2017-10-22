package queueassg4;

import java.util.concurrent.ThreadLocalRandom;

/**
 * German Candelaria
 * CSCI-3343
 * 03/04/2017
 */
public class QueueAssg4 {

    public static void main(String[] args) {
        ArrayQueue myqueue = new ArrayQueue();
        final int MIN = 1;
        final int MAX = 10;
        int intCurrentCustomer = 1;
        int intRandomCustomers, intRandomServedCustomers;
        
        for (int y = 1; y <= 10; y++){
            //Random number of customers arriving
            intRandomCustomers = ThreadLocalRandom.current().nextInt(MIN, (MAX + 1) - myqueue.getSize());
            //Printing the number of customers taht arrived
            System.out.println("\n==" + intRandomCustomers + " Customer(s) arriving to the bank at cycle " + y + "==\n");
            //Enqueuing the customers to the queue
            for (int x = 1; x <= intRandomCustomers; x++){
                myqueue.enqueue("Customer " + intCurrentCustomer);
                System.out.println("Customer " + intCurrentCustomer + " has arrived to the bank!");
                intCurrentCustomer++;
            }
            //Displaying current line
            System.out.println("\n==Current bank line==\n");
            myqueue.printAll();
            //Generating a random number of customer to be served by tellers
            intRandomServedCustomers = ThreadLocalRandom.current().nextInt(MIN, myqueue.getSize() + 1);
            //Printing out the customers which will be served
            if (intRandomServedCustomers == 1) {
                System.out.println("\n==" + intRandomServedCustomers + " Customer is served by a teller==\n");
            } else {
                System.out.println("\n==" + intRandomServedCustomers + " Customers are served by tellers==\n");
            }
            //Dequeuing the served customers
            for (int x = 1; x <= intRandomServedCustomers; x++){
                System.out.println(myqueue.dequeue() + " has been served by a teller");
            }
            //Displaying new status of line after certain customers have been served
            System.out.println("\n==Updated bank line after cycle " + y + "==\n");
            myqueue.printAll();
        }
    }
    
}
