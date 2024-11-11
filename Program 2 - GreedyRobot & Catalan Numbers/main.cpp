#include "GreedyRobot.h"
#include <iostream>
#include <string>
using namespace std;

int main(int argc, char* argv[]) {
    if (argc != 6) {
        cerr << "Error: Missing inputs\n";
        return 1;
    }

    int max_distance = stoi(argv[1]);
    int robot_x = stoi(argv[2]);
    int robot_y = stoi(argv[3]);
    int treasure_x = stoi(argv[4]);
    int treasure_y = stoi(argv[5]);

    GreedyRobot robot(max_distance, robot_x, robot_y, treasure_x, treasure_y);
    robot.FindPaths();

    const auto& paths = robot.GetPaths();
    if(paths.empty()) {
        cout << "No possible path" << endl;
    }
    else {
        for(const string& path : paths) {
            cout << path << endl;
        }
        cout << "Number of paths: " << robot.GetPathCount() << endl;
    }

    return 0;
}