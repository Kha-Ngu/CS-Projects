#ifndef GREEDY_ROBOT_H
#define GREEDY_ROBOT_H
#include <vector>
#include <string>
using namespace std;

class GreedyRobot {
public:
    // Constructor
    GreedyRobot(int max_distance, int xr, int yr, int xt, int yt);

    // Getters
    const vector<string>& GetPaths() const;
    int GetPathCount() const;

    // Function
    void FindPaths();

private:
    int max_distance_;
    int xr_, yr_, xt_, yt_;
    int shortest_distance_;
    vector<string> paths_;
    void FindPathsHelper(int curr_x, int curr_y, string path, int consecutive_steps, char last_move);
};


#endif