package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscar(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!. Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

}
