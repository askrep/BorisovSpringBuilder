package kas.springbuilder.interfaces;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
