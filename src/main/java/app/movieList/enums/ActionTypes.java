package app.movieList.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActionTypes {
    ADD(1, "Add new movie"),
    SHOW(2, "Show movies list"),
    EXIT(3, "Exit");

    private final int actionId;
    private final String actionName;
    private final static Map<Integer, ActionTypes> mapValues = new HashMap<>();

    ActionTypes(int actionId, String actionName) {
        this.actionId = actionId;
        this.actionName = actionName;
    }

    public int getActionId() {
        return actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public static ActionTypes valueOf(int actionId) {
        return mapValues.get(actionId);
    }

    static {
        for (ActionTypes type: values()) {
            mapValues.put(type.getActionId(), type);
        }
    }
}
