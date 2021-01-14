package kas.springbuilder;

@Singleton
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
