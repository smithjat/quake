package springboot_mongodb.common.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBUtils {
    //不通过认证获取连接数据库对象
    public static MongoDatabase getConnect() {
        //连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 7649);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("application");

        //返回连接数据库对象
        return mongoDatabase;
    }

    //需要密码认证方式连接
    public static MongoDatabase getConnect2() {
//        List<ServerAddress> adds = new ArrayList<>();
//        //ServerAddress()两个参数分别为 服务器地址 和 端口
//        ServerAddress serverAddress = new ServerAddress("10.203.139.225", 7649);
//        adds.add(serverAddress);
//
//        List<MongoCredential> credentials = new ArrayList<>();
//        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("mongo", "application", "70ec415068d03e04".toCharArray());
//        credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接

        MongoClientURI uri = new MongoClientURI("mongodb://mongo:70ec415068d03e04@10.203.139.225:7649,10.203.136.81:7649,10.203.177.163:17649/?replicaSet=7649&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=admin");
        MongoClient mongoClient = new MongoClient(uri);

        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("application");

        //返回连接数据库对象
        return mongoDatabase;
    }

    public static Object filterFind(String table, String fieldName, String value) {
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtils.getConnect2();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection(table);

        //指定查询过滤器
        Bson filter = Filters.eq(fieldName, value);
        //指定查询过滤器查询,按照时间倒叙排序取出最新一条数据
        FindIterable findIterable = ((MongoCollection) collection).find(filter).limit(1).sort(new BasicDBObject("started_time",-1));
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            return cursor.next().toString();
        }
        return null;
    }
}
