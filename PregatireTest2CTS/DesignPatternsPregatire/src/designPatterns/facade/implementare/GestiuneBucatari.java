package designPatterns.facade.implementare;

import java.util.ArrayList;

public class GestiuneBucatari {
    private ArrayList<Bucatar> listaBucatari;

    public int getNrBucatari() { return listaBucatari.size(); }
    public Bucatar getBucatar(int i) { return listaBucatari.get(i); }
}