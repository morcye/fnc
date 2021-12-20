package com.paulo.senai;


import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paulo.senai.domain.Cidade;
import com.paulo.senai.domain.Cliente;
import com.paulo.senai.domain.Endereco;
import com.paulo.senai.domain.Estado;
import com.paulo.senai.domain.enums.TipoCliente;
import com.paulo.senai.repositories.CidadeRepositories;
import com.paulo.senai.repositories.ClienteRepositories;
import com.paulo.senai.repositories.EnderecoRepositories;
import com.paulo.senai.repositories.EstadoRepositories;

@SpringBootApplication
public class PauloSenaiApplication  implements CommandLineRunner {

	@Autowired
	private EstadoRepositories estadoRepositories;
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private EnderecoRepositories enderecoRepositories;
	
	@Autowired
	private CidadeRepositories cidadeRepositories;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PauloSenaiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		estadoRepositories.saveAll(Arrays.asList(est1,est2));
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Osasco", est2);
		cidadeRepositories.saveAll(Arrays.asList(c1,c2));
		
		Cliente cli1 = new  Cliente(null, "Paulo Henrique", "12245678908", "paulohenriquealvesdutra@gmail.com", 
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new  Cliente();
		cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
		cli2.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
		clienteRepositories.saveAll(Arrays.asList(cli1,cli2));
		
		Endereco e1 = new Endereco(null, "Rua da Pão", "90","", "Rocinha", "38401534",cli1,c1);
		Endereco e2 = new Endereco(null, "Adolfinho", "57","", "jardim", "06090014",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		enderecoRepositories.saveAll(Arrays.asList(e1,e2));
		
	}

}



