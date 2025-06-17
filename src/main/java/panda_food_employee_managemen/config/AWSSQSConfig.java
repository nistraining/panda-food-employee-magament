package panda_food_employee_managemen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AWSSQSConfig {
	
	@Value("${cloud.aws.region.static}")  // Correct property binding
    private String region;
	
	private String accessKey;

    private String secretKey;
	
	public SqsAsyncClient sqsAsyncClient() {
		
		return SqsAsyncClient.builder()
				.region(Region.of(region))
				.credentialsProvider(StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(accessKey, secretKey)
                    )
						).build();
	}
	
	@Primary
	@Bean
	public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
		return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
	}

}
