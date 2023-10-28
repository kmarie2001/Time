import java.util.Arrays;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }


    public void increment(int seconds) {
        if (seconds >= 60) {
            int secondsToMinutes = seconds / 60;
            minutes = minutes + secondsToMinutes;
            seconds = seconds % 60;
            this.seconds = seconds;
        }
        if (minutes >= 60) {
            int minutesToHours = minutes / 60;
            hours = hours + minutesToHours;
            minutes = minutes % 60;
        }
        if (hours >= 24){
            hours = hours % 24;
        }
    }
    public void print(boolean military) {
        if (military) {
            // print 24-hour
            System.out.println(String.format("%02d,%02d,%02d", hours, minutes, seconds));
        } else {
            //print 12 hour am pm format
            if (hours == 0) {
                hours = hours + 12;
                System.out.println(String.format("%02d,%02d,%02d", hours, minutes, seconds) + " AM");
            } else if (hours < 12) {
                System.out.println(String.format("%02d,%02d,%02d", hours, minutes, seconds) + " AM");
            } else if (hours == 12) {
                System.out.println(String.format("%02d,%02d,%02d", hours, minutes, seconds) + " PM");
            } else if (hours > 12) {
                hours = hours - 12;
                System.out.println(String.format("%02d,%02d,%02d", hours, minutes, seconds) + " PM");
            }

        }
    }
    public static Time fromString(String timeInput){

        String[] split = timeInput.split(":");
        String hoursString = split[0];
        String minutesString = split[1];
        String secondsString = split[2];
        int hours = Integer.parseInt(hoursString);
        int minutes = Integer.parseInt(minutesString);
        int seconds = Integer.parseInt(secondsString);
        Time display = new Time(hours, minutes, seconds);
        return display;
    }
}
