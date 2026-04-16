package cts.bogdan.balica.g1092.factory;

public class GpsFactory implements IModuleFactory {
    @Override
    public AbstractModule createModule() {
        return new GpsTrackingModule();
    }
}
