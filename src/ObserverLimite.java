public class ObserverLimite {
    static void update(Coche coche){
          if (coche.velocidad > 120){
            View.avisoObserver();
        }


    }
}
