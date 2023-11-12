import java.lang.Exception;
/**
 * RejseKort
 */
public class RejseKort {

    private int balance;
    private int lastCheckedInTimeStamp;
    private boolean checkedIn;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    
    
    public RejseKort() {
        balance = 100;
        checkedIn = false;
    }

    public void depositMoney(int dkk) {
        try {
            if (dkk < 0) {
                throw new Exception("Error: Cannot deposit negative amount");
            }
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance +" DKK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public boolean isCheckedIn(int timeStamp) {
        if(checkedIn && (timeStamp-lastCheckedInTimeStamp <= 120)) {
            return true;
        } else {
            return false;
        }
    }

    public void checkIn(int x, int y, int timeStamp) {
        if (balance < 100) {
            int deposit = 100 - balance;
            System.out.println("Not enough money in account to check in. Please deposit at least " + deposit + " DKK");
            return;
        }

        if (maxX == 0 && maxY == 0 && minX == 0 && minY == 0 ) {
            maxX = x;
            minX = x;
            maxY = y;
            minY = y;
        }
        
        if (!checkedIn) {
            checkedIn = true;
            if (maxX < x) {
                maxX = x;
            }
            if (minX > x) {
                minX = x;
            }
            if (maxY < y) {
                maxY = y;
            }
            if (minY > y) {
                minY = y;
            }
            lastCheckedInTimeStamp = timeStamp;
            System.out.println("Checked in");
        } else {
            if (maxX < x) {
                maxX = x;
            }
            if (minX > x) {
                minX = x;
            }
            if (maxY < y) {
                maxY = y;
            }
            if (minY > y) {
                minY = y;
            }
            int minutesSinceCheckIn = timeStamp - lastCheckedInTimeStamp;
            System.out.println("Continued journey (" + minutesSinceCheckIn + " minutes since last check in)");
            lastCheckedInTimeStamp = timeStamp;            
        }
    }

    public void checkOut(int x, int y, int timeStamp) {
        if (checkedIn) {
            checkedIn = false;
            if (maxX < x) {
                maxX = x;
            }
            if (minX > x) {
                minX = x;
            }
            if (maxY < y) {
                maxY = y;
            }
            if (minY > y) {
                minY = y;
            }
            int minutesSinceCheckIn = timeStamp - lastCheckedInTimeStamp;
            int price = 12 + (maxX - minX + maxY - minY) * 3;
            if (price > 50) price = 50;
            balance += -price;
            System.out.println("Checked out! " + minutesSinceCheckIn + " minutes since last check in. Price is " + price + " DKK, remaining balance is " + balance + " DKK");

        } else {
            System.out.println("Error: Cannot check out; Not currently checked in");
        }
    }   
    

}