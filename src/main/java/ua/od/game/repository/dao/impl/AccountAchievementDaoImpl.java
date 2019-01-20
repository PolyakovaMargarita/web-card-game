package ua.od.game.repository.dao.impl;

import ua.od.game.dto.AccountAchievementDto;
import ua.od.game.model.AccountAchievementEntity;
import ua.od.game.repository.dao.AccountAchievementDao;
import ua.od.game.repository.helper.SqlHelper;

import javax.management.Query;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AccountAchievementDaoImpl implements AccountAchievementDao {

    private static final String GET_ACCOUNT_ACHIEVEMENT_LIST = "SELECT * FROM Account_Achievement WHERE account_id = ?";
    private static final String GET_ACCOUNT_ACHIEVEMENT_LIST_1 = "SELECT * FROM Account_Achievement WHERE account_id = 1";
    private static final String ADD_ACHIEVEMETN_TO_ACCOUNT = "";


//    @Override
//    public List<AccountAchievementEntity> getUserAchievementsList(Integer accountId) {
//        accountId.toString();
//        String getAccountAchievement = GET_ACCOUNT_ACHIEVEMENT_LIST_1 + accountId;
//        return SqlHelper.prepareStatement(getAccountAchievement, query -> {
//            ResultSet resultSet = query.executeQuery();
//            List<AccountAchievementEntity> result = new LinkedList<>();
//            while (resultSet.next()) {
//                result.add(new AccountAchievementEntity() {{
//                    setId(resultSet.getInt("id"));
//                    setAmount(resultSet.getFloat("amount"));
//                    setAchievementId(resultSet.getInt("achievement_id"));
//                    setAccountAchievementId(resultSet.getInt("account_id"));
//                }});
//            }
//            return result;
//        });
//    }

//        @Override
//    public List<AccountAchievementEntity> getUserAchievementsList(Integer accountId) {
//        return SqlHelper.prepareStatement(GET_ACCOUNT_ACHIEVEMENT_LIST, query -> {
//            query.setInt(1,accountId);
//            ResultSet resultSet = query.executeQuery();
//            List<AccountAchievementEntity> result = new LinkedList<>();
//            while (resultSet.next()) {
//                result.add(new AccountAchievementEntity() {{
//                    setId(resultSet.getInt("id"));
//                    setAccountAchievementId(resultSet.getInt("account_id"));
//                    setAchievementId(resultSet.getInt("achievement_id"));
//                    setAmount(resultSet.getFloat("amount"));
//                }});
//            }
//            return result;
//        });
//    }

    @Override
    public List<AccountAchievementEntity> getUserAchievementsList(Integer accountId) {
        accountId.toString();
        String getAccountAchievement = GET_ACCOUNT_ACHIEVEMENT_LIST_1 + accountId;
        return SqlHelper.createStatement(query ->{
            ResultSet resultSet = query.executeQuery(getAccountAchievement);
            List<AccountAchievementEntity> entities = new LinkedList<>();
            while (resultSet.next()){
                entities.add(new AccountAchievementEntity(){{
                    setId(resultSet.getInt("id"));
                    setAccountAchievementId(resultSet.getInt("account_id"));
                    setAchievementId(resultSet.getInt("achievement_id"));
                    setAmount(resultSet.getFloat("amount"));
                }});
            }
            return entities;
                }

        );
    }

    public List<AccountAchievementEntity> addAchievementToAccount(Integer accountId){
        return null;
    }
}
