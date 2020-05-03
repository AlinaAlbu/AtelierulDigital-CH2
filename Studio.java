package lab2.challange2;

public class Studio {
    private String name;
    private Film[] filme;

    public Studio(String name, Film[] filme) {
        this.name = name;
        this.filme = filme;
    }

    public int count(){
        int count = 0;
        for(Film film:filme){
            if(film != null)
                count++;
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public Film[] getFilme() {
        return filme;
    }

    public boolean getHasActor(String actorName){
        for(Film film:filme){
            if (film.getActorByName(actorName) == true){
                return true;
            }
        }
        return false;
    }

}
