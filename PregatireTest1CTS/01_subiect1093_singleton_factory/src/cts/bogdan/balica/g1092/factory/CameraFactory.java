package cts.bogdan.balica.g1092.factory;

public class CameraFactory implements IModuleFactory {
    @Override
    public AbstractModule createModule() {
        return new CameraModule();
    }
}
