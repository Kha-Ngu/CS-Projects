/**
* A driver to test Money, Date, and Bill classes.
* @author Khanh Nguyen, borrowed from Rob Nash
* @version 10/27/23
*/
public class BillMoneyDateDriver
{
    /**
     * Main driver for testing
     * Pre: nothing
     * Post: Print out a list of errors, periods if no errors
     * @param args  Array of command lines
     * @throws Exception    thrown when input violates class invariants
     */
    public static void main(String[] args) throws Exception {
        moneyTests(); //tests the Money class
        dateTests(); //tests the Date class
        billTests(); //tests the Bill class
    }
    /**
     * Test the money class
     * @throws Exception    thrown if the class invariants are violated
     */
    public static void moneyTests() throws Exception {
        System.out.println("Money Test Starts:");
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        money1.add(10, 101);
        if(money2.equals(money1)) {
            System.out.println("Money equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(money2.getCents() != 0) {
            System.out.println("getCents method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money2.getDollars() != 10) {
            System.out.println("getDollars method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money1.toString().compareTo("$41.51") != 0) {
            System.out.println("Add method is wrong!");
        }
        else {
            System.out.println(".");
        }

        //Money money6 = new Money(-1); //this threw an exception: Test Passed!
        //Money money7 = new Money(null); // this threw an exception: Test Passed!
        //Money money8 = new Money(-10, -100); // this threw an exception: Test Passed!

        Money money3 = new Money(0, 101);
        if(money3.getMoney() != 1.01) {
            System.out.println("getMoney method is incorrect!");
        }
        else{
            System.out.println(".");
        }
        
        Money money4 = new Money(5, 10);
        money4.setCents(90);
        if(money4.getMoney() != 5.90) {
            System.out.println("setCents method is wrong!");
        }
        else {
            System.out.println(".");
        }
        money4.setDollars(200);
        if(money4.getMoney() != 200.9) {
            System.out.println("setDollars method is wrong!");
        }
        else {
            System.out.println(".");
        }
        money4.add(money2);
        if(money4.getMoney() != 210.9) {
            System.out.println("add(Money o) method is incorrect!");
        }
        else{
            System.out.println(".");
        }
        money4.add(money1);
        if(money4.getMoney() != 252.41) {
            System.out.println("Privacy leak: The actual reference of money1 was passed in!");
        }
        else{
            System.out.println(".");
        }

        Money money5 = new Money(19, 89);
        money5.add(12345);
        if(money5.getDollars() != 12364) {
            System.out.println("getDollars method is wrong!");
        }
        else{
            System.out.println(".");
        }

        Money money6 = new Money(10, 1);
        if(money6.equals(money5)) {
            System.out.println("Money equals method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(!(money6.toString().compareTo(money5.toString()) != 0)) {
            System.out.println("toString method is wrong!");
        }
        else{
            System.out.println(".");
        }
        money6 = money5;
        if(!(money6.equals(money5))) {
            System.out.println("Money equals method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money6.toString().compareTo(money5.toString()) != 0) {
            System.out.println("toString method is wrong!");
        }
        else{
            System.out.println(".");
        }

        Money money9 = new Money(0, 2001);
        if(money9.getCents() == 2001) {
            System.out.println("Error: Class invariant is not kept");
        }
        System.out.println("All tests passed!");
        System.out.println("--------------------------------------");
    }

    /**
     * Tests the Date class
     * @throws Exception    thrown if input violates class invariants
     */
    public static void dateTests() throws Exception {
        System.out.println("Date Test Start:");

        Date date1 = new Date(11, 31, 2015);
        if(date1.getDay() != 31) {
            System.out.println("getDay method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(date1.getMonth() != 11) {
            System.out.println("getMonth method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(date1.getYear() != 2015) {
            System.out.println("getYear method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Date date2 = new Date(date1);
        if(date2.toString().compareTo(date1.toString()) != 0) {
            System.out.println("Copy constructor failed");
        }
        else {
            System.out.println(".");
        }

        date2.setYear(2001);
        if(date2.getYear() != 2001) {
            System.out.println("setYear method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date2.setDay(23);
        if(date2.getDay() != 23) {
            System.out.println("setDay method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date2.setYear(2018);
        if(date2.getYear() != 2018) {
            System.out.println("setYear method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(date2.toString().compareTo("11/23/2018") != 0) {
            System.out.println("toString method is wrong!");
        }

        //Date date3 = new Date(13,2,2001); //Threw exception: Month class invariant works
        //Date date4 = new Date(4, 50, 2005); //Threw exception: Day class invariant works
        //Date date5 = new Date(12, 13, 1989); //Threw exception: Year class invariant works

        Date date6 = new Date(12, 31, 2021);
        Date date7 = new Date(12,31, 2004);
        if(date6.isAfter(date7)) {
            System.out.println("isAfter method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date6.setDay(30); // 12/30/2012
        date7.setYear(2021); // 12/31/2021
        if(!date6.isAfter(date7)) {
            System.out.println("isAfter method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date7.setMonth(11); // 11/31/2021
        if(date7.getMonth() != 11) {
            System.out.println("setMonth method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(date6.isAfter(date7)) {
            System.out.println("isAfter method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Date date8 = new Date(1, 4, 2007);
        Date date9 = new Date(1, 4, 2001);
        if(date8.equals(date9)) {
            System.out.println("equals method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date9.setDate(1, 3, 2007);
        if(date8.equals(date9)) {
            System.out.println("setDate method is wrong!");
        }
        else {
            System.out.println(".");
        }

        date8.setDate(2, 3, 2007);
        if(date9.equals(date8)) {
            System.out.println("equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        
        System.out.println("All tests passed!");
        System.out.println("----------------------------------------");
    }

    /**
     * Tests the Bill class
     * @throws Exception    thrown if input violates the class invariants
     */
    public static void billTests() throws Exception {
        System.out.println("Bill Test Start:");
        //Construct some bills
        Money amount = new Money(1, 1);
        Date dueDate = new Date(1, 05, 2001);
        Bill bill1 = new Bill(amount, dueDate, "Amazon");
        
        if(!bill1.getAmount().equals(amount)) {
            System.out.println("getAmount method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(bill1.getOriginator() != "Amazon") {
            System.out.println("getOriginator method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Date paidDate = new Date(1, 3, 2001);
        bill1.setPaid(paidDate);
        if(bill1.getPaidDate() == null) {
            System.out.println("setPaid method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(bill1.getPaidDate().toString().compareTo("1/3/2001") != 0) {
            System.out.println("toString method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Money amount2 = new Money(200);
        Date dueDate2 = new Date(11, 18, 2004);
        Bill bill2 = new Bill(amount2, dueDate2, "Google");

        Date paidDate2 = new Date(11, 19, 2004);
        //bill2.setPaid(paidDate2); //Threw Exception: Paid date class invariant works
        dueDate2.setDate(12, 25, 2021);
        if(bill2.getDueDate().equals(dueDate2)) {
            System.out.println("Privacy Leak: setDate method did not create a copy!");
        }
        else {
            System.out.println(".");
        }
        
        if(paidDate2.isAfter(bill2.getDueDate())) {
            System.out.println("Privacy Leak: setDate did not create a copy!");
        }
        else {
            System.out.println(".");
        }

        amount2.setMoney(19, 98);
        if(bill2.getAmount().equals(amount2)) {
            System.out.println("Privacy Leak: setMoney method did not create a copy!");
        }
        else {
            System.out.println(".");
        }

        Money uwAmount = new Money(amount2);
        Date tuitionDue = new Date(10, 13, 2023);
        Bill uwBill = new Bill(uwAmount, tuitionDue, "University of Washington");
        Bill uwBill2 = new Bill(uwBill);

        if(!uwBill.equals(uwBill2)) {
            System.out.println("equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(!tuitionDue.equals(uwBill.getDueDate())) {
            System.out.println("getDueDate method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Date paid = new Date(tuitionDue);
        if(tuitionDue.isAfter(paid)) {
            System.out.println("isAfter method is wrong!");
        }
        else {
            System.out.println(".");
        }
        
        uwBill.setPaid(tuitionDue);
        if(!uwBill.getPaidDate().equals(tuitionDue)) {
            System.out.println("setPaid method is wrong!");
        }

        Money amount3 = new Money(1000, 50);
        Date dueDate3 = new Date(1, 2, 2003);
        Bill taxBill = new Bill(amount3, dueDate3, "IRS");
        Date paidDate3 = new Date(1, 1, 2003);
        taxBill.setPaid(paidDate3);
        taxBill.setDueDate(paidDate3);
        if(taxBill.getDueDate().isAfter(paidDate3)) {
            System.out.println("isAfter method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(dueDate3.equals(paidDate3)) {
            System.out.println("Privacy Leak: setDueDate method did not create a copy!");
        }
        else {
            System.out.println(".");
        }

        taxBill.setUnpaid(); //Test passed: getPaidDate threw an exception

        if(taxBill.isPaid()) {
            System.out.println("isPaid method is wrong!");
        }
        else {
            System.out.println(".");
        }

        Money newAmount = new Money(50000);
        taxBill.setAmount(newAmount);
        if(!taxBill.getAmount().equals(newAmount)) {
            System.out.println("setAmount method is wrong!");
        }
        else {
            System.out.println(".");
        }

        taxBill.setOriginator("Internal Revenue Service");
        if(taxBill.getOriginator() != "Internal Revenue Service") {
            System.out.println("setOriginator method is wrong!");
        }
        else {
            System.out.println(".");
        }

        System.out.println("All Tests Passed!");
        System.out.println("-------------------------------------------");
    }
}
