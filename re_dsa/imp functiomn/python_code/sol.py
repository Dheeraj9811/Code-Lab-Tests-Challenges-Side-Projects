def time_to_minutes(time_str):
    hours, minutes = map(int, time_str.split(":"))
    hour_angle = (hours % 12) * 30 + minutes * 0.5
    minute_angle = minutes * 6
    time_difference = abs(hour_angle - minute_angle)
    if time_difference > 180:
        time_difference = 360 - time_difference

    relative_speed = 360 / (11 * 60)  # Variable relative speed between the hands
    time_to_collision = time_difference / relative_speed
    minutes_to_collision = int(time_to_collision)

    return minutes_to_collision//10

time_str = input()
minutes_to_collision = time_to_minutes(time_str)
print(f"{int(minutes_to_collision)}")