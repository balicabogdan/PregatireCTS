package cts.student.examen.g1092.factory;

public class MedicFactory implements IPersonalMedicalFactory{
    @Override
    public IPersonalMedical crearePersonal() {
        return new Medic();
    }
}
