package LogManger;

import WindowManger.Window;

public class Log {

    public void writeLogEvent(Object classInfo,String message)
    {
        System.out.println(classInfo.getClass().getName() + ": Creating New Log Event.");
    }
}
