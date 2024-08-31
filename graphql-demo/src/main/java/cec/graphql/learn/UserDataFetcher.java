package cec.graphql.learn;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/29
 */
public class UserDataFetcher implements DataFetcher<User> {
    @Override
    public User get(DataFetchingEnvironment environment) throws Exception {
        // 请求数据库
        // 请求其他已有的API
        Integer id = environment.getArgumentOrDefault("id", 2);
        if (id != null) {
            return FakeDB.users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        } else {
            return FakeDB.users.get(0);
        }
    }
}
