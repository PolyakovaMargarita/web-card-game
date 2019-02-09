package ua.od.game.repository.dao.impl;

import ua.od.game.model.AchievementEntity;
import ua.od.game.model.BuildingSetEntity;
import ua.od.game.model.ResourceSetEntity;
import ua.od.game.model.UpgradeSetEntity;
import ua.od.game.repository.dao.AchievementDao;
import ua.od.game.repository.helper.SqlHelper;


import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {

    private static final String GET_ALL_ACHIEVEMENT_QUERY = "SELECT * FROM Achievement";

    private static final String GET_ALL_RESOURSE_QUERY =
            "SELECT a.name, a.description,rs.id,rs.set_id,rs.amount " +
            "FROM Achievement a " +
            "INNER JOIN Resource_Set rs on a.resource_set_id = rs.set_id;";

    private static final String GET_ALL_BUILDING_QUERY =
            "SELECT b.id, b.set_id, b.building_id, a.name, a.description " +
            "From Achievement a " +
            "INNER JOIN Building_Set b on a.upgrade_set_id = b.building_id; ";

    private static final String GET_ALL_UPGRADE_QUERY =
            "SELECT u.id, u.set_id, u.upgrade_id, a.name, a.description " +
            "FROM Achievement a " +
            "INNER JOIN Upgrade_Set u on a.upgrade_set_id = u.upgrade_id; ";

    @Override
    public List<AchievementEntity> getAllAchievementList() {
        return SqlHelper.prepareStatement(GET_ALL_ACHIEVEMENT_QUERY, query -> {
            ResultSet resultSet = query.executeQuery();
            List<AchievementEntity> achievementEntityList = new LinkedList<>();
            while (resultSet.next()) {
                achievementEntityList.add(new AchievementEntity() {{
                    setDescription(resultSet.getString("description"));
                    setId(resultSet.getInt("id"));
                    setName(resultSet.getString("name"));
                }});
            }
            return achievementEntityList;
        });
    }

    @Override
    public List<AchievementEntity> getAchievementResources() {
        return SqlHelper.prepareStatement(GET_ALL_RESOURSE_QUERY, query -> {
            ResultSet resultSet = query.executeQuery();
            List<ResourceSetEntity> resourceSetEntities = new LinkedList<>();
            List<AchievementEntity> achievementEntityList = new LinkedList<>();
            while (resultSet.next()) {
                resourceSetEntities.add(new ResourceSetEntity() {{
                    setId(resultSet.getInt("id"));
                    setSetId(resultSet.getInt("set_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
                achievementEntityList.add(new AchievementEntity() {{
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));
                    setResourceSetList(resourceSetEntities);
                }});

            }
            return achievementEntityList;
        });
    }

    @Override
    public List<AchievementEntity> getAchievementBuildings() {
        return SqlHelper.prepareStatement(GET_ALL_BUILDING_QUERY, query -> {
            ResultSet resultSet = query.executeQuery();
            List<BuildingSetEntity> buildingSetEntities = new LinkedList<>();
            List<AchievementEntity> achievementEntityList = new LinkedList<>();
            while (resultSet.next()) {
                buildingSetEntities.add(new BuildingSetEntity() {{
                    setId(resultSet.getInt("id"));
                    setSetId(resultSet.getInt("set_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
                achievementEntityList.add(new AchievementEntity() {{
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));
                    setBuildingSetList(buildingSetEntities);
                }});
            }
            return achievementEntityList;
        });
    }

    @Override
    public List<AchievementEntity> getAchievementUpgrades() {
        return SqlHelper.prepareStatement(GET_ALL_UPGRADE_QUERY, query -> {
            ResultSet resultSet = query.executeQuery();
            List<UpgradeSetEntity> upgradeSetEntities = new LinkedList<>();
            List<AchievementEntity> achievementEntityList = new LinkedList<>();
            while (resultSet.next()) {
                upgradeSetEntities.add(new UpgradeSetEntity() {{
                    setId(resultSet.getInt("id"));
                    setSetId(resultSet.getInt("set_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
                achievementEntityList.add(new AchievementEntity() {{
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));
                    setUpgradeSetList(upgradeSetEntities);
                }});
            }
            return achievementEntityList;
        });
    }
}
