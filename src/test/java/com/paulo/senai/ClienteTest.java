package com.paulo.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paulo.senai.domain.Cliente;
import com.paulo.senai.repositories.ClienteRepositories;
@SpringBootTest
public class ClienteTest {

	public class clienteTest {

		@Autowired
		ClienteRepositories clienteRepositories;

		@Test
		void Cliente() {
			Cliente cli = new Cliente();
			cli.setIdCliente(null);
			cli.setNome("Paulo Dutra");
			cli.setCpfOuCnpj("214231560");
			cli.setEmail("paulo69@gmail.com");
			clienteRepositories.save(cli);
		}

		@Test
		public void listaCliente() {
			List<Cliente> List = clienteRepositories.findAll();
			assertThat(List).size().isGreaterThan(0);
		}

		@Test
		public void idCliente() {
			Cliente cliente = clienteRepositories.findById(1).get();
			assertEquals("Paulo Dutra", cliente.getNome());
		}

		@Test
		public void updateCliente() {
			Cliente cliente = clienteRepositories.findById(1).get();
			cliente.setNome("Paulo Dutra");
			clienteRepositories.save(cliente);
			assertNotEquals("Paulo", cliente.getNome());
		}

	@Test
	public void deleteCliente() {
		clienteRepositories.deleteById(1);
		assertThat(clienteRepositories.existsById(1));
	}
	@Test 
	public void somar() {
		double num = 5.0;
		double num2 = 10.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num, num2);
		assertEquals(15, soma);
	}
	@Test 
	public void subtrair() {
		double num = 10.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double subtrair = cliente.subtrair(num, num2);
		assertEquals(15, subtrair);
	}
	@Test 
	public void mutiplicar() {
		double num = 5.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double mutiplicar = cliente.mutiplicar(num, num2);
		assertEquals(15, mutiplicar);
	}
	@Test 
	public void dividir() {
		double num = 5.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double dividir = cliente.dividir(num, num2);
		assertEquals(15, dividir);
	}
	}
}

