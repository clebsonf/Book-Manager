package br.ufpb.dcx.dsc.bookmanager.modules.books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel,Integer>{
}
