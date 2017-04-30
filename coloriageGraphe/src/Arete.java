import java.util.ArrayList;

public abstract class Arete {
    private Sommet s1;
    private Sommet s2;

    /**
     * Constructeur de l'objet Arete
     * @param s1
     * @param s2
     */
    public Arete(Sommet s1, Sommet s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * Verifier qu'un sommet appartient à l'arête
     * @param s
     * @return true si le sommet appartient, false sinon
     */
    public boolean isInArete(Sommet s){
        return (this.s1 == s || this.s2 ==s);
    }

    /**
     * Renvoie les 2 sommets reliés par l'arête
     * @return Liste des sommets
     */
    public ArrayList<Sommet> getSommets(){
        ArrayList<Sommet> sommets= new ArrayList<Sommet>();
        sommets.add(this.s1);
        sommets.add(this.s2);
        return sommets;
    }

    /**
     * Renvoyer l'autre sommet de la liaison avec l'arête
     * @param s sommet dont on veut le voisin
     * @return Sommet voisin
     */
    public Sommet getOppositeSommet(Sommet s){
        return (s==this.s1?this.s1:this.s2);
    }
}
