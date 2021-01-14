package kas.springbuilder;


import kas.springbuilder.interfaces.InjectByType;
import kas.springbuilder.interfaces.Policeman;
import kas.springbuilder.interfaces.Recommendator;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init( ) {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("All Leave room");
    }
}
