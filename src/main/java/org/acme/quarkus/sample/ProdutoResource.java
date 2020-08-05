package org.acme.quarkus.sample;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProdutoResource {

	@GET
	public List<Produto> listarTodos() {
		return Produto.listAll();
	}

	@POST
	@Transactional
	public void createProduto(DtoCadastrarProduto dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setValo(dto.getValor());
		p.persist();
	}

	@PUT
	@Path("{id}")
	@Transactional
	public void updateProduto(@PathParam("id") Long id, DtoCadastrarProduto dto) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		if (produtoOp.isPresent()) {
			Produto produto = produtoOp.get();
			produto.setNome(dto.getNome());
			produto.setValo(dto.getValor());
			produto.persist();

		} else {
			throw new NotFoundException();
		}

	}

	@DELETE
	@Path("{id}")
	@Transactional
	public void deleteProduto(@PathParam("id") Long id) {
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		produtoOp.ifPresentOrElse(Produto::delete, () -> { 
			throw new NotFoundException();
		});

	}

}
