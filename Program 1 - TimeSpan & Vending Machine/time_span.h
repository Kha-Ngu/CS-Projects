#ifndef TIME_SPAN_H_
#define TIME_SPAN_H_
#include <cmath>
#include <string>
using namespace std;

class TimeSpan {
public:
    TimeSpan() : hours_(0), mins_(0), secs_(0) {
        CheckTime();
    }
    template<class T>
    TimeSpan(T hours, T minutes, T seconds) {
        hours_ = (int) hours;
        double fractional_hours = hours - hours_;
        mins_ = (int) minutes + (int) fractional_hours * 60;
        secs_ = (int) seconds + (int) std::round(fractional_hours * 3600) % 60;
        CheckTime();
    }
    template<class T>
    TimeSpan(T minutes, T seconds) {
        hours_ = 0;
        mins_ = (int) minutes;
        secs_ = (int) seconds;
        CheckTime(); 
    } 
    template<class T>
    TimeSpan(T seconds) {
        hours_ = 0;
        mins_ = 0;
        secs_ = (int) seconds;
        CheckTime();
    }

    // getters and setters
    int hours() const; // return the number of hours as an int
    int minutes() const; // return the number os minutes as an int
    int seconds() const; // return the number of seconds as an int
    void set_time(int hours, int minutes, int seconds);

    // operator overload
    TimeSpan operator+(const TimeSpan& other) const; // addition
    TimeSpan& operator+=(const TimeSpan& other); // adding assignment
    TimeSpan operator-(const TimeSpan& other) const; // subtraction
    TimeSpan operator-() const; // Unary negation
    TimeSpan& operator-=(const TimeSpan& other); // subtracting assignment
    bool operator==(const TimeSpan& other) const; // equal comparison
    bool operator!=(const TimeSpan& other) const; // not equal comparison
    bool operator<(const TimeSpan& other) const; // less than
    bool operator<=(const TimeSpan& other) const; // less than or equal to
    bool operator>(const TimeSpan& other) const; // greater than
    bool operator>=(const TimeSpan& other) const; // greater than or equal to
    // input/output
    friend ostream& operator<<(ostream& out, const TimeSpan& obj);
    friend istream& operator>>(istream& in, TimeSpan& obj);

private:
    int hours_;
    int mins_;
    int secs_;

    void CheckTime(); // Performs conversion of hours, mins, and secs

};

#endif