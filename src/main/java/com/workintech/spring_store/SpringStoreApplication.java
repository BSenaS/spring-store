package com.workintech.spring_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//--> SpringBootApplication içerisin de aşağıdaki 3 Anatasyon vardır.
//@SpringBootConfiguration -> İşaretlediği sınıfın Konfigürasyon sınıfı olduğunu belirtir.
//@EnableAutoConfiguration -> Uygulama ayağa kaldırıldıgın da pom.xml'i okuyup gerekli dependencyleri indirilmesini sağlar.
//@ComponentScan -> Uygulamamızın içerisindeki tüm componentleri scan eder eğer @Component ile işaretli bir sınıf var ise instance olusturup Spring Containera tanıtır.

//Rest Api üzerine versioning
@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStoreApplication.class, args);
	}

}
