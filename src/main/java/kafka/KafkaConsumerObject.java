package kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerObject {
	public static void main(String[] args) {
		
		String zookeeper = "192.168.6.83:9092,192.168.6.84:9092,192.168.6.89:9092";
		String groupId = "test-consumer-group";
		String topic = "TEST_LOGINLOG";
		Properties props = new Properties();
		props.put("bootstrap.servers", zookeeper);
		props.put("group.id", groupId);
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));
		ConsumerRecords<String, String> records = consumer.poll(100);
		for (ConsumerRecord<String, String> record : records)
			System.out.printf("offset = %d, key = %s, value = %s\n",
					record.offset(), record.key(), record.value());
	}
}
