
public class Sommet {

    private String nom;
    /**
     * - 1 : pas coloré
     *   0 : spillé
     * > 0 : coloré
     */
    private int couleur =-1;//a la base aucun sommet n'est colorié

    /**
     * Constructeur de l'objet Sommet
     * @param nom
     */
    public Sommet(String nom){
        this.nom = nom;
    }

    /**
     * Renvoyer le nom du sommet
     * @return
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Renvoyer la couleur du sommet
     * @return
     */
    public int getCouleur(){
        return this.couleur;
    }

    /**
     * Affecter une couleur au sommet
     * @param couleur
     */
    public void setCouleur(int couleur){
        this.couleur = couleur;
    }

    /**
     * Savoir si un sommet est coloré
     * @return true si la sommet est coloré, false sinon
     */
    public boolean isColored(){
        return this.couleur != -1;
    }

    /**
     * Spiller un sommet
     */
    public void spill(){
        this.setCouleur(0);
    }
}
