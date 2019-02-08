package ua.od.game.repository.dao;

import ua.od.game.model.AchievementEntity;
import ua.od.game.service.AchievementService;

import java.util.List;

public interface AchievementDao {
    List<AchievementEntity> getAllAchievementList();
    List<AchievementEntity> getAchievementResources();
    List<AchievementEntity> getAchievementBuildings();
    List<AchievementEntity> getAchievementUpdates();
}
