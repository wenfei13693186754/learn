package kafka;

/**
 * Created by ibf on 12/21.
 */
public class JavaKafkaConsumerHighAPITest {
    public static void main(String[] args) {
    	String zookeeper = "192.168.6.83:2181,192.168.6.84:2181,192.168.6.89:2181";
        String groupId = "test-consumer-group";
        String topic = "TEST_LOGINLOG";
        int threads = 1;
        JavaKafkaConsumerHighAPI example = new JavaKafkaConsumerHighAPI(topic, threads, zookeeper, groupId);
        new Thread(example).start();

        // 执行10秒后结束
        int sleepMillis = 600000;
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭
        example.shutdown();
    }
}
