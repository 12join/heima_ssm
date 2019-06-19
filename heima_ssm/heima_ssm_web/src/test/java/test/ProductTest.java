package test;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
public class ProductTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testFindAll(){
        List<Product> list = productService.findAll();
        for (Product product : list) {
            System.out.println(product);
        }
    }

}
