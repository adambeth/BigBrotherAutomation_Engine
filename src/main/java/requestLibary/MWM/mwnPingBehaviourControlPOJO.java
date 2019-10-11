package requestLibary.MWM;

public class mwnPingBehaviourControlPOJO {
    private String httpStatus;

    public mwnPingBehaviourControlPOJO(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public mwnPingBehaviourControlPOJO() {
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "ClassPojo [httpStatus = " + httpStatus + "]";
    }
}
