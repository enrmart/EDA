package es.uva.inf.eda;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    
    private Map<Integer, Integer> map;

    
    private Map<Integer, Integer> weightMap;
    
    public DisjointSet() {
    	map=new HashMap();
    	weightMap=new HashMap();
    }
    
    public void makeSet(Integer item) {
        map.put(item, item);
        weightMap.put(item, 1);
    }
    
    public int findSet(int item) {
        int raiz = item;
        if (raiz != map.get(raiz)) {
			raiz = findSet(map.get(raiz));
		}
        return raiz;
    }

   
    public void union(int item1,int item2) {
        int raizItem1 = findSet(item1);
        int raizItem2 = findSet(item2);
        if (raizItem1 != raizItem2) {
            int raizpesos1 = weightMap.get(raizItem1);
            int raizpesos2 = weightMap.get(raizItem2);
            if (raizpesos1 >= raizpesos2) {
                map.put(raizItem2, raizItem1);
                weightMap.put(raizItem1, raizpesos1 + raizpesos2);
            } else {
                map.put(raizItem1, raizItem2);
                weightMap.put(raizItem2, raizpesos1 + raizpesos2);
            }
        }
    }
    
    public Map<Integer,Integer> getMappes(){
    	return weightMap;
    }
    
    
    public Map <Integer,Integer> getMap(){
    	return map;
    }
    
    
}