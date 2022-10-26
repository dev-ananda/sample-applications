package dev.ananda.kafka.producer.controller;

import java.util.UUID;

import dev.ananda.kafka.producer.service.KafkaMessageProducer;
import dev.ananda.classification.proto.TransactionTag.ClassificationUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class KafkaMessageController {

	@Autowired
	private KafkaMessageProducer messageProducer;

	private String topic = "sample-test-001";

	private int counter = 0;
	
	@PostMapping(value = "/publish-message")
	public void sendMessageToKafkaTopic(@RequestBody String newMessage) {
		log.error( "new message is {}", newMessage );

		counter++;

//		messageProducer.sendMessage("sample-test-001", newMessage);

		ClassificationUpdateDto request = ClassificationUpdateDto.newBuilder()
				.setId(UUID.randomUUID().toString())
				.setCategory1( "cata" + counter )
				.setCategory2( "catb" + counter )
				.setPropertyId( "prop" + counter )
				.setUnitId( "unit" + counter )
				.addRuleIds( "rule" +counter )
				.build();

		//topic = "dev-classification-test";

		messageProducer.publishProtoMessage( "dev-classification-test", request );

		/*for (int i = 1; i < 15; i++){
			messageProducer.publishProtoMessage(topic,newMessage+" -- "+ i);
		}*/
		
		log.error( "<<<<<<<<DONE>>>>>>>>" );
	}
	
	
}
