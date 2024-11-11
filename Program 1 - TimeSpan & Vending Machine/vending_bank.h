#ifndef VENDING_BANK_H_
#define VENDING_BANK_H_
#include <string>
#include <vector>
using namespace std;

class VendingBank {
public:
    // Constructors
    VendingBank();
    VendingBank(int id);
    VendingBank(int id, double amount);
    VendingBank(int id, int dollars, int quarters, int dimes, int nickles, int pennies);
    // Destructor
    ~VendingBank();

    // getters-setters
    int Id() const; 
    int Dollars() const; 
    int Quarters() const; 
    int Dimes() const; 
    int Nickles() const; 
    int Pennies() const; 
    double Amount() const;
    void SetID(int id);
    bool SetDollars(int dollars);
    bool SetQuarters(int quarters);
    bool SetDimes(int dimes);
    bool SetNickles(int nickles);
    bool SetPennies(int pennies);
    
    // Coin Management
    int AddCoins(int dollars, int dimes, int nickles, int pennies) const; // take in coins 
    vector<double> GetInsertedCoins() const; // Returns the list of coins that were inserted by the user during the current transaction
    bool IsSufficient(double item_price) const; // Check if enough money has been inserted
    bool DispenseChange(double item_price) const; // dispense the change
    int Balance() const; // display the balance
    bool RemoveAmount() const;

    //Operators overload
    bool operator==(const VendingBank& other);
    bool operator!=(const VendingBank& other);

    friend ostream& operator<<(ostream& out, const VendingBank& obj);
    friend istream& operator>>(istream& in, VendingBank& obj);

private:
    // id_ is a unique identifier for the VendingBank
    // much like a serial number
    int id_;
    int dollars_;
    int quarters_;
    int dimes_;
    int nickles_;
    int pennies_;
    double amount_; // total amount of money inserted
    vector<double> inserted_coins_;  // Vector to track coins inserted in the current transaction
    // Helper function
    bool CheckCoins() const; // converts currency inputted into the right format (i.e. 1 Dollar and 5 Quarters will get converted to 2 Dollars and 1 Quarter)
};

#endif