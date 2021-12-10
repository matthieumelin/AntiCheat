package fr.geeklegend.ac.checks;

public class CheckResult {
    private CheckLevel checkLevel;
    private CheckType checkType;
    private String message;

    public CheckResult(CheckLevel checkLevel, CheckType checkType, String message) {
        this.checkLevel = checkLevel;
        this.checkType = checkType;
        this.message = message;
    }

    public CheckLevel getCheckLevel() {
        return checkLevel;
    }

    public void setCheckLevel(CheckLevel checkLevel) {
        this.checkLevel = checkLevel;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFailed() {
        return checkLevel != CheckLevel.PASSED;
    }
}
