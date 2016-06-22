package com.example.cloud.Incoding;
public class ModelStateException extends Throwable {
    private JsonModelStateData[] state;

    public ModelStateException(JsonModelStateData[] state) {
        this.state = state;
    }

    public JsonModelStateData[] getState() {
        return state;
    }
}
