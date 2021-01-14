package kas.springbuilder;

import kas.springbuilder.interfaces.Announcer;
import kas.springbuilder.interfaces.InjectByType;
import kas.springbuilder.interfaces.Recommendator;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String s) {
        System.out.println(s);
        recommendator.recommend();
    }
}
