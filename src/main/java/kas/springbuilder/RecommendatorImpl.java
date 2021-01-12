package kas.springbuilder;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("To protect drink "+ alcohol);
    }
}
