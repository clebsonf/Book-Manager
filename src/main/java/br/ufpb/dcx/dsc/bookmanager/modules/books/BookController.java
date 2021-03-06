package br.ufpb.dcx.dsc.bookmanager.modules.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/livros")
public class BookController {
	@Autowired
	private BookService service;
	
	@PostMapping
	@ResponseBody
	public BookModel adcionarLivro(@RequestBody BookModel livro) {
		return service.save(livro);
	}
	
	@GetMapping
	@ResponseBody
	public List<BookModel> listarLivros() {
	  return service.findAll();
	}
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<BookModel> obterLivro(@PathVariable("id") int id){
		return service.findById(id);
	}
	@PutMapping("/{id}")
	@ResponseBody
	public BookModel editarLivro(@PathVariable("id") int id, @RequestBody BookModel novoLivro) {
		return service.update(id,novoLivro);
	}
	@DeleteMapping("/{id}")
	public void removerLivro(@PathVariable("id") int id) {
		service.delete(id);
	}
	
	
}
