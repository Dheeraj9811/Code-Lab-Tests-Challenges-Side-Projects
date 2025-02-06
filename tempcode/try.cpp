#include <windows.h>
#include <iostream>
#include <thread>
#include <chrono>

void pressKey(WORD key) {
    INPUT ip;
    ip.type = INPUT_KEYBOARD;
    ip.ki.wVk = key;  // Virtual Key Code
    ip.ki.dwFlags = 0;  // Key press
    SendInput(1, &ip, sizeof(INPUT));

    Sleep(50);  // Small delay

    ip.ki.dwFlags = KEYEVENTF_KEYUP;  // Key release
    SendInput(1, &ip, sizeof(INPUT));
}

void moveMouse(int x, int y) {
    SetCursorPos(x, y);  // Moves the mouse cursor to (x, y) position
}

int main() {
    int startX = 100, startY = 100;
    // Final position (e.g., (500, 500))
    int endX = 500, endY = 500;
    // getting screen resolution 
    int screenWidth = GetSystemMetrics(SM_CXSCREEN);
    int screenHeight = GetSystemMetrics(SM_CYSCREEN);

    std::cout << "Moving mouse from (" << startX << ", " << startY << ") to (" << endX << ", " << endY << ")" << std::endl;
    
    // Move the mouse to the initial positiona
    moveMouse(startX, startY);
    // std::this_thread::sleep_for(std::chrono::milliseconds(500));  // Delay for visual effect

    // Move the mouse to the final position
    moveMouse(endX, endY);

    moveMouse(screenWidth,screenHeight);

    std::cout << "Simulating 'A' key press..." << std::endl;
    pressKey(0x41);  // 0x41 = 'A'
    return 0;
}