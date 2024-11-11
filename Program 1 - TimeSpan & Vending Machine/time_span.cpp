#include "time_span.h"
#include <iostream>
#include <cmath>
#include <string>
using namespace std;

// Getters and setters
int TimeSpan::hours() const {
    return hours_;
}

int TimeSpan::minutes() const {
    return mins_;
}

int TimeSpan::seconds() const {
    return secs_;
}

void TimeSpan::set_time(int hours, int minutes, int seconds) {
    hours_ = hours;
    mins_ = minutes;
    secs_ = seconds;
    CheckTime();
}

// Operator overloading
// Addition
TimeSpan TimeSpan::operator+(const TimeSpan& other) const {
    return TimeSpan(hours_ + other.hours_, mins_ + other.mins_, secs_ + other.secs_);
}
// Subtraction
TimeSpan TimeSpan::operator-(const TimeSpan& other) const {
    return TimeSpan(hours_ - other.hours_, mins_ - other.mins_, secs_ - other.secs_);
}
// Unary Negation
TimeSpan TimeSpan::operator-() const{
    // Convert everything to total seconds
    int totalSeconds = hours_ * 3600 + mins_ * 60 + secs_;
    
    // Negate the total seconds
    totalSeconds = -totalSeconds;
    
    // Convert back to hours, minutes, and seconds
    int hours = totalSeconds / 3600;
    totalSeconds %= 3600;
    int mins = totalSeconds / 60;
    int secs = totalSeconds % 60;
    
    // Return a new normalized TimeSpan object
    return TimeSpan(hours, mins, secs);
}
// += operator
TimeSpan& TimeSpan::operator+=(const TimeSpan& other) {
    hours_ += other.hours_;
    mins_ += other.mins_;
    secs_ += other.secs_;
    CheckTime();
    return *this;
}
// -= operator
TimeSpan& TimeSpan::operator-=(const TimeSpan& other) {
    hours_ -= other.hours_;
    mins_ -= other.mins_;
    secs_ -= other.secs_;
    CheckTime();
    return *this;
}
// == operator
bool TimeSpan::operator==(const TimeSpan& other) const {
    return (hours_ == other.hours_ && mins_ == other.mins_ && secs_ == other.secs_);
}
// != operator
bool TimeSpan::operator!=(const TimeSpan &other) const {
    return !(*this == other);
}
// < operator
bool TimeSpan::operator<(const TimeSpan& other) const {
    if (hours_ != other.hours_)
        return hours_ < other.hours_;
    if (mins_ != other.mins_)
        return mins_ < other.mins_;
    return secs_ < other.secs_;
}
// <= operator
bool TimeSpan::operator<=(const TimeSpan& other) const {
    if(hours_ != other.hours_) {
        return hours_ < other.hours_;
    }
    if(mins_ != other.mins_) {
        return mins_ < other.mins_;
    }
    return secs_ <= other.secs_;
}
// > operator
bool TimeSpan::operator>(const TimeSpan& other) const {
    if (hours_ != other.hours_)
        return hours_ > other.hours_;
    if (mins_ != other.mins_)
        return mins_ > other.mins_;
    return secs_ > other.secs_;
}
// >= operator
bool TimeSpan::operator>=(const TimeSpan& other) const {
    if (hours_ != other.hours_)
        return hours_ > other.hours_;
    if (mins_ != other.mins_)
        return mins_ > other.mins_;
    return secs_ >= other.secs_;
}

// Stream output
ostream& operator<<(std::ostream &out, const TimeSpan& obj) {
    out << "Hours: " << obj.hours_ << ", Minutes: " << obj.mins_ << ", Seconds: " << obj.secs_;
    return out;
}

// Stream input
istream& operator>>(istream& in, TimeSpan& obj) {
    int hours, minutes, seconds;
    in >> hours >> minutes >> seconds;
    obj.set_time(hours, minutes, seconds);
    return in;
}

// Helper function to convert the time into the correct format
void TimeSpan::CheckTime() {
    // Convert seconds if over 60
    mins_ += secs_ / 60;
    secs_ %= 60;
    // Convert seconds if negative
    if(secs_ < 0) {
        secs_ += 60;
        mins_--;
    }
    // Convert minutes if over 60
    hours_ += mins_ / 60;
    mins_ %= 60;
    // Convert minutes if negative
    if(mins_ < 0) {
        mins_ += 60;
        hours_--;
    }
    
    int totalSeconds = hours_ * 3600 + mins_ * 60 + secs_;
    if(totalSeconds < 0) {
        if(mins_ > 0) {
            mins_ -= 60;
            hours_++;
        }
        if(secs_ > 0) {
            secs_ -= 60;
            mins_++;
        }
    }
}



