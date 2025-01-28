import os
import subprocess
import random
import time

def open_terminal_on_remote(num_times=3, delay=2, screen_width=1920, screen_height=1080):
    # Hacker-like text to display
    hacker_text = """
Accessing secured servers...
Establishing connection...
Connection established.
Downloading sensitive data...
███████████░░░░░░░░ 50%
█████████████████░░ 90%
███████████████████ 100%
Data retrieved successfully!

Data analysis in progress...
Analyzing data...
Data analysis complete.
Shutting down firewall...
Firewall disabled.
Uploading malicious software...
Malicious software uploaded successfully!

Finding vulnerabilities...
███████████░░░░░░░░ 50%
█████████████████░░ 90%
███████████████████ 100%

Vulnerabilities found:
Downloading sensitive data...
Found Robot Code Repository
Found Passwords Database
Found Employee Information
Downloading all data...
███████████░░░░░░░░ 50%
█████████████████░░ 90%
███████████████████ 100%

Data retrieved successfully!

Self-destruct initiated...
███████████░░░░░░░░ 50%
███████████████████ 100%

────────────────────────────────────────────────────────────────────
                        .--.-------|----
                       /           \   
                      |    O   O    |  
                      |      ^      | 
                      |     '-'     |  
                       \   \_____/  /  
                        '-._______.-'
                         *Good bye !!!!  have a great year*
────────────────────────────────────────────────────────────────────
"""

    # Ensure the DISPLAY is set to the remote system's screen
    os.environ['DISPLAY'] = ':1'

    # Escape single quotes and newlines manually for use in the f-string
    escaped_hacker_text = hacker_text.replace("'", "\\'").replace('\n', '\\n')

    # Create a shell script for displaying hacker text
    bash_script = f"""
#!/bin/bash
clear
python3 -c "import time; [print(c, end='', flush=True) or time.sleep(0.05) for c in '{escaped_hacker_text}']"
echo 'Press Enter to exit...'
read
"""

    # Write the shell script to a file on the remote system
    script_path = "/tmp/hacker_simulation.sh"
    with open(script_path, "w") as file:
        file.write(bash_script)

    # Make the script executable
    os.chmod(script_path, 0o755)

    # Open the terminal multiple times at random locations
    for _ in range(num_times):
        # Generate random screen positions
        x = random.randint(0, screen_width - 800)  # Adjust for terminal width
        y = random.randint(0, screen_height - 600)  # Adjust for terminal height

        # Run the shell script in a new terminal emulator with random positioning
        subprocess.run([
            "gnome-terminal",
            "--geometry", f"80x24+{x}+{y}",  # Set terminal size and random position
            "--",
            "bash", "-c", f"{script_path}; exec bash"
        ])

        # Delay between opening terminals
        time.sleep(delay)

# Call the function
open_terminal_on_remote(num_times=5, delay=3, screen_width=1920, screen_height=1080)

