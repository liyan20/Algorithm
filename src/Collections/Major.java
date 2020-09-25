package Collections;

import java.io.Serializable;

/**
 * @Author: xianz
 * @Date: 2020/8/31 08:53
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class Major implements Cloneable , Serializable {

    private String majorName;
    private long majorId;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Major(String majorName, long majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorName='" + majorName + '\'' +
                ", majorId=" + majorId +
                '}';
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public long getMajorId() {
        return majorId;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }
}
