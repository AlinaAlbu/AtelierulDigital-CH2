package lab2.challange2;

public class Film {
    private Integer anAparatie;
    private String nume;
    private Actor[] actori;

    public Film(Integer anAparatie, String nume, Actor[] actori) {
        this.anAparatie = anAparatie;
        this.nume = nume;
        this.actori = actori;
    }

    public Integer getAnAparatie() {
        return anAparatie;
    }

    public String getNume() {
        return nume;
    }

    public Actor[] getActori() {
        return actori;
    }

    public boolean getActorByName(String actorName){
        for(Actor actor: actori){
            if(actor.getNume().equals(actorName)){
                return true;
            }
        }
        return false;
    }

    public boolean hasActorsAbove(int age){
        for (Actor actor : actori) {
            if (actor != null && actor.getVarsta() > age) {
                return true;
            }
        }
        return false;
    }
}
