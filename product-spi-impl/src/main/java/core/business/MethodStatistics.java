package core.business;

public class MethodStatistics {

    private String className;

    private String methodName;

    private Long cost;

    public MethodStatistics(String className, String methodName, Long cost) {
        this.className = className;
        this.methodName = methodName;
        this.cost = cost;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
