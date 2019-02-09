package ua.od.game.repository.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.od.game.model.AchievementEntity;
import ua.od.game.repository.dao.AchievementDao;
import ua.od.game.repository.dao.DbTest;

import java.util.List;

public class AchievementDaoImplTest extends DbTest {
    AchievementDao achievementDao;

    @Before
    public void init() {
        achievementDao = new AchievementDaoImpl();
    }
    @Test
    public void getAllAchievementList (){
        List<AchievementEntity> achievementEntities = achievementDao.getAllAchievementList();
        for (int i = 0; i < achievementEntities.size(); i++) {
            System.out.println(achievementEntities.get(i).getId() + " ");
            System.out.print(achievementEntities.get(i).getName() + " ");
            System.out.println(achievementEntities.get(i).getDescription() + " ");
        }
        Assert.assertFalse(achievementEntities.isEmpty());
    }
    @Test
    public void getAchievementResourceList(){
        List<AchievementEntity> achievementResources = achievementDao.getAchievementResources();
        for (int i = 0; i < achievementResources.size(); i++) {
            System.out.println(achievementResources.get(i).getName() + " ");
            System.out.println(achievementResources.get(i).getDescription()  + " ");
            System.out.println(achievementResources.get(i).getResourceSetList()  + " ");
            Assert.assertFalse(achievementResources.isEmpty());
        }
    }
    @Test
    public void getAchievementBuildingList(){
        List<AchievementEntity> achievementBuildings = achievementDao.getAchievementBuildings();
        for (int i = 0; i < achievementBuildings.size(); i++) {
            System.out.println(achievementBuildings.get(i).getName() + " ");
            System.out.println(achievementBuildings.get(i).getDescription() + " ");
            System.out.println(achievementBuildings.get(i).getBuildingSetList() + " ");
        }
    }
    @Test
    public void getAchievementUpgradeList(){
        List<AchievementEntity> achievementUpgrades = achievementDao.getAchievementUpgrades();
        for (int i = 0; i < achievementUpgrades.size(); i++) {
            System.out.println(achievementUpgrades.get(i).getName());
            System.out.println(achievementUpgrades.get(i).getDescription());
            System.out.println(achievementUpgrades.get(i).getUpgradeSetList());
        }
    }
}