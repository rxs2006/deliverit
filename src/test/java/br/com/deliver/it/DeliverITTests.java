package br.com.deliver.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.deliver.it.model.Conta;
import br.com.deliver.it.service.ContaService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class DeliverITTests {

	@Autowired
	private ContaService contaService;
	
	//@Test
	void contasAPagar()
	{
		List<Conta> listaContas = contaService.findAll();
		assertNotNull(listaContas);
	}	
}
