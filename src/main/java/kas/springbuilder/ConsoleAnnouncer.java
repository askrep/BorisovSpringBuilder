package kas.springbuilder;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String s) {
        System.out.println(s);
        recommendator.recommend();
    }
}
