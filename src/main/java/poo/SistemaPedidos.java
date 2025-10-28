package poo;
import poo.Carrinho.Produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class SistemaPedidos {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    //Lista de todos os produtos(suas infos)
    @GetMapping("/produtos")
    public List<Produto> Produtos() {
        ArrayList<Produto> produtoL = new ArrayList<>();

        //buffer lê na memória ram
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("produtos.csv"))){

            //ignora cabeçalho
            String linha = bufferedReader.readLine();

            while((linha = bufferedReader.readLine())!= null){

                String colunas[] = linha.split(",");

                String id = colunas[0];
                String nome = colunas[1];
                Double preco = Double.parseDouble(colunas[2]);
                String descricao = colunas[3];
                int estoque = Integer.parseInt(colunas[4]);

                Produto produto1 = new Produto(nome, preco, id, estoque, descricao);
                produtoL.add(produto1);
            }


        } catch (IOException e){
            System.out.println("Erro com o arquivo: " + e.getMessage());
        } 
        return  produtoL;
    }
}
