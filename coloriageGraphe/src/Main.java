import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int k=2;

        ArrayList<Sommet> sommets = new ArrayList<Sommet>();

        Sommet a = new Sommet("a");
        Sommet b = new Sommet("b");
        Sommet c = new Sommet("c");
        Sommet d = new Sommet("d");
        Sommet e = new Sommet("e");
        Sommet f = new Sommet("f");
        sommets.add(a);
        sommets.add(b);
        sommets.add(c);
        sommets.add(d);
        sommets.add(e);
        sommets.add(f);


        ArrayList<Arete> aretes = new ArrayList<Arete>();

        Arete fd = new PreferenceArete(f,d);
        Arete ab = new InterferenceArete(a,b);
        Arete bd = new InterferenceArete(b,d);
        Arete fb = new InterferenceArete(f,b);
        Arete ad = new InterferenceArete(a,d);
        Arete ae = new InterferenceArete(a,e);
        Arete af = new InterferenceArete(e,f);
        Arete ec = new InterferenceArete(e,c);
        aretes.add(fd);
        aretes.add(ab);
        aretes.add(bd);
        aretes.add(fb);
        aretes.add(ad);
        aretes.add(ae);
        aretes.add(af);
        aretes.add(ec);
        Graphe graphe = new Graphe(sommets,aretes);
        graphe.colorier(k, graphe);
    }
}

