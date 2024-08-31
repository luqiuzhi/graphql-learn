package cec.graphql.learn;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.File;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/29
 */
public class HelloGraphQL {
    public static void main(String[] args) {
//        String schema = "type Query{User {name}}";
        SchemaParser schemaParser = new SchemaParser();
        File file = new File("C:\\Users\\10122\\IdeaProjects\\graphql-demo\\src\\main\\resources\\Test.graphql");
        TypeDefinitionRegistry parse = schemaParser.parse(file);
//        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
//
        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("personById", new UserDataFetcher()))
                .type("Query", builder -> builder.dataFetcher("peopleByFirstName", new UserListDataFetcher()))
                .build();
//
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(parse, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionInput.Builder builder = ExecutionInput.newExecutionInput("""
                {
                    personById(id:10) {
                        name
                        age
                        books {
                            name
                        }
                    }
                    peopleByFirstName(firstName: "bob") {
                        name
                        age
                    }
                }
                """);
        build.execute(builder);
        ExecutionResult executionResult = build.execute(builder);

        System.out.println(executionResult.getData().toString());
        // Prints: {hello=world}
    }
}

