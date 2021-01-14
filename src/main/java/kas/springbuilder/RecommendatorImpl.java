package kas.springbuilder;

import kas.springbuilder.interfaces.InjectProperty;
import kas.springbuilder.interfaces.Recommendator;
import kas.springbuilder.interfaces.Singleton;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("whisky")
    private String alcohol;

    public RecommendatorImpl( ) {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("To protect drink " + alcohol);
    }
}
