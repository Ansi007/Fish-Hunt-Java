
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class FishCollection {
    final ArrayList<Fish> Fishes;
    public FishCollection(){
        Fishes = new ArrayList<>();
    }
    
    public boolean addFish(Fish f){
        return Fishes.add(f);
    }
    
    public List<Fish> getFishes(){
        return new ArrayList<>(Fishes);
    }
}
