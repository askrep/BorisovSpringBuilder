package kas.springbuilder;

public class ConsoleAnnouncer implements Announcer {

    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);
    @Override
    public void announce(String s) {
        System.out.println(s);
        recommendator.recommend();
    }
}
