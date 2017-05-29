public final class Constituency extends SwingModel{

    /// Identification///
    private final String name;
    /// Party Variables///
    private final int Labour15;
    private int Labour17;
    private final int Conservative15;
    private int Conservative17;
    /// Electorate Makeup///
    private final int voters;
    private int electorate;
    private String turnout;

    public Constituency(String name, String labour15, String conservative15, String voterRoll, String turnout) {
        super();
        int lab = Integer.parseInt(labour15);
        int con = Integer.parseInt(conservative15);
        double to = Double.parseDouble(turnout);
        int in = Integer.parseInt(voterRoll);
        
        this.name = name;
        this.Labour15 = new Integer(lab);
        this.Labour17 = new Integer(0);
        this.Conservative15 = new Integer(con);
        this.Conservative17 = new Integer(0);
        this.voters = new Integer(in);
        Integer elec = new Integer(calculateElectorate(to,voters));
        this.electorate = elec;
        String turn = getPercentString(new Double(to));
        this.turnout = turn;
    }

    public String getName() {
        return name;
    }

    public int getLabour15() {
        return new Integer(Labour15);
    }

    public int getLabour17() {
        return new Integer(Labour17);
    }

    public int getConservative15() {
        return new Integer(Conservative15);
    }

    public int getConservative17() {
        return new Integer(Conservative17);
    }

    public int getVoters() {
        return new Integer(voters);
    }

    public int getElectorate() {
        return new Integer(electorate);
    }

    public String getTurnout() {
        return turnout;
    }

}
