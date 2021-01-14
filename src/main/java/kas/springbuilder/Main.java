package kas.springbuilder;

import kas.springbuilder.interfaces.Policeman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //CoronaDisinfector coronaDisinfector = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);
        ApplicationContext context = Application.run("kas.springbuilder", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
