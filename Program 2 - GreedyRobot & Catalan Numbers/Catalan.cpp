#include <iostream>
#include <stdexcept>
using namespace std;

//Function to compute the nth Catalan number
int CatalanNumber(int n) {
    // Handle negative numbers
    if (n < 0) {
        throw std::invalid_argument("Catalan number is not defined for negative values.");
    }

    // Set a reasonable limit
    if(n > 16) {
        throw out_of_range("Input too large, may cause int overflow.");
    }
    
    // Base Case
    if(n == 0 || n == 1) {
        return 1;
    }

    // Calculate Catalan number recursively
    int result = 0;
    for(int i = 0; i < n; i++) {
        result += CatalanNumber(i) * CatalanNumber(n - 1 - i);
    }
    return result;
}

int main(int argc, char* argv[]) {
    if(argc != 2) {
        cerr << "Error: Too few arguments." << endl;
        return 1;
    }

    try {
        int n = stoi(argv[1]);
        int result = CatalanNumber(n);
        cout << "The Catalan number of " << n << " is " << CatalanNumber(n) << endl;
    }
    catch (const exception& e) {
        cerr << e.what() << endl;
        return 1;
    }

    return 0;
}