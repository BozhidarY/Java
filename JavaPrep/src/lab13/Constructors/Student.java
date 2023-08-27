package lab13.Constructors;

import lab13.Exceptions.StudentException;

public class Student {
    private String egn;
    private int facN;

    public Student(String egn, int facN) throws StudentException {
        this.setEgn(egn);
        this.setFacN(facN);
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) throws StudentException {
        this.egn = egn;
    }

    public int getFacN() {
        return facN;
    }

    public void setFacN(int facN) {
        this.facN = facN;
    }
}
