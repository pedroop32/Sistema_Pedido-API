package poo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SistemaPedidos {

        public static void main(String[] args) {
            SpringApplication.run(SistemaPedidos.class, args);
        }

        @GetMapping("/hello")
        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
            return String.format("Hello %s!", name);
        }

        @GetMapping("/produto")
        public Produto produto(){
            Produto p1 = new Produto("Labubu", 1000.00, "666", 4, "Do mal");
            return p1;
        }
}

