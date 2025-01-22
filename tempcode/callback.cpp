#include <iostream>
#include <thread>
#include <chrono>
#include <future>

// Asynchronous callback
void downloadFile(const std::string& url, void (*callback)(bool), std::promise<bool>& downloadPromise) {
    std::thread([url, callback, &downloadPromise]() {
        std::cout << "Downloading file from " << url << "..." << std::endl;

        // Simulate download delay
        std::this_thread::sleep_for(std::chrono::seconds(2));

        bool success = true;  // Assume download succeeded
        callback(success);    // Call the callback with the result

        // Set the promise with the download result (indicating completion)
        downloadPromise.set_value(success);
    }).detach();  // Detach the thread to run independently
}

void onDownloadComplete(bool success) {
    if (success)
        std::cout << "Download completed successfully!" << std::endl;
    else
        std::cout << "Download failed." << std::endl;
}

int main() {
    // Create a promise to indicate when download is finished
    std::promise<bool> downloadPromise;
    std::future<bool> downloadFuture = downloadPromise.get_future();

    // Call downloadFile asynchronously
    downloadFile("http://example.com/file.txt", onDownloadComplete, downloadPromise);

    // Main thread performs other tasks while the download happens
    std::cout << "Performing other tasks while file downloads..." << std::endl;

    // Perform other tasks here (non-blocking)
    for (int i = 0; i < 3; ++i) {
        std::cout << "Main thread is working..." << std::endl;
        std::this_thread::sleep_for(std::chrono::seconds(1));
    }

    // Wait for the download to complete (non-blocking while other tasks are running)
    downloadFuture.get();  // Wait here for download to finish (but program doesn't block main work)

    return 0;
}
