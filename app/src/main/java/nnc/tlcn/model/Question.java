package nnc.tlcn.model;

public class Question {
    public String question;
    public String caseA;
    public String caseB;
    public String caseC;
    public String caseD;
    public String trueCase;
            int level;

    public Question(){
    }

    public Question(String question, String caseA,
                    String caseB, String caseC,
                    String caseD, String trueCase, int level) {
        this.question = question;
        this.caseA = caseA;
        this.caseB = caseB;
        this.caseC = caseC;
        this.caseD = caseD;
        this.trueCase = trueCase;
        this.level = level;
    }
    @Override
    public String toString() {
        return question+"\n"+
                "level"+level+"\n"+
                "A:"+caseA+"\n"+
                "B:"+caseB+"\n"+
                "C:"+caseC+"\n"+
                "D:"+caseD+"\n"+
                "Answer:"+trueCase+"\n";
    }

    public int getLevel() {
        return level;
    }

    public String getQuestion() {
        return question;
    }

    public String getCaseA() {
        return caseA;
    }

    public String getCaseB() {
        return caseB;
    }

    public String getCaseC() {
        return caseC;
    }

    public String getCaseD() {
        return caseD;
    }

    public String getTrueCase() {
        return trueCase;
    }

}