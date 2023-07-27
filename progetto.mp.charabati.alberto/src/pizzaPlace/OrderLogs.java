package pizzaPlace;

import java.util.ArrayList;
import java.util.List;

public class OrderLogs {
    private List<String> logs;

    public OrderLogs() {
        logs = new ArrayList<>();
    }

    public void addLog(String logMessage) {
        logs.add(logMessage);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
    
    public void clearLogs() {
        logs.clear();
    }

}
