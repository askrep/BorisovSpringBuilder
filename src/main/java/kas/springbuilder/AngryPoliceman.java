package kas.springbuilder;

import kas.springbuilder.interfaces.Policeman;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Angry policeman says");
    }
}
