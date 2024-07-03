package entity;

public enum CaseOption {
    UPPERCASE(1),
    PASCAL(2),
    CAMEL(3),
    SNAKE(4),
    SCREAMINGSNAKE(5),
    INVALID(6);

    public final int caseIdentifier;

    CaseOption(int caseIdentifier){
        this.caseIdentifier = caseIdentifier;
    }

    public int getCaseIdentifier(){
        return caseIdentifier;
    }
}
