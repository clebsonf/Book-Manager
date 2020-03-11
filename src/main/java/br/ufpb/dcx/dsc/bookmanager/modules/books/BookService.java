package br.ufpb.dcx.dsc.bookmanager.modules.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {
	@Autowired
	private BookRepository repository;
    
    public BookModel save(BookModel livro){
        return repository.save(livro);
    }

    public List<BookModel>  findAll(){
        return repository.findAll();
    } 

    public Optional<BookModel> findById(int id){
        return repository.findById(id);
    }

    public BookModel update(int id, BookModel livro){
        BookModel livroAntigo = repository.findById(id).get();
		livro.setId(livroAntigo.getId());
		return repository.save(livro);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}
