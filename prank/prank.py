import ctypes
import time

def show_message_box(message, title="Surprise!"):
    """
    Displays a message box with the given message and title.
    """
    ctypes.windll.user32.MessageBoxW(0, message, title, 0x40 | 0x1)

def prank():
    """
    Displays a funny message in a series of message boxes.
    """
    time.sleep(1)  # Wait before showing the first message
    show_message_box("Hey, are you still there?")
    
    time.sleep(2)  # Wait before showing the next message
    show_message_box("I hope you're ready for a surprise...")
    
    time.sleep(2)  # Wait before showing the final message
    show_message_box("Just kidding! 😄")

if __name__ == "__main__":
    prank()
