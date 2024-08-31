package cec.graphql.learn;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/30
 */
public class UserListDataFetcher implements DataFetcher<List<User>> {
    @Override
    public List<User> get(DataFetchingEnvironment environment) throws Exception {
        String arg = environment.getArgumentOrDefault("name", "bob");
        if (arg != null) {
            return FakeDB.users.stream().filter(u -> u.getName().equals(arg)).toList();
        } else {
            return FakeDB.users;
        }
    }
}
