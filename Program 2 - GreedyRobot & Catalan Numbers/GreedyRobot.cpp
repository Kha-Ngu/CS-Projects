#include "GreedyRobot.h"
#include <algorithm>
#include <cmath>

// Constructor
GreedyRobot::GreedyRobot(int max_distance, int xr, int yr, int xt, int yt)
    : max_distance_(max_distance), xr_(xr), yr_(yr), xt_(xt), yt_(yt) {
        // Calculate the shortest possible distance
        shortest_distance_ = abs(xr_ - xt_) + abs(yr_ - yt_);
    }

// Find all possible paths between the starting point and destination using helper method.
void GreedyRobot::FindPaths() {
    paths_.clear(); // Make sure paths is empty before starting
    FindPathsHelper(xr_, yr_, "", 0, ' ');
    sort(paths_.begin(), paths_.end());
}

// Returns the vector containing all the possible paths
const vector<string>& GreedyRobot::GetPaths() const {
    return paths_;
}

// Returns the number of paths
int GreedyRobot::GetPathCount() const {
    return paths_.size();
}

/**
 * @brief Recursive helper function explores all possible paths for the robot 
 * from its current position to the treasure.
 * 
 * @param curr_x Current x-coordinate of the robot.
 * @param curr_y Current y-coordinate of the robot.
 * @param path The current path string representing the moves.
 * @param consecutive_steps Count of consecutive steps in the last direction.
 * @param last_move The last direction moved ('N', 'S', 'E', 'W').
 */
void GreedyRobot::FindPathsHelper(int curr_x, int curr_y, string path, int consecutive_steps, char last_move) {
    // Base case: If the robot has reached the treasure
    if (curr_x == xt_ && curr_y == yt_) {
        // Only store paths that match the shortest distance
        if(path.length() == shortest_distance_) {
            paths_.push_back(path);
        }    
        return;
    }

    // Move North if the next direction is valid and direction limits allow
    if (curr_y < yt_ && (last_move != 'N' || consecutive_steps < max_distance_)) {
        FindPathsHelper(curr_x, curr_y + 1, path + 'N', (last_move == 'N') ? consecutive_steps + 1 : 1, 'N');
    }

    // Move South if the next direction is valid and direction limits allow
    if (curr_y > yt_ && (last_move != 'S' || consecutive_steps < max_distance_)) {
        FindPathsHelper(curr_x, curr_y - 1, path + 'S', (last_move == 'S') ? consecutive_steps + 1 : 1, 'S');
    }

    // Move East if the next direction is valid and direction limits allow
    if (curr_x < xt_ && (last_move != 'E' || consecutive_steps < max_distance_)) {
        FindPathsHelper(curr_x + 1, curr_y, path + 'E', (last_move == 'E') ? consecutive_steps + 1 : 1, 'E');
    }

    // Move West if the next direction is valid and direction limits allow
    if (curr_x > xt_ && (last_move != 'W' || consecutive_steps < max_distance_)) {
        FindPathsHelper(curr_x - 1, curr_y, path + 'W', (last_move == 'W') ? consecutive_steps + 1 : 1, 'W');
    }

}
