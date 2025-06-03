public class ObserverLimite {
    static void update(Coche coche){
          if (coche.gasolina < 10){
            View.avisoObserver();
        }


    }
}
