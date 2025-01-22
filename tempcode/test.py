import cv2

# Stream URL (adjust the IP and port as needed)
stream_url = 'udp://@0.0.0.0:1235'


# Open the UDP stream with FFMPEG as the backend
cap = cv2.VideoCapture(stream_url, cv2.CAP_FFMPEG)

if not cap.isOpened():
    print(f"Error: Unable to open the UDP stream at {stream_url}")
    exit(1)

print("UDP Stream opened successfully. Press 'q' to quit.")

while True:
    # Read a frame from the stream
    ret, frame = cap.read()

    if not ret:
        print("Error: Unable to fetch frame. Exiting...")
        break

    # Display the frame
    cv2.imshow('UDP Stream', frame)

    # Exit if 'q' is pressed
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release the capture and close any OpenCV windows
cap.release()
cv2.destroyAllWindows()
