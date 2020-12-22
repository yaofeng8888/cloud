package george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrder {

	public static void main(String[] args){
		SpringApplication.run(CloudConsumerOrder.class,args);
	}
}
