package lab2.challange2;

public class Main {

    public static String[] getSelectedStudios(Studio[] studioDatabase) {
        String[] studioNames = new String[10];
        int i = 0;
        for (Studio currentStudio : studioDatabase) {
            if (currentStudio.count() >= 2) {
                if (i == studioNames.length) {
                    studioNames = new String[studioNames.length + 5];
                    String[] newstudioNames = new String[studioNames.length + 5];
                    for (int j = 0; j < i; j++) {
                        newstudioNames[j] = studioNames[j];
                    }
                    studioNames = newstudioNames;
                }
                studioNames[i++] = currentStudio.getName();
            }

        }
        return studioNames;
    }

    public static void main(String[] args) {
        Premiu oscar1990 = new Premiu("oscar", 1990);
        Premiu oscar2000 = new Premiu("oscar", 2000);
        Premiu oscar2010 = new Premiu("oscar", 2010);
        Premiu oscar2018 = new Premiu("oscar", 2018);

        Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35, new Premiu[]{oscar1990, oscar2000});
        Actor actorOscar2010 = new Actor("actor cu oscar din 2000", 55, new Premiu[]{oscar2010});
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23, new Premiu[]{oscar2018});

        Actor actorFaraPremii01 = new Actor("actor fara oscar 01", 33, new Premiu[]{});
        Actor actorFaraPremii02 = new Actor("actor fara oscar 02", 20, new Premiu[]{});
        Actor actorFaraPremii03 = new Actor("actor fara oscar 03", 20, new Premiu[]{});

        Film film1 = new Film(1990, "film cu actori de oscar1",     new Actor[]{actorOscar1990, actorFaraPremii01});
        Film film2 = new Film(2010, "film cu actori fara premii2", new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film3 = new Film(2010, "film cu actori fara premii3", new Actor[]{actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film4 = new Film(2018, "film cu actori de oscar2",     new Actor[]{actorOscar2010, actorOscar2018, actorFaraPremii02});
        Film film5 = new Film(2018, "film cu actori fara premii5", new Actor[]{actorFaraPremii02, actorFaraPremii03});

        Studio studio1 = new Studio("MGM", new Film[]{film1, film2, film3});
        Studio studio2 = new Studio("Disney", new Film[]{film4, film5});
        Studio studio3 = new Studio("Disney2", new Film[]{film2, film4, film5});
        Studio studio4 = new Studio("Disney3", new Film[]{film5});

        Studio[] studioDatabase = new Studio[]{studio1, studio2, studio3, studio4};

        for (String s : getSelectedStudios(studioDatabase)) {
           System.out.println(s);
        }

        System.out.println("Studio with more than 2 movies : ");
        for (int i = 0; i < studioDatabase.length; i++) {
            if (studioDatabase[i].getFilme().length > 2)
                System.out.println(studioDatabase[i].getName());
        }

        System.out.println("Studio with actor cu 2 premii Oscar : ");
        for (Studio studio : studioDatabase) {
            if (studio.getHasActor("actor cu 2 oscaruri")) {
                System.out.println(studio.getName());
            }
        }

        System.out.println("Movies with actors having above 50 age : ");
        for (Studio studio : studioDatabase) {
            for (Film film : studio.getFilme()) {
                if(film.hasActorsAbove(50)){
                    System.out.println(film.getNume());
                }
            }
        }
    }
}