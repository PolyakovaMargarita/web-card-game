package ua.od.game.repository.dao.impl;

import ua.od.game.model.AchievementEntity;
import ua.od.game.repository.dao.AchievementDao;
import ua.od.game.repository.helper.SqlHelper;


import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {

    private static final String GET_ALL_ACHIEVEMENT_QUERY = "SELECT * FROM Achievement";
//    private static final String GET_ALL_ACHIEVEMENT_QUERY = "SELECT us.id, us.set_id, us.upgrade_id upgrade_set_id,\n" +
//                                                                    "bs.id, bs.set_id, bs.building_id building_set_id," +
//                                                                    "rs.id,rs.set_id,rs.resource_id resource_set_id," +
//                                                                    "a.name, a.description" +
//                                                            "FROM Achievement a" +
//                                                                    "INNER JOIN Building_Set bs on a.building_set_id = bs.building_id" +
//                                                                    "INNER JOIN Upgrade_Set us on a.upgrade_set_id = us.upgrade_id" +
//                                                                    "INNER JOIN Resource_Set rs on a.resource_set_id = us.upgrade_id;";

//    private static final String GET_ALL_RESOURSE_QUERY = "SELECT rs.id, rs.set_id, rs.resource_id, a.name, a.description " +
//                                                         "From Achievement a " +
//                                                         "INNER JOIN Resource_Set rs on a.upgrade_set_id = rs.building_id; ";
//
//    private static final String GET_ALL_BUILDING_QUERY = "SELECT b.id, b.set_id, b.building_id, a.name, a.description " +
//                                                         "From Achievement a " +
//                                                         "INNER JOIN Building_Set b on a.upgrade_set_id = b.building_id; ";
//
//    private static final String GET_ALL_UPGRADE_QUERY = "SELECT u.id, u.set_id, u.upgrade_id, a.name, a.description " +
//                                                        "FROM Achievement a " +
//                                                        "INNER JOIN Upgrade_Set u on a.upgrade_set_id = u.upgrade_id; ";
/*
SELECT us.id, us.set_id, us.upgrade_id upgrade_set_id,
       bs.id, bs.set_id, bs.building_id building_set_id,
       rs.id,rs.set_id,rs.resource_id resource_set_id,
       a.name, a.description
FROM Achievement a
        INNER JOIN Building_Set bs on a.building_set_id = bs.building_id
        INNER JOIN Upgrade_Set us on a.upgrade_set_id = us.upgrade_id
        INNER JOIN Resource_Set rs on a.resource_set_id = us.upgrade_id;
 */
    @Override
    public List<AchievementEntity> getAllAchievementList() {
        return SqlHelper.prepareStatement(GET_ALL_ACHIEVEMENT_QUERY, query -> {
            ResultSet resultSet = query.executeQuery();
            List<AchievementEntity> achievementEntityList = new LinkedList<>();
            while (resultSet.next()) {
                achievementEntityList.add(new AchievementEntity() {{
                    setId(resultSet.getInt("id"));
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));
                }});
            }
            return achievementEntityList;
        });
    }
//    private List<AchievementEntity> getAchievementBuildings() {
//        return SqlHelper.prepareStatement(GET_ALL_BUILDING_QUERY, query ->{
//            ResultSet resultSet = query.executeQuery();
//            List<AchievementEntity> achievementEntityList = new LinkedList<>();
//            while (resultSet.next()){
//                achievementEntityList.add(new AchievementEntity(){{
//
//                }});
//            }
//            return achievementEntityList;
//        });
//    }
//    private List<AchievementEntity> getAchievementUpgrade() {
//        return SqlHelper.prepareStatement(GET_ALL_UPGRADE_QUERY, query ->{
//            ResultSet resultSet = query.executeQuery();
//            List<AchievementEntity> achievementEntityList = new LinkedList<>();
//            while (resultSet.next()){
//                achievementEntityList.add(new AchievementEntity(){{
//
//                }});
//            }
//            return achievementEntityList;
//        });
//    }
//
}
