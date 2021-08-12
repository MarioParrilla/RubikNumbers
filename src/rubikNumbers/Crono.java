package rubikNumbers;

public class Crono extends Thread{

    int hours, minutes, seconds;
    boolean stop = false;

    public Crono(){
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
    }

    @Override
    public void run() {
        while (!stop){
            seconds++;
            if (seconds==60){
                seconds=0;
                minutes++;
            }
            if (minutes==60){
                minutes=0;
                hours++;
            }
            try {
                sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTime(){
        String time = "";

        if (hours<10) time+="0"+hours+":";
        else time+=hours+":";

        if (minutes<10) time+="0"+minutes+":";
        else time+=minutes+":";

        if (seconds<10) time+="0"+seconds;
        else time+=seconds;

        return time;
    }
    public void stopTime(){
        this.stop=true;
    }
}
