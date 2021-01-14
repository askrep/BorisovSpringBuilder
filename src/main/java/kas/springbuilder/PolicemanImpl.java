package kas.springbuilder;

public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommendator recommendator;
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("All Leave room");
    }
}
