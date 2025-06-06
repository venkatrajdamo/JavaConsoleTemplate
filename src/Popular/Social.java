package Popular;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Social implements MostPopular{

    HashMap<Integer, Integer> populatityMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> populatityContentMap = new HashMap<>();
    int maxPopular = 0;
    public void newContent(Integer contentId){
        populatityMap.putIfAbsent(contentId, 0);
        populatityContentMap.putIfAbsent(0, new HashSet<>());
        populatityContentMap.get(0).add(contentId);
    }

    @Override
    public void increasePopularity(Integer contentId) {
        int currentPopularity = populatityMap.getOrDefault(contentId, 0);
        if(populatityMap.containsKey(contentId)) {
            populatityContentMap.get(currentPopularity).remove(contentId);
            currentPopularity++;
            populatityMap.put(contentId, currentPopularity);
            populatityContentMap.putIfAbsent(currentPopularity, new HashSet<>());
            populatityContentMap.get(currentPopularity).add(contentId);
            this.maxPopular = Math.max(this.maxPopular, currentPopularity);
            return;
        }
        this.newContent(contentId);
    }

    @Override
    public void decreasePopularity(Integer contentId) {
        int currentPopularity = populatityMap.getOrDefault(contentId, 0);
        if(populatityMap.containsKey(contentId) && populatityMap.get(contentId) > 0) {
            populatityContentMap.get(currentPopularity).remove(contentId);
            if(populatityContentMap.get(currentPopularity).isEmpty()) populatityContentMap.remove(currentPopularity);
            if(this.maxPopular == currentPopularity && !populatityContentMap.containsKey(currentPopularity)) {
                this.maxPopular = currentPopularity = 1;
            };
            currentPopularity--;
            populatityMap.put(contentId, currentPopularity);
            populatityContentMap.putIfAbsent(currentPopularity, new HashSet<>());
            populatityContentMap.get(currentPopularity).add(contentId);
            return;
        }
        this.newContent(contentId);
    }

    @Override
    public Integer mostPopular(){
        if(populatityContentMap.size() <= 1)
            return -1;
        return populatityContentMap.get(maxPopular).stream().findFirst().get();
    }
}
