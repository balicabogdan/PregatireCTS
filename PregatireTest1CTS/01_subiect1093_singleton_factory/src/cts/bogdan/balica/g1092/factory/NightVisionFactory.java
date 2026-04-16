package cts.bogdan.balica.g1092.factory;

public class NightVisionFactory implements IModuleFactory {
    @Override
    public AbstractModule createModule() {
        return new NightVisionModule();
    }
}
