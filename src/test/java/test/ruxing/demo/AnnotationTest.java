package test.ruxing.demo;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ruxing.demo.core.config.MyConfig;
import ruxing.demo.entity.po.User;
import ruxing.demo.service.UserService;
import ruxing.demo.util.AESUtil;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by ruxing on 30/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
public class AnnotationTest {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = userService.findUserById(4L);
        System.out.println("user_id: " + user.getUserId());
        System.out.println("user_name: " + user.getName());
    }

    @Test
    public void helloGraphQl() {
        GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("hello")
                        .staticValue("world"))
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        Map<String, Object> result = graphQL.execute("{hello}").getData();
        System.out.println(result);
        // Prints: {hello=world}
    }

    @Test
    public void AesUtil() {
        String partnerId = "3942";
        String result = AESUtil.encryptForUrl(partnerId);
        System.out.println(result);
    }

    @Test
    public void testEveryTime() throws Exception {
        FileInputStream fin = new FileInputStream("/Users/ruxing/antx-buick.properties");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        fc.read(buffer);
        System.out.println("end");
    }

}
