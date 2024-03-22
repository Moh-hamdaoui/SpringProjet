package org.sid.lightecomv1;


import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.dao.ProductRepository;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class LightEcomV2Application implements CommandLineRunner {

    // L'injection de dipendances , une implimentation de l 'interfaces
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public static void main(String[] args) {
        SpringApplication.run(LightEcomV2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> randomNames = Arrays.asList("Apple", "Samsung", "HP", "Dell", "Canon", "Sony", "LG", "Microsoft");

        categoryRepository.save(new Category(null, "Computer", null, null));
        categoryRepository.save(new Category(null, "Printer", null, null));
        categoryRepository.save(new Category(null, "Smart phones", null, null));
        Random rnd = new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i < 10; i++){
                Product p = new Product();
                String randomName = randomNames.get(rnd.nextInt(randomNames.size()));
                p.setName(randomName);
                p.setCurrentPrice(rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                productRepository.save(p);
            }


        });

    }
}
