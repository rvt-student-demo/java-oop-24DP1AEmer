package rvt;

public enum ConsoleColors {
    RED("\u001B[31m");

    private final String code;

    ConsoleColors(String code) {
        this.code = code;
    }
}